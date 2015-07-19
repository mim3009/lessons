<?php
	if($_GET["country"] == 1) echo json_encode(array('1' => 'Москва', '2' => 'Питер'));
	elseif($_GET["country"] == 2) echo json_encode(array('3' => 'Киев', '4' => 'Чернигов'));
?>