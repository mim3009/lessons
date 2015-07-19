<? ob_start(); ?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Хостинг изображений</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<style type="text/css">
		h1{
			text-align: center;
		}

		table{
			margin: 0 auto;
		}
	</style>
</head>
<body>
	<h1>Добро пожаловать на хостинг изображений</h1>
	<?php
		require_once "load.php";
	?>
	<form name="hosting" action="" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Выберите изображение:</td>
				<td>
					<input type="file" name="image"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" name="load" value="Отправить">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>