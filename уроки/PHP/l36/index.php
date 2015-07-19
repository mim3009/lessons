<?php
	require_once "lib/uploadtext_class.php";
	require_once "lib/uploadimage_class.php";
	if($_POST["upload"]){
		//print_r($_FILES);
		$upload_text = new UploadText();
		$upload_image = new UploadImage();
		$success_text = $upload_text->uploadFile($_FILES["text"]);
		$success_image = $upload_image->uploadFile($_FILES["image"]);
	}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Загрузка файлов</title>
</head>
<body>
	<h1>Загрузка файлов</h1>
	<?php
		if($_POST["upload"]){
			if($success_text) echo "Текстовый файл успешно загружен<br/>";
			else echo "Ошибка при загрузке текстового файла<br/>";
			if($success_image) echo "Картинка успешно загружена<br/>";
			else echo "Ошибка при загрузке картинки<br/>";
		}
	?>
	<form name="myform" action="index.php" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Изображение:</td>
				<td>
					<input type="file" name="image">
				</td>
			</tr>
			<tr>
				<td>Текст:</td>
				<td>
					<input type="file" name="text">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="upload" value="Загрузить файлы">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>