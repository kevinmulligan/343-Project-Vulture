<?php



if (is_file('settings.php'))
{
  include 'settings.php';
}

defined('AWS_API_KEY') or define('AWS_API_KEY', 'API KEY');
defined('AWS_API_SECRET_KEY') or define('AWS_API_SECRET_KEY', 'SECRET KEY');
defined('AWS_ASSOCIATE_TAG') or define('AWS_ASSOCIATE_TAG', 'vulture00-20');


require '../lib/AmazonECS.class.php';

function getResult($searchWord, $category){

	try
	{
		$amazonEcs = new AmazonECS(AWS_API_KEY, AWS_API_SECRET_KEY, 'COM', AWS_ASSOCIATE_TAG);
		$amazonEcs->associateTag(AWS_ASSOCIATE_TAG);
		$result = $amazonEcs->responseGroup('Large')->category($category)->search($searchWord);
	}
	
	catch(Exception $e)
	{
	  echo $e->getMessage();
	}
	
	
	return $result;
}

  function getProducts($searchWord, $category){
   		$response = getResult($searchWord, $category);
   		$items = $response->Items->Item; 
		
		while(count($items) < 1){
			$curl = curl_init();
			curl_setopt_array($curl, array(
				CURLOPT_RETURNTRANSFER => 1,
				CURLOPT_URL => 'http://randomword.setgetgo.com/get.php'
			));
			$searchWord = curl_exec($curl);
			//echo $searchWord;
			sleep(.2);
   			$response = getResult($searchWord, $category);
   			$items = $response->Items->Item; 
   		}
		return $items;
   }
   
   function getItem($items){
	   
	   foreach($items as $item){
		   
		   $image = $item->MediumImage->URL;
		   $link = $item->DetailPageURL;
		   $price = $item->ItemAttributes->ListPrice->FormattedPrice;
		   $title = $item->ItemAttributes->Title;
		   
		   if($image != "" && $price != ""){
			   $arr = array(
			   		'image' => $image,
					'price' => $price,
					'title' => $title,
					'link' => $link);
				break;
		   }
		   
	   }
	   if($arr == null){
		   $arr = getItem(getProducts("php", "Books"));
	   }
	   return $arr;
	   
   }
   
   function printProducts($item){
		   
		   $image = $item[image];
		   $link = $item[link];
		   $price = $item[price];
		   $title = $item[title];
		   echo "
				<a href=\"$link\" style=\"text-decoration:none\">
					<div>
						<img src=\"$image\" alt=\"product\">
						Title: $title Price: $price
					</div>
				</a>
		   
		   ";
   }

 

	if(isset($_POST[search])){
		$searchWord = $_POST[search];
	}else{
		$curl = curl_init();
		curl_setopt_array($curl, array(
    		CURLOPT_RETURNTRANSFER => 1,
    		CURLOPT_URL => 'http://randomword.setgetgo.com/get.php'
		));
	}if($_POST[cat] != ""){
		$category = $_POST[cat];
	}else{
		$category = "Books";
	}

 $items = getProducts($searchWord, $category);
 $item = getItem($items);
 
 if(isset($_POST[html])){
	 printProduct($item);
 }else{
	 echo json_encode($item, JSON_UNESCAPED_SLASHES);
 }
 
?>
