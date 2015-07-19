<?php
	
	class Image{

		private static $error = 0;

		public static function saveImage($file){
			if(!self::isSecurity($file)){
				header("Location: error.php?code=" . self::$error);
				exit;
			}
			$name = self::getName($file["name"]);
			$uploadfile = "images/$name";
			if(move_uploaded_file($file["tmp_name"], $uploadfile)){
				header("Location: image.php?im=$name");
			}
			else{
				self::$error = 3;
				header("Location: error.php?code=" . self::$error);
			}
			exit;
		}

		public static function loadImage(){
			$im = $_GET["im"];
			if(!$im){
				return false;
			}
			if(!file_exists("images/$im")){
				return false;
			}
			$results["path"] = "images/$im";
			$results["link"] = "http://" . $_SERVER["HTTP_HOST"] . "image.php?im=$im";
			return $results;
		}

		private static function isSecurity($file){
			$blacklist = array(".php", ".phtml", ".php3", ".php4", ".html", ".htm");
			foreach ($blacklist as $item) {
				if(preg_match("/$item\$/i", $file["name"])){
					self::$error = 1;
					return false;
				}
			}
			$type = $file["type"];
			$size = $file["size"];
			if(($type != "image/jpeg") && ($type != "image/jpg") && ($type != "image/png")){
				self::$error = 1;
				return false;
			}
			if($size > 512000){
				self::$error = 2;
				return false;
			}
			return true;
		}

		private static function getName($filename){
			$name = substr(md5(microtime()), 0, 6);
			$name .= strrchr($filename, ".");
			if(!file_exists("images/$name")){
				return $name;
			}
			else{
				return self::getName($filename);
			}
		}

		public function getTextError($code){
			if($code == 1){
				return "Неверный тип изображения.";
			}elseif($code == 2){
				return "Превышен максимальный размер загружаемого файла (500Kb).";
			}elseif($code == 3){
				return "Ошибка при загрузке. Попробуйте еще раз.";
			}
		}

	}

?>