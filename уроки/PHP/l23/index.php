<?php
	/*$im = imagecreatetruecolor(400, 500);
	$white = imagecolorallocate($im, 255, 255, 255);
	imagefilledrectangle($im, 0, 0, imagesx($im), imagesy($im), $white);
	$c = imagecolorallocate($im, 0, 0, 0);
	$string_1 = "Жигульский Роман";
	$string_2 = "Romka.mim";

	imagestring($im, 5, 10, 20, $string_2, $c); //Вывод текста
	//imagestring($im, 5, 10, 60, $string_1, $c);

	imagettftext($im, 20, 0, 10, 130, $c, "verdana.ttf", $string_2); //Вывод текста

	//$string_1 = iconv("CP1251", "UTF-8", $string_1);
	imagettftext($im, 20, 0, 10, 160, $c, "verdana.ttf", $string_1);

	header("Content-type: image/png");
	imagepng($im);
	imagedestroy($im);*/

	$im = imagecreatetruecolor(90, 50);
	$rand = mt_rand(1000, 9999);
	$c = imagecolorallocate($im, 255, 255, 255);
	imagettftext($im, 20, -10, 10, 30, $c, "verdana.ttf", $rand);
	header("Content-type: image/png");
	imagepng($im);
	imagedestroy($im);
?>