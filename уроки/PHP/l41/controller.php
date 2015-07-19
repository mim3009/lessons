<?php
	require_once "model.php";
	if(isset($_POST["addcomment"])){
		addComment($_POST["name"], $_POST["comment"]);
	}
	$array = transformCommentsToArray();
	require_once "view.html";
?>