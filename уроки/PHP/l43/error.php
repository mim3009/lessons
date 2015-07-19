<? ob_start(); ?>
<!DOCTYPE html>
<html>
<head>
	<title>Хостинг изображений</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<style type="text/css">
		h1, p{
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Ошибка при загрузке изображения</h1>
	<?php
		require_once "show_error.php";
	?>
	<p>Код ошибки: <b><?=$code?></b></p>
	<p>Текст ошибки: <b><?=$text?></b></p>
	<p>
		<a href="index.php">Вернуться на главную</a>
	</p>
</body>
</html>