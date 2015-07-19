<?php
	$array = parse_ini_file("config.ini", true); //Разобрать ini файл если true то учитывать разделы
	print_r($array);
	echo "<br/>";

	echo "Кодировка = " . $array["Main Settings"]["charset"];
	echo "<br/>";

	$array = parse_ini_file("config.ini");
	print_r($array);
	echo "<br/>";
	echo "Адрес сайта = " . $array["address"];
?>