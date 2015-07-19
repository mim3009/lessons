<?php
	session_start(); //Создание сессии
	$count = (isset($_SESSION["count"]))? $_SESSION["count"] : 0;
	$count++;
	$_SESSION["count"] = $count;
	echo "Обновлений страницы: $count раз";
	//session_destroy(); //Удаление сессии и удаление файла с сервера
?>