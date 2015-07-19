<?php
	function transformCommentsToArray(){
		$string = file_get_contents("comments.txt");
		$array = explode("\n", $string); //Тот же split в java
		$result = array();
		for($i = 0; $i < count($array); $i++){
			$data = explode(";", $array[$i]);
			$result[$i]["name"] = $data[0];
			$result[$i]["comment"] = $data[1];
		}
		return $result;
	}

	function addComment($name, $comment){
		$string = file_get_contents("comments.txt") . "\n$name;$comment";
		file_put_contents("comments.txt", $string);
	}
?>