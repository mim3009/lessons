<?php
	function printSum($x, $y){
		$sum = getSum($x, $y);
		echo "Сумма $x и $y равна $sum<br/>";
	}

	function getSum($x, $y){
		$sum = $x + $y;
		return $sum;
	}

	function hello(){
		echo "<b>HELLO</b><br/>";
	}

	printSum(10, 15);
	$sum = getSum(4, 10);
	echo "Сумма равна $sum<br/>";
	for($i = 0; $i < 20; $i++){
		hello();
	}
?>