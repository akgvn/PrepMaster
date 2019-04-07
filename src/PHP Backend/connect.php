<?php

try{
	$db = new PDO('mysql:host=localhost;dbname=words','root','');
}catch(PDOException $e){
	echo $e -> getMessage();
}
?>