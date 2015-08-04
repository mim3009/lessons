<?php
/*
	Plugin Name: My Plugin
	Plugin URI: http://vk.com
	Description: Add text
	Version: 1.0
	Author: Roman Zhuhylskiy
	Author URI: https://vk.com/ro__m__ka
*/

require "general_options.php";

add_action("admin_menu", "mypl_admin_menu");

function mypl_admin_menu(){
	add_menu_page(
		"My Plugin",
		"MyPlugin",
		"manage_options",
		"mypl",
		"mypl_general_options"
	);
}

add_action("the_content", "mypl_func");

function mypl_func($content){
	$content .= get_option("mypl_text");
	return $content;
}

?>