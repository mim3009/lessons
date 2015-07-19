<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>%title%</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
	<meta name="description" content="%meta_desc%"/>
	<meta name="keywords" content="%meta_key%"/>
	<link rel="stylesheet" href="%address%css/main.css" type="text/css">
</head>
<body>
	<div id="content">
		<div id="header">
			<h2>Шапка сайта</h2>
		</div>
	</div>
	<hr/>
	<div id="main_content">
		<div id="left">
			<div id="menu">
				<h2>Меню</h2>
				<ul>%menu%</ul>
			</div>
			%auth_user%
		</div>
		<div id="right">
			<div id="search">
				<form name="search" method="get" action="%address%">
					<p>
						Поиск: <input type="text" name="words">
					</p>
					<p>
						<input type="hidden" name="view" value="search">
						<input type="submit" name="search" value="Искать">
					</p>
				</form>
			</div>
			<div id="banners">
				<h2>Реклама</h2>
				%banners%
				%poll%
			</div>
		</div>
		<div id="center">
			%top%
			%middle%
			%bottom%
		</div>
		<div class="clear"></div>
		<div id="footer">
			<p>Все права защищены &copy; 2015</p>
		</div>
	</div>
</body>
</html>