<?php
	echo substr(sprintf('%o', fileperms('index.php')), -4); //Выводит права доступа к файлу
	chmod("index.php", 0777); //Изменяет права доступа
	echo substr(sprintf('%o', fileperms('index.php')), -4);
?>