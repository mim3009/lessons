<?php
	class Point{

		public $x;
		public $y;

		public function __construct($x, $y){
			$this->x = $x;
			$this->y = $y;
		}

		public function __toString(){
			return "(" . $this->x . ";" . $this->y . ")<br/>";
		}

		public function __clone(){
			$this->y = 50;
		}

	}

	$point = new Point(5,7);
	$point_1 = clone $point; //Клонирует обьект
	$point_1->x = 100;
	echo $point;
	echo $point_1;
?>