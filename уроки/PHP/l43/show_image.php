<?php
	require_once "model.php";
	$results = Image::loadImage();
	if($results){
		$path = $results["path"];
		$link = $results["link"];
	}
?>