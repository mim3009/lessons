<?php
	$x = 5;
	if(isset($x)) echo "Переменная существует"; //проверяет на существование переменные
	else echo "Переменная не существует";
	echo "<br/>";
	unset($x); //удаление переменной из памяти
	if(isset($x)) echo "Переменная существует"; //проверяет на существование переменные
	else echo "Переменная не существует";
	echo "<br/>";
	$x = 15;
	$array = array(3, 0, 5);
	unset($array[1]);
	print_r($array);
	echo "<br/>";
	echo "integer? - " . is_integer($x) . "<br/>"; //Проверка целое число?
	echo "double? - " . is_double($x) . "<br/>"; //Проверка число с плавающей запятой?
	echo "string? - " . is_string($x) . "<br/>";  //Проверка строка или нет?
	echo "numeric? - " . is_numeric($x) . "<br/>"; //Проверка числовое значение или нет?
	echo "boolean? - " . is_bool($x) . "<br/>";
	echo "scalar? - " . is_scalar($x) . "<br/>"; //Простой ли элемент? инт бул и тд...
	echo "null? - " . is_null($x) . "<br/>"; //Пустой ли элемент?
	echo "is_array? - " . is_array($array) . "<br/>"; //Массив ли?
	echo "type? - " . gettype($x) . "<br/>"; //Возвращает тип
	echo "type? - " . gettype($array) . "<br/>";
?>