<!DOCTYPE html>
<html>
<head>
	<title>Форма</title>
</head>
<body>
	<form name="myform" action="script.php" method="post">
		<table>
			<tr>
				<td>Имя: </td>
				<td>
					<input type="text" name="firstname">
				</td>
			</tr>
			<tr>
				<td>E-mail: </td>
				<td>
					<input type="email" name="email">
				</td>
			</tr>
			<tr>
				<td colspan="2">Сообщение</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="message" cols="40" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Отправить" name="send">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>