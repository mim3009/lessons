<?php
	$list = array(15, "22", "str", true);
	echo $list[2];
	$list[] = "New El";
	echo "<br/>";
	echo $list[4];
	$list[4] = "Changed";
	echo "<br/>";
	echo $list[4];
	for($i = 0; $i < count($list); $i++){
		echo "Элемент с индексом $i = ". $list[$i] . "<br/>";
	}

	$array = array("name" => "Alex", "age" => 22, "student" => true);
	$array["a"] = "b";
	$array["a"] = "c";
	
	foreach($array as $k => $v){
		echo "$k = $v<br/>";
	}

	function averageVal($array){
		$summa = 0;
		for($i = 0; $i < count($array); $i++){
			$summa += $array[$i];
		}
		$average = $summa / count($array);
		return $average;
	}

	$list = array(5, 0, 10, 100, 13, 12);
	echo "<br/>";
	echo averageVal($list);

	$array = array(array(0, 5, -5), array(0, 5, "str"), array(4, 5, true));
	for($i = 0; $i < count($array); $i++){
		for($j = 0; $j < count($array[$i]); $j++){
			echo $array[$i][$j];
			echo "<br/>";
		}
	}
?>