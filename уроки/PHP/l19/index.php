<?php
	mkdir("tempdir"); //Создает папку
	chdir("tempdir"); //Переходим в папку
	file_put_contents("a.txt", "String");
	file_put_contents("b.txt", "String");
	mkdir("newdir");
	chdir("newdir");
	file_put_contents("c.txt", "String");
	chdir("..");
	file_put_contents("d.txt", "String");

	function printAllFiles($dir){
		$list = glob($dir . "/*"); //Возвращает все содержимое которое удовлетворяет правилу *- все файлы и каталоги txt - все txt файлы
		for($i = 0; $i < count($list); $i++){
			if(is_dir($list[$i])){
				printAllFiles($list[$i]);
			}else{
				echo $list[$i] . "<br/>";
			}
		}
	}

	printAllFiles(".");
	chdir("..");
	//rmdir("tempdir"); //Удаляет ПУСТУЮ директорию

	function deleteAllFiles($dir){
		$list = glob($dir . "/*");
		for($i = 0; $i < count($list); $i++){
			if(is_dir($list[$i])){
				deleteAllFiles($list[$i]);
			}else{
				unlink($list[$i]);
			}	
		}
		rmdir($dir);
	}

	deleteAllFiles("tempdir");
?>