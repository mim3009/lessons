<?php
	$str = "Super puper string";
	echo strlen($str) . "<br/>"; //Возвращает длину строки
	echo strpos($str, "pu") . "<br/>"; //Вхождение подстроки в строку
	echo strpos($str, "pu", 3) . "<br/>"; //Ищет вхождение в строку подстроки начиная с индекса 3
	if(strpos($str, "S") == false) echo "S не найдена<br/>";
	else "S найдена<br/>";
	if(strpos($str, "S") === false) echo "S не найдена<br/>";
	else "S найдена<br/>";
	echo substr($str, 3, 6) . "<br/>"; //Выбрать подстроку в 6 символов со строки с индекса 3, если 2 параметра то от индекса и до конца если -3 то до конца -3 символа с конца
	echo str_replace("puper", "muper", $str) . "<br/>"; //Заменяет параметр 1 на 2 в строке параметр 3
	$search = array("er", "str");
	$replace = array("rrrrr", "ssssss");
	echo str_replace($search, $replace, $str) . "<br/>";
	$str = "<html><head></head><body><h1>&Заголовок&</h1></body></html";
	echo htmlspecialchars($str) . "<br/>"; //Выводит строку с html кодом используется для преобразования пользовательских сообщений в простой текст а не скрипты
	$str = "Trem MerR PoRp";
	echo strtolower($str) . "<br/>"; //В нижнем регистре
	echo strtoupper($str) . "<br/>"; //В верхнем регистре
	echo strcmp("abc", "ABC") . "<br/>"; //Сравнивает 2 строки 1 - первый больше второго 0 - равны -1 - вторая больше первой
	echo strcasecmp("abc", "ABC") . "<br/>"; //Сравнивает строки без учета регистра
	echo md5("password") . "<br/>"; //Шифрование данных
	$str = "Строка";
	echo $str . "<br/>";
	echo iconv("UTF-8", "CP1251", $str) . "<br/>"; //Перевод в кодировку
	echo chr(110) . "<br/>"; //Возвращает символ по коду
	echo ord("n") . "<br/>"; //Возвращает код символа
	$str = "     string \n";
	echo trim($str) . "<br/>"; //Убирает пробелы и переходы на новую строку
?>