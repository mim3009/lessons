<?php
	class Math{

		public static $count = 0;

		public static function getSin($x){
			self::$count++; //self - берет свое же статическое свойство
			return sin($x);
		}

		public static function getCos($x){
			self::$count++;
			return cos($x);
		}
		
	}

	echo Math::getSin(1); . "<br/>"; //Получение доступа к статическим методам и переменным класса
	echo Math::getCos(1); . "<br/>";
	echo Math::$count . "<br/>";
?>