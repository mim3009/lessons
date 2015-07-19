<?php
	//setcookie("count", 5, time() + 5); //Установка куки count - название 5 - значение time()+5 - время существования 5 секунд
	//unset($_COOKIE["count"]); //Удаление переменной
	$count = (isset($_COOKIE["count"]))? $_COOKIE["count"]:0; //Если до ? выражение истина то присваеиваем значение $_COOKIE["count"] иначе 0
	$count++;
	//setcookie("count", $count);
	setcookie("count", $count, time() + 5); //Через 5 секунд куки сотрется
	echo "Обновлений страницы: $count раз";
?>