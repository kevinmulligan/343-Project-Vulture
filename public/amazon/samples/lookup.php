<?php
/**
 * For a running Search Demo see: http://amazonecs.pixel-web.org
 */
 
if ("cli" !== PHP_SAPI)
{
    echo "<pre>";
}


if (is_file('sampleSettings.php'))
{
  include 'sampleSettings.php';
}

defined('AWS_API_KEY') or define('AWS_API_KEY', 'API KEY');
defined('AWS_API_SECRET_KEY') or define('AWS_API_SECRET_KEY', 'SECRET KEY');
defined('AWS_ASSOCIATE_TAG') or define('AWS_ASSOCIATE_TAG', 'vulture00-20');

$amazonEcs = null;

require '../lib/AmazonECS.class.php';

function getResult($searchWord){

try
{
    $amazonEcs = new AmazonECS(AWS_API_KEY, AWS_API_SECRET_KEY, 'COM', AWS_ASSOCIATE_TAG);

    // for the new version of the wsdl its required to provide a associate Tag
    // @see https://affiliate-program.amazon.com/gp/advertising/api/detail/api-changes.html?ie=UTF8&pf_rd_t=501&ref_=amb_link_83957571_2&pf_rd_m=ATVPDKIKX0DER&pf_rd_p=&pf_rd_s=assoc-center-1&pf_rd_r=&pf_rd_i=assoc-api-detail-2-v2
    // you can set it with the setter function or as the fourth paramameter of ther constructor above
    $amazonEcs->associateTag(AWS_ASSOCIATE_TAG);
	
	$result = $amazonEcs->responseGroup('Large')->category('Books')->search($searchWord);

    // Looking up multiple items
   // $response = $amazonEcs->responseGroup('Large')->optionalParameters(array('Condition' => 'New'))->lookup('B0017TZY5Y', 'B004DULNPY');
   

}

catch(Exception $e)
{
  echo $e->getMessage();
}


return $result;
}

  function getProducts($searchWord){
   		$response = getResult($searchWord);
   		$items = $response->Items->Item; 
		
		while(count($items) < 1){
			$curl = curl_init();
			curl_setopt_array($curl, array(
				CURLOPT_RETURNTRANSFER => 1,
				CURLOPT_URL => 'http://randomword.setgetgo.com/get.php'
			));
			$searchWord = curl_exec($curl);
			echo $searchWord;
   			$response = getResult($searchWord);
   			$items = $response->Items->Item; 
   		}
		return $items;
   }
   
   function printProducts($items){
	   
	   foreach($items as $item){
		   
		   $image = $item->MediumImage->URL;
		   $link = $item->DetailPageURL;
		   $price = $item->ItemAttributes->ListPrice->FormattedPrice;
		   $title = $item->ItemAttributes->Title;
		   echo "
				<a href=\"$link\" style=\"text-decoration:none\">
					<div>
						<img src=\"$image\" alt=\"product\">
						Title: $title Price: $price
					</div>
				</a>
		   
		   ";
		   
		   $json = array(
		   		'image' => $image,
				'link' => $link,
				'price' => $price,
				'title' => $title);
			echo json_encode($json);
	   }
	   
	   
   }

 
 if(isset($_POST[submit])){
	if(isset($_POST[random])){
		$curl = curl_init();
		curl_setopt_array($curl, array(
    		CURLOPT_RETURNTRANSFER => 1,
    		CURLOPT_URL => 'http://randomword.setgetgo.com/get.php'
		));
		$searchWord = curl_exec($curl);
		echo $searchWord;
	}else{
		$searchWord = $_POST[term];	
	}
 }else{
	$searchWord = "PHP";	 
 }
 $items = getProducts($searchWord);
 printProducts($items);
 
 if ("cli" !== PHP_SAPI)
{
    echo "</pre>";
}
