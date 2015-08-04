<?php
/**
 * Основные параметры WordPress.
 *
 * Этот файл содержит следующие параметры: настройки MySQL, префикс таблиц,
 * секретные ключи и ABSPATH. Дополнительную информацию можно найти на странице
 * {@link http://codex.wordpress.org/Editing_wp-config.php Editing wp-config.php}
 * Кодекса. Настройки MySQL можно узнать у хостинг-провайдера.
 *
 * Этот файл используется скриптом для создания wp-config.php в процессе установки.
 * Необязательно использовать веб-интерфейс, можно скопировать этот файл
 * с именем "wp-config.php" и заполнить значения вручную.
 *
 * @package WordPress
 */

// ** Параметры MySQL: Эту информацию можно получить у вашего хостинг-провайдера ** //
/** Имя базы данных для WordPress */
define('DB_NAME', 'blog-cook');

define('FS_METHOD', 'direct');

/** Имя пользователя MySQL */
define('DB_USER', 'root');

/** Пароль к базе данных MySQL */
define('DB_PASSWORD', '');

/** Имя сервера MySQL */
define('DB_HOST', 'localhost');

/** Кодировка базы данных для создания таблиц. */
define('DB_CHARSET', 'utf8mb4');

/** Схема сопоставления. Не меняйте, если не уверены. */
define('DB_COLLATE', '');

/**#@+
 * Уникальные ключи и соли для аутентификации.
 *
 * Смените значение каждой константы на уникальную фразу.
 * Можно сгенерировать их с помощью {@link https://api.wordpress.org/secret-key/1.1/salt/ сервиса ключей на WordPress.org}
 * Можно изменить их, чтобы сделать существующие файлы cookies недействительными. Пользователям потребуется авторизоваться снова.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'VR+!M}iIL>4jKVta-Ow|^HXB#1aul)fLX}L3-@hDsD7Pc<XrbkVVK}}|((hcXkT!');
define('SECURE_AUTH_KEY',  'MQbB0W>iU/.qJU#+uC+t+|SpXz:HBm1I~z/pp.ph0fU.&S$J6+&+@tuPR^h tqF]');
define('LOGGED_IN_KEY',    ';^$+39iJ_XF+Y>?H2(US: UPW8pN<9v$@$T/92[q6u>4%2EO(,EAa:uO|}O#h-(Z');
define('NONCE_KEY',        'TTh*p<CoD!zcUN%-U0 sq-w0P|_EM1KIM.yvjws!7A!p/fPz_]H}(J]N,}fA>Ew3');
define('AUTH_SALT',        '{V-[8i:!X IR,/B?&W:./OD~=+8.y#K9uWt$`m+_QN%de:m+!$=S#q,Dz}T1]NPl');
define('SECURE_AUTH_SALT', 'vt_{-~V[uGJ64wW_$S|tEPx;;Zol![`(}%#B,$g(D],ixg{+U#.q-S@H()SNd1#D');
define('LOGGED_IN_SALT',   'KrM{|<e:+a}7TP8jX!?EU!:ef|0>q+A8y+u>Md2--+e~|:{/}L~`&z=bn>+bq2C0');
define('NONCE_SALT',       '4VG<Bl~R%QNzmkk]c0ufqBJQK1w9h s8;I?-203fJZdZ4=[lApg5!fd6p^>xaTr;');

/**#@-*/

/**
 * Префикс таблиц в базе данных WordPress.
 *
 * Можно установить несколько сайтов в одну базу данных, если использовать
 * разные префиксы. Пожалуйста, указывайте только цифры, буквы и знак подчеркивания.
 */
$table_prefix  = 'bc_';

/**
 * Для разработчиков: Режим отладки WordPress.
 *
 * Измените это значение на true, чтобы включить отображение уведомлений при разработке.
 * Разработчикам плагинов и тем настоятельно рекомендуется использовать WP_DEBUG
 * в своём рабочем окружении.
 */
define('WP_DEBUG', false);

/* Это всё, дальше не редактируем. Успехов! */

/** Абсолютный путь к директории WordPress. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Инициализирует переменные WordPress и подключает файлы. */
require_once(ABSPATH . 'wp-settings.php');
