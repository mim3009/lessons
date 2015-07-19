<?php
	$file = fopen("a.txt", "a+t"); //r - чтение r+ - чтение и запись (перезапись) w - создает новый пустой файл
	//w+ -открывает существующий файл и стирает его содержимое 	a - открывает файл для дозаписи a+ - если файл не существовал то он его и создает
	//a+t - открывает и дописывает текстовый файл
	fwrite($file, "String\nNext\nNext"); //запись в файл
	fclose($file);

	$file = fopen("a.txt", "r+t");
	while (!feof($file)) { //Пока не конец файла
		echo fread($file, 2);
		echo "<br/>";
	}

	fseek($file, 0); //Сдвигает указатель файла на нужную позицию
	echo fread($file, 1) . "<br/>";
	fclose($file);

	file_put_contents("b.txt", "file file file"); //Открывает файл и записывает в него данные
	echo file_get_contents("b.txt") . "<br/>"; //Открывает файл и считывает его
	echo file_exists("b.txt") . "<br/>"; //Проверка существует файл или нет
	echo filesize("a.txt") . "<br/>"; //Возвращает значение равное весу файла
	rename("a.txt", "c.txt"); //Переименование файла
	unlink("b.txt"); //Удаление файла
?>