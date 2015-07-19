<? ob_start(); ?>
<!DOCTYPE html>
<html>
<head>
	<title>Хостинг изображений</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<style type="text/css">
		h1, h2, p, div{
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Добро пожаловать на хостинг изображений</h1>
	<?php
		require_once "show_image.php";
	?>
	<? if($results) {?>
		<p>Адрес даного изображения: <b><?=$link?></b></p>
		<div>
			<img src="<?=$path?>" alt="Изображение">
		</div>
	<?} else{ ?>
		<h2>Указанного изображения не найдено!</h2>
	<?}?>
	<p>
		<a href="index.php">Вернуться на главную страницу</a>
	</p>
</body>
</html>