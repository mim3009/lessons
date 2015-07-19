<?php
	$var = 15;
	$str_1 = "Переменная var = $var";
	$str_2 = 'Переменная var = $var';
	echo $str_1 . "<br/>";
	echo $str_2 . "<br/>";
	echo "\"";

	$str_1 = "Строка 1";
	$str_2 = "Строка 2";
	echo $str_1 . " " . $str_2;
	$str = `attrib`; //Выполняет команду так же как и exec();
	echo $str;
?>