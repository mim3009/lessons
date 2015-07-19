<?php
	if (isset($_POST["calc"])){ //isset была ли отправка формы если да то выполняется если нет то пропускается код
		require_once "func/functions.php";
		$n_1 = $_POST["n_1"];
		$n_2 = $_POST["n_2"];
		$operation = $_POST["operation"];
		switch ($operation) {
			case "add":
				$result = "$n_1 + $n_2 = " . add($n_1, $n_2);
				break;
			case "sub":
				$result = "$n_1 - $n_2 = " . sub($n_1, $n_2);
				break;
			case "mult":
				$result = "$n_1 * $n_2 = " . mult($n_1, $n_2);
				break;
			case "div": {
				$result =  div($n_1, $n_2);
				if($result === false){
					$result = "Деление на 0";
				}else{
					$result = "$n_1 / $n_2 = $result";
				}
				break;
			}
			case "fact": {
				$result = factorial($n_1);
				if($result === false){
					$result = "Факториала не существует";
				}else{
					$result = "$n_1! = $result";
				}
				break;
			}
			default:
				$result = "Неизвестная операция";
		}	
	}
?>

<!DOCTYPE html>
<html>
<head>
	<title>Калькулятор</title>
</head>
<body>
	<?php
		if(isset($result)){
			echo "<p>Вычисление: $result</p>";
		}
	?>
	<form name="myform" action="index.php" method="post">
		<p>
			<input type="text" name="n_1" value="<?php if(isset($_POST["calc"])) echo $n_1;?>">
			<select name="operation">
				<?php
					$operations = array("add" => "+", "sub" => "-", "mult" => "*", "div" => "/", "fact" => "!");
					foreach ($operations as $key => $value) {
						if($operation == $key){
							echo "<option value='$key' selected='selected'>$value</option>";
						}
						echo "<option value='$key'>$value</option>";
					}
				?>
			</select>
			<input type="text" name="n_2" value="<?php if(isset($_POST["calc"])) echo $n_2;?>">
			<br/>
			<input type="submit" value="Вычислить" name="calc">
		</p>
	</form>
</body>
</html>