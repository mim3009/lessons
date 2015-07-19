<?php
	$start = microtime(true);
	echo time() . "<br/>"; //Выдает количество секунд прошедших с 01.01.1970г.
	echo microtime() . "<br/>"; //Количество секунд с точностью до сотых microtime(true)

	echo date("Y-m-d H:i:s") . "<br/>"; //Вывод даты в отформатированном варианте
	$time = mktime(23, 59, 59, 2, 5, 2013); //Возвращает количество секунд прошедших с 01.01.1970г по заданную дату
	echo date("Y-m-d H:i:s", $time) . "<br/>";

	$array = getdate($time); //Возвращает массив значение времени для даты $time
	print_r($array);
	echo "<br/>";
	echo checkdate(2, 28, 2012) . "<br/>"; //Проверяет на корректность дату


	echo "Время выполнения скрипта: " . (microtime(true) - $start) . " секунд";
?>