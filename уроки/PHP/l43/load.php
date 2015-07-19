<?php
	require_once "model.php";
	if(isset($_POST["load"])){
		Image::saveImage($_FILES["image"]);
	}
?>