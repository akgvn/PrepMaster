<?php

// Connect to the database using this code snippet.

try{
	// $db = new PDO('mysql:host=94.73.151.154;dbname=u8250606_chard','u8250606_user22C','DUpj07B2');
	$db = new PDO('mysql:host=localhost;dbname=words','root','study4moar'); // for testing
}catch(PDOException $e){
	echo $e -> getMessage();
}
?>