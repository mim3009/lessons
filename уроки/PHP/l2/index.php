<?php
	$n_1 = -5;
	$n_2 = &$n_1;
	$n_2 = 4;
	echo "n_2 = $n_2";
	echo "<br/>";
	echo "n_1 = $n_1";
	echo "<br/>";

	$a = 10;
	$b = "a";
	echo $$b;
?>