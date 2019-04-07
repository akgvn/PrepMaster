<?php

	require_once 'connect.php';
	if(!isset($_GET['sayfa'])){
		$_GET['sayfa']='index';
	}
	Switch ($_GET['sayfa']){
		case 'insert':
		require_once 'insert.php';
		break;

	}
?>

