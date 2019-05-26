<?php

// Connect to the database using this code snippet.

try{

	$db = new PDO( 'mysql:host=localhost;dbname=u8250606_chard' , 'u8250606_user22C' , 'study4moar' );

}catch( PDOException $e ){

	echo $e -> getMessage();

}

?>