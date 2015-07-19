<?php
	$list = array(10, 5, -10, 12);
	echo count($list) . "<br/>"; //Возвращает коичество елементов в массиве
	sort($list) . "<br/>"; //Сортировка
	print_r($list); 
	echo "<br/>";
	rsort($list); //Сортировка в обратную сторону
	print_r($list);
	echo "<br/>";
	$array = array(10, 5, -10, 12);
	asort($array); //Сортировка с сохранением ключа для ассоциативных массивов arsort($array) - сортирует по убыванию
	print_r($array);
	echo "<br/>";
	$array = array('b' => 1, 'a' => 12, 'c' => -10);
	ksort($array); //Сортировка по ключам krsort($array) - в обратную сторону
	print_r($array);
	echo "<br/>";
	shuffle($list); //перемешать массив применять только для списочных массивов
	print_r($list);
	echo "<br/>";
	echo in_array(10, $list) . "<br/>"; //Проверка есть ли такой то елемент в массиве или нету 1 - есть 0 - нету
	$array_1 = 	array(1, 10);
	$array_2 = array(15);
	$array = array_merge($array_1, $array_2); //Массив1 + Массив2 
	print_r($array);
	echo "<br/>";
	$array = array(1, 2, 3, 4, 5);
	print_r(array_slice($array, 1, 3)); //Вырезаем начиная с индекса 1, 3 елемента в другой массив и выводим работает также как и substr()
	echo "<br/>";
	$array = array(3, 4, 4, 3, 3, 3, 5, 6, 7);
	$array = array_unique($array); //Очистка массива от повторений
	print_r($array);
?>