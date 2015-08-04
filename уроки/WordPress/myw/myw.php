<?php
/*
Plugin Name: My Widget
Plugin URI: http://vk.com
Author: Roman Zhuhylskiy
Author URI: https://vk.com/ro__m__ka
*/

class my_widget extends WP_Widget{

	function __construct(){
		parent::__construct(
			"my_widget",
			"Мой виджет",
			array("description" => "Пример виджета")
		);
	}

	public function widget($args, $instance){
		$title = apply_filters("widget_title", $instance["title"]);
		echo $args["before_widget"];
		echo $args["before_title"]. $title . $args["after_title"];
		echo "<ul><li>Время на сайте: " . date("H:i:s") . "</li></ul>";
		echo $args["after_widget"];
	}

	public function form($instance){
		if(isset($instance["title"])){
			$title = $instance["title"];
		}else{
			$title = "New Title";
		}
		?>

		<p>
			<label for="my_w_title">Заголовок</label>
			<input class="widefat" id="my_w_title" name="<?php echo $this->get_field_name("title");?>" type="text" value="<?=$title?>">
		</p>
		<?php
	}

	public function update($new_instance, $old_instance){
		$instance = array();
		$instance["title"] = (! empty($new_instance["title"])) ? $new_instance["title"] : "";
		return $instance;
	}
}
	function myw_load_widget(){
		register_widget("my_widget");
	}

	add_action("widgets_init", "myw_load_widget")

?>