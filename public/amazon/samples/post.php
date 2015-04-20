<?php
	// Get cURL resource
$curl = curl_init();
// Set some options - we are passing in a useragent too here
curl_setopt_array($curl, array(
    CURLOPT_RETURNTRANSFER => 1,
    CURLOPT_URL => 'http://ptsrepairs.com/amazon/samples/getProduct.php',
    //CURLOPT_USERAGENT => 'Codular Sample cURL Request',
    CURLOPT_POST => 1,
    CURLOPT_POSTFIELDS => array(
        search => 'archer',
		cat => 'Movies & TV'
    )
));
// Send the request & save response to $resp
$resp = curl_exec($curl);
echo $resp;
// Close request to clear up some resources
curl_close($curl);


?>