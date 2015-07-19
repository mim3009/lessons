<?php
	$mysqli = new mysqli("localhost", "root", "", "mybase"); //Открытие соединения
	$mysqli->query("SET NAMES 'utf8'"); //Установка кодировки с которой будем общаться с БД
	$mysqli->query("INSERT INTO `users` (`login`, `password`, `regdate`) VALUES ('User1', '" . md5("123") . "', '" . time() . "')");
	for($i = 2; $i < 10; $i++){
		$mysqli->query("INSERT INTO `users` (`login`, `password`, `regdate`) VALUES ('User$i', '" . md5($i) . "', '" . time() . "')");
	}
	$insert_id = $mysqli->insert_id; //Узнает какой последний ID был вставлен
	$mysqli->query("UPDATE `users` SET `regdate` = '0' WHERE `users`.`id` = 5");
	$mysqli->query("DELETE FROM `users` WHERE `id` = 4");
	$mysqli->query("DELETE FROM `users` WHERE `id` > '" . ($insert_id - 5) . "'");
	$mysqli->close(); //Закрытие соединения
?>