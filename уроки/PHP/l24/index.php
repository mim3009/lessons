<?php
	$reg = "/th/";
	$str = "Something string 123 string";
	echo preg_match($reg, $str) . "<br/>"; //Проверка на соотверствие строки
	$reg = "/S.m/"; // . - это абсолютно любой 1 символ
	echo preg_match($reg, $str) . "<br/>";
	
	$reg = "/\sab\Scd\w\W\d ab \D/"; // \s - любой символ пробельный символ \S - любой не пробельный символ \w - любая буква или цыфра \W - любой символ не буква и не цыфра
	// \d - любая цыфра от 0 до 9 \D - любой символ только не цыфра
	echo preg_match($reg, "\nab9cd9/0 ab X") . "<br/>";
	echo preg_match($reg, "some \nab9cd9/0 ab X some") . "<br/>";

	$reg = "/a[012]b/"; // [] - одно значение из перечисленных
	echo preg_match($reg, "a0b") . "<br/>";

	$reg = "/a[a-z]b/"; // [-] - диапазон букв от a до z
	echo preg_match($reg, "avb") . "<br/>";

	$reg = "/a[^0-8]b/"; // [^] - символы которые не могут быть в строке
	echo preg_match($reg, "a0b") . "<br/>";

	$reg = "/a\/b\\\c\./";
	echo preg_match($reg, "a/b\\c.") . "<br/>";

	$reg = "/ab.*c/"; // * - повторение много раз ноль и более
	echo preg_match($reg, "absomesomec") . "<br/>";

	$reg = "/ab.+c/"; // + - повторение много раз одно и более
	echo preg_match($reg, "absomesomec") . "<br/>";

	$reg = "/ab.?c/"; // ? - ноль или одно повторение
	echo preg_match($reg, "absomesomec") . "<br/>";

	$reg = "/ab\d{1,2}/"; // {значение} - повторение 1 или 2 раза
	echo preg_match($reg, "ab34") . "<br/>";

	$reg = "/ab\d{1,}/"; // {значение, } - повторение 1 или бесконечно раз
	echo preg_match($reg, "ab34") . "<br/>";

	$reg = "/^ab\d{2}$/"; // ^ - начало строки $ - конец строки
	echo preg_match($reg, "ab34") . "<br/>";
	echo preg_match($reg, "ab345") . "<br/>";

	$reg = "/(\d{2})-(\d{2})-(\d{4})/"; // () - групировка данных
	echo preg_match($reg, "25-12-1993") . "<br/>";

	print_r(preg_match_all($reg, "25-12-1993", $matches));
	echo "<br/>";
	echo $matches[3][0] . "<br/>";

	$reg = "/.*?(\d+)\D.*/"; // *? - проверка значений с учетом последующего условия 
	echo "Возвраст: " . preg_replace($reg, '$1', "мне уже скоро будет 22 года"); //Заменяет подстроку в строке

	$reg = "/ab.*c/i"; // i - регистр не учитывается
	echo preg_match($reg, "ABcc") . "<br/>";

	$reg = "/a b с/x"; // x - пробелы не учитываются
	echo preg_match($reg, "abc") . "<br/>";

	$reg = "/^\d/s"; // s - модификатор стоит по умолчанию одностроковый режим поиска
	echo preg_match($reg, "string\n9") . "<br/>";

	$reg = "/^\d/m"; // m - модификатор ищет в многих строках
	echo preg_match($reg, "string\n9") . "<br/>";

	$text = "Всем привет! mysite@site.ru, пишите мне на почту mysite@site.ru";

	function replaceEmail($text){
		$reg = "/[a-z0-9][a-z0-9\._-]*[a-z0-9]*@([a-z0-9]+([a-z0-9-]*[a-z0-9]+)*\.)+[a-z]+/i";
		return preg_replace($reg, "<b>Тут был E-mail</b>", $text);
	}

	echo replaceEmail($text);
?>