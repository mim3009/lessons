<?php
	require_once "model.php";
	$code = $_GET["code"];
	$text = Image::getTextError($code);
?>