<?php
	echo M_PI;
	echo "<br/>";
	echo M_E;
	echo "<br/>";
	$x = -15;
	echo abs($x) . "<br/>"; //Взять число по модулю
	$x = 59.53535;
	echo round($x) . "<br/>"; //Округляет число до целого
	echo round($x, 2) . "<br/>"; //Округляет число до сотых
	echo ceil($x) . "<br/>"; //Получает наименьшее целое число не меноше $х
	echo floor($x) . "<br/>"; //Наибольшее целое число что не превышает $x
	echo mt_rand(0, 10) . "<br/>"; //Рандом от нуля до 10 включительно
	echo min(0, -5, 37, 10) . "<br/>"; //Ищет миннимальное из заданных параметров
	echo max(0, 4, 10, -4, 15) . "<br/>"; //Ищет максимальное из заданных параметров
	$x = 1;
	echo ($x * 180)/ M_PI . "<br/>"; //Радиан в градусах
	echo sin($x) . "<br/>"; //Ищет синус в радианах
	echo cos($x) . "<br/>";
	echo tan($x) . "<br/>";
	echo 1/tan($x) . "<br/>"; //Котангенс
	echo asin($x) . "<br/>"; //Арксинус
	echo acos($x) . "<br/>";
	echo atan($x) . "<br/>";
	
?>