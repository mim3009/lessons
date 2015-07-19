<!DOCTYPE html>
<html>
<head>
	<title>Комментарии</title>
</head>
<body>
	<h1>Статья</h1>
	<p>Текст статьи...</p>
	<h2>Комментарии</h2>
	<?php require_once "add_comment.php";?>
	<?php require_once "comments.php";?>
	<?if(count($array) != 0){?>
		<table>
		<?for($i = 0; $i < count($array); $i++){?>
			<tr>
				<td><b><?=$array[$i]["name"]?>:</b></td> <!-- '<=' это как 'echo' -->
				<td><?=$array[$i]["comment"]?></td>
			</tr>
			<tr>
				<td colspan='2'><hr/></td>
			</tr>
		<?}?>
		</table>
	<?}?>
	<h3>Добавить комментарий</h3>
	<form name="myform" action="" method="post">
		 <table>
		 	<tr>
		 		<td>Имя</td>
		 		<td>
		 			<input type="name" name="name">
		 		</td>
		 	</tr>
		 	<tr>
		 		<td>Комментарий</td>
		 		<td>
		 			<textarea name="comment" cols="20" rows="3"></textarea>
		 		</td>
		 	</tr>
		 	<tr>
			 	<td>
			 		<input type="submit" name="addcomment" value="Добавить">
			 	</td>
		 	</tr>
		 </table>
	</form>
</body>
</html>