<?php
	function add($x, $y){
		return ($x + $y);
	}

	function sub($x, $y){
		return ($x - $y);
	}

	function mult($x, $y){
		return ($x * $y);
	}

	function div($x, $y){
		if($y == 0){
			return false;
		}else{
			return ($x / $y);
		}
	}

	function factorial($x){
		if($x < 0){
			return false;
		}elseif($x == 0){
			return 1;
		}else{
			$f = 1;
			for($i = 1; $i <= $x; $i++){
				$f *= $i;
			}
			return $f;
		}
	}
?>