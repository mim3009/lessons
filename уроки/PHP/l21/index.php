<?php
	$info = getimagesize("image.jpg"); //Возвращает информацию о картинке
	//print_r($info);
	//echo "<br/>";
	$im = imagecreatefromjpeg("image.jpg"); //Возвращает дескриптор картинки
	//echo imagesx($im) . "<br/>"; //Возвращает ширину картинки
	//echo imagesy($im) . "<br/>"; //Возвращает высоту картинки
	$color = imagecolorat($im, 50, 100); //Возвращает цвет пикселя
	//echo $color . "<br/>";
	$r = ($color >> 16) & 0xFF;
	$g = ($color >> 8) & 0xFF;
	$b = $color & 0xFF;
	//echo "Цвет точки: ($r, $g, $b)<br/>";
	$color = imagecolorsforindex($im, color);
	//print_r($color);
	//echo "<br/>";
	//imagejpeg($im, "image_new.jpg"); //Запись изображения в файл
	header("Content-type: image/jpeg"); //Установка параметра чтобы браузер принимал файл именно как изображение
	imagejpeg($im); //Вывод изображения в браузер
	imagedestroy($im); //Закрытие дескриптора файла изображения
?>