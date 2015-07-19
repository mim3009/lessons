<?php
	if(isset($_POST["addcomment"])){
		require_once "model.php";
		addComment($_POST["name"], $_POST["comment"]);
	}
?>