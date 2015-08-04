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
define('DB_NAME', 'wp-local');

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
define('AUTH_KEY',         '$})y|#++%Q2VZ=FDL<BuT_(|@b#ojM|?S}z;vmQY-:ryEIH,3c~i]UX;9w]56.gP');
define('SECURE_AUTH_KEY',  't/ MgL+ p!)}WET%*Csp0DAOGt_&g*F%^YBT(vO! 2=6rK8(Ch%z1RR!;A;VC0sd');
define('LOGGED_IN_KEY',    'lD9cC;|!H$gdgRIc^)Yo4Wx#=xhZ^2dva3#i;@3eEyx,|)nJF+i(tdw,BdM98UNa');
define('NONCE_KEY',        ' K0Uz7&8V@5u&;M|-2]xt]},TEQkLKp8y Uq3v-c)z,2f a[12np%#K2+7(es6K_');
define('AUTH_SALT',        '9{hvs1ldy-d-&0lK$$dV]?z!GLCO%>q-Q9o[D(`G,VA,R=/MO5x?09LP f*<E}`2');
define('SECURE_AUTH_SALT', '@k)Gw+|PKDQHsm*TtFY?#C.XF1,XIE.|jA0WY<PM@5$e-Q}/X:?%4F#)7@YTko!-');
define('LOGGED_IN_SALT',   'r$q6:z|Y6!p3$^2cO#,K|]f2vpzSy&i.!H.#)Rz+cS.}J[5>9tM65GC}tG!g8H:}');
define('NONCE_SALT',       '=BpGL+bRd,R!N66shsu;X9D_!x@x=c9?KXKxwAV58nha~hMn]5Eo,Yeu.C+gy|(9');

/**#@-*/

/**
 * Префикс таблиц в базе данных WordPress.
 *
 * Можно установить несколько сайтов в одну базу данных, если использовать
 * разные префиксы. Пожалуйста, указывайте только цифры, буквы и знак подчеркивания.
 */
$table_prefix  = 'wplocal_';

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
