<?php
	$im = imagecreatetruecolor(400, 500); //Создание холста для рисования
	$c = imagecolorallocate($im, 120, 220, 100); //Задаем цвет которым будем рисовать
	imageline($im, 0, 0, imagesx($im), imagesy($im), $c); //Рисуем линию с точки (0, 0) в imagesx($im) - ширина изображения imagesу($im) - высоту изображения
	imageline($im, 0, imagesy($im), imagesx($im), 0, $c);
	imagefilledrectangle($im, 100, 200, 300, 400, $c); //Рисуем залитый прямоугольник 100, 200 - левый верхний угол 300, 400 - правый нижний угол
	$c = imagecolorallocate($im, 255, 255, 255);
	imagerectangle($im, 99, 199, 301, 401, $c);
	imagesetthickness($im, 5); //Задает толщину линии
	$c = imagecolorallocate($im, 255, 0, 0);
	imagerectangle($im, 95, 196, 305, 404, $c);
	imagesetthickness($im, 2);
	imagearc($im, 20, 30, 200, 400, 0, 30, $c); //Рисуем дугу или элипс
	imagearc($im, 40, 300, 50, 50, 0, 360, $c);
	$c = imagecolorallocate($im, 255, 255, 0);
	imagefill($im, 45, 305, $c); //Заливает замкнутую область в которую попали координатой х и у работает как заливка в фотошопе
	imagearc($im, 240, 80, 150, 100, 0, 360, $c);
	$texture = imagecreatefromjpeg("texture.jpg");
	imagesettile($im, $texture);
	imagefill($im, 245, 85, IMG_COLOR_TILED);

	$array = array(10, 20, 30, 40, 59, 39, 10, 70);
	imagefilledpolygon($im, $array, 4, IMG_COLOR_TILED); //Рисование полигона и заливка его текстурой

	for($i = 0; $i < 1000; $i++){
		$x = mt_rand(0, imagesx($im));
		$y = mt_rand(0, imagesy($im));
		imagesetpixel($im, $x, $y, $c); //Зарисовывает пиксель в определенной точке
	}

	$new_im = imagecreatetruecolor(100, 200);
	imagecopyresized($new_im, $im, 0, 0, 50, 50, imagesx($new_im), imagesy($new_im), 70, 70); //Вырезка с переносом части изображения на новое изображение

	header("Content-type: image/png");
	imagepng($im); //Вывод картинки в браузер
	imagepng($new_im, "image_new.png"); //Сохранение картинки в файл
	imagedestroy($im); //Закрытие дескриптора
	imagedestroy($texture);
	imagedestroy($new_im);
?>