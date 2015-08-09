<?php defined('SYSPATH') OR die('No direct script access.'); ?>

2015-08-08 09:15:09 --- EMERGENCY: ErrorException [ 4 ]: syntax error, unexpected '.' ~ APPPATH/classes/Controller/Welcome.php [ 15 ] in file:line
2015-08-08 09:15:09 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in file:line
2015-08-08 09:15:36 --- EMERGENCY: ErrorException [ 4 ]: syntax error, unexpected '$site_config' (T_VARIABLE), expecting function (T_FUNCTION) ~ APPPATH/classes/Controller/Welcome.php [ 14 ] in file:line
2015-08-08 09:15:36 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in file:line
2015-08-08 09:17:16 --- EMERGENCY: ErrorException [ 4 ]: syntax error, unexpected ' ~ APPPATH/classes/Controller/Welcome.php [ 13 ] in file:line
2015-08-08 09:17:16 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in file:line
2015-08-08 10:03:25 --- EMERGENCY: View_Exception [ 0 ]: The requested view main could not be found ~ SYSPATH/classes/Kohana/View.php [ 265 ] in /opt/lampp/htdocs/kohana/system/classes/Kohana/View.php:145
2015-08-08 10:03:25 --- DEBUG: #0 /opt/lampp/htdocs/kohana/system/classes/Kohana/View.php(145): Kohana_View->set_filename('main')
#1 /opt/lampp/htdocs/kohana/system/classes/Kohana/View.php(30): Kohana_View->__construct('main', NULL)
#2 /opt/lampp/htdocs/kohana/system/classes/Kohana/Controller/Template.php(33): Kohana_View::factory('main')
#3 /opt/lampp/htdocs/kohana/system/classes/Kohana/Controller.php(69): Kohana_Controller_Template->before()
#4 [internal function]: Kohana_Controller->execute()
#5 /opt/lampp/htdocs/kohana/system/classes/Kohana/Request/Client/Internal.php(97): ReflectionMethod->invoke(Object(Controller_Welcome))
#6 /opt/lampp/htdocs/kohana/system/classes/Kohana/Request/Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 /opt/lampp/htdocs/kohana/system/classes/Kohana/Request.php(997): Kohana_Request_Client->execute(Object(Request))
#8 /opt/lampp/htdocs/kohana/index.php(118): Kohana_Request->execute()
#9 {main} in /opt/lampp/htdocs/kohana/system/classes/Kohana/View.php:145