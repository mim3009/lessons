-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Июл 19 2015 г., 09:25
-- Версия сервера: 5.6.24
-- Версия PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `mybase`
--

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_articles`
--

CREATE TABLE IF NOT EXISTS `lesson_articles` (
  `id` int(11) unsigned NOT NULL,
  `section_id` int(11) unsigned NOT NULL,
  `title` varchar(255) NOT NULL,
  `intro_text` text NOT NULL,
  `full_text` text NOT NULL,
  `meta_desc` varchar(255) NOT NULL,
  `meta_key` varchar(255) NOT NULL,
  `image_src` varchar(255) NOT NULL,
  `date` int(11) unsigned NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_articles`
--

INSERT INTO `lesson_articles` (`id`, `section_id`, `title`, `intro_text`, `full_text`, `meta_desc`, `meta_key`, `image_src`, `date`) VALUES
(1, 1, 'Функция addcslashes', '<p>Функция addcslashes — Экранирует спецсимволы в стиле языка C.</p>', '<p>Функция addcslashes — Экранирует спецсимволы в стиле языка C.</p>\r\n<p>string <b>addcslashes</b> (string str, string charlist)</p>\r\n<p>Возвращает сроку str, в которой перед каждым символом из перечисленных в charlist символов добавлен обратный слэш (\\). Экранируются \\n, \\r и т.д. в стиле языка C, символы с ASCII менее 32 и более 126 преобразуются в восьмеричное представление.</p>', 'Функция addcslashes в PHP.', 'addcslashes. addcslashes php', '2.jpg', 1437052198),
(2, 1, 'Функция echo', '<p>echo — Выводит одну или более строк</p>', '<p>echo — Выводит одну или более строк</p>\r\n<p>void <b>echo</b> ( string $arg1 [, string $... ] )</p>\r\n<p>На самом деле echo - это не функция, а конструкция языка, поэтому заключать аргументы в скобки необязательно. echo (в отличии от других языковых конструкций) не ведет себя как функция, поэтому не всегда может быть использована в контексте функции. Вдобавок, если вы хотите передать более одного аргумента в echo, эти аргументы нельзя заключать в скобки.</p>', 'Функция echo в PHP', 'echo. echo php', '3.jpg', 1437052493),
(3, 2, 'Функция acos', '<p>acos — Арккосинус.</p>', '<p>acos — Арккосинус.</p>\r\n<p>float <b>acos</b> ( float $arg )</p>\r\n<p>Возвращает арккосинус числа arg в радианах. acos() - обратная тригонометрическая функция к cos(), т.е. a==cos(acos(a)) для каждого значения а, входящего в область значений функции acos().</p>', 'Функция acos в PHP.', 'acos. acos php', '4.jpg', 1437052759),
(4, 2, 'Функция asin', '<p>asin — Арксинус</p>', '<p>asin — Арксинус</p>\r\n<p>float <b>asin</b> ( float $arg )</p>\r\n<p>Возвращает арксинус числа arg в радианах. asin() - обратная тригонометрическая функция к sin(), т.е. a==sin(asin(a)) для каждого значения a, входящего в область значений функции asin().</p>', 'Функция asin в PHP.', 'asin. asin php', '2.jpg', 1437052952),
(5, 2, 'Функция pow', '<p>pow — Возведение в степень</p>', '<p>pow — Возведение в степень</p>\r\n<p>number <b>pow</b> ( number $base , number $exp )</p>\r\n<p>Возвращает base, возведенное в степень exp.<p>', 'Функция pow в PHP.', 'pow. pow php', '3.jpg', 1437053087),
(6, 3, 'Функция date', '<p>date — Форматирует вывод системной даты/времени.</p>', '<p>date — Форматирует вывод системной даты/времени.</p>\r\n<p>string <b>date</b> ( string $format [, int $timestamp = time() ] )</p>\r\n<p>Возвращает строку, отформатированную в соответствии с указанным шаблоном format. Используется метка времени, заданная аргументом timestamp, или текущее системное время, если timestamp не задан. Таким образом, timestamp является необязательным и по умолчанию равен значению, возвращаемому функцией time().</p>', 'Функция date в PHP.', 'date. date php', '4.jpg', 1437053350);

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_banners`
--

CREATE TABLE IF NOT EXISTS `lesson_banners` (
  `id` int(11) unsigned NOT NULL,
  `code` text NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_banners`
--

INSERT INTO `lesson_banners` (`id`, `code`) VALUES
(1, 'Тут находится код баннера 1.'),
(2, 'Тут находится код баннера 2.');

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_menu`
--

CREATE TABLE IF NOT EXISTS `lesson_menu` (
  `id` int(11) unsigned NOT NULL,
  `title` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_menu`
--

INSERT INTO `lesson_menu` (`id`, `title`, `link`) VALUES
(1, 'Главная', ''),
(2, 'Строковые функции', '?view=section&amp;id=1'),
(3, 'Математические функции', '?view=section&amp;id=2'),
(4, 'Функции даты и времени', '?view=section&amp;id=3');

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_polls`
--

CREATE TABLE IF NOT EXISTS `lesson_polls` (
  `id` int(11) unsigned NOT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_polls`
--

INSERT INTO `lesson_polls` (`id`, `title`) VALUES
(1, 'Ваш любимый язык программирования');

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_poll_variants`
--

CREATE TABLE IF NOT EXISTS `lesson_poll_variants` (
  `id` int(11) unsigned NOT NULL,
  `poll_id` int(11) unsigned NOT NULL,
  `title` varchar(255) NOT NULL,
  `votes` int(11) unsigned NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_poll_variants`
--

INSERT INTO `lesson_poll_variants` (`id`, `poll_id`, `title`, `votes`) VALUES
(1, 1, 'Java', 0),
(2, 1, 'PHP', 1),
(3, 1, 'C++', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_sections`
--

CREATE TABLE IF NOT EXISTS `lesson_sections` (
  `id` int(11) unsigned NOT NULL,
  `title` varchar(25) NOT NULL,
  `description` text NOT NULL,
  `meta_desc` varchar(255) NOT NULL,
  `meta_key` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_sections`
--

INSERT INTO `lesson_sections` (`id`, `title`, `description`, `meta_desc`, `meta_key`, `source`) VALUES
(1, 'Строковые функции', '<p>Эти функции предназначены для выполнения различных манипуляций со строками. Более специализированные функции см. в разделах, посвященных регулярным выражениям и обработке URL.</p>\r\n<p>Для получения общей информации о работе со строками, особенно об использовании одиночных и двойных кавычек и экранировании символов, смотрите главу "Строки" в разделе "Типы".</p>', 'Стоковые функции в PHP.', 'функции php. строковые функции php', '2.jpg'),
(2, 'Математические функции', '<p>Данные функции работают с числами в диапазонах типов integer и float на вашей машине (это отвечает C-типам long и double). Если вам нужно работать с большими числами, обратитесь к разделу BCMath - математические функции повышенной точности.</p>', 'Математические функции в PHP.', 'функции php. математические функции php', '3.jpg'),
(3, 'Функции даты и времени', '<p>Эти функции позволяют получить текущее время на сервере, на котором исполняется скрипт. Кроме того, что получить, время можно представить в различных форматах, посчитать разницу между двумя моментами времени и даже узнать время восхода солнца в определенной местности в тот или иной день!</p>\r\n<p><b>Примечание:</b> пожалуйста, запомните, что эти функции зависят от локальных установок на вашем сервере. Особенно обратите внимание на переход на летнее время и високосные годы.</p>', 'Функции даты и времени PHP.', 'функции php. функции даты времени php', '4.jpg');

-- --------------------------------------------------------

--
-- Структура таблицы `lesson_users`
--

CREATE TABLE IF NOT EXISTS `lesson_users` (
  `id` int(11) unsigned NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `regdate` int(11) unsigned NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson_users`
--

INSERT INTO `lesson_users` (`id`, `login`, `password`, `regdate`) VALUES
(1, 'User', 'de2ed28e3c1dd462dcc6cd8a8e138dab', 1437205595);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `lesson_articles`
--
ALTER TABLE `lesson_articles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson_banners`
--
ALTER TABLE `lesson_banners`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson_menu`
--
ALTER TABLE `lesson_menu`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson_polls`
--
ALTER TABLE `lesson_polls`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson_poll_variants`
--
ALTER TABLE `lesson_poll_variants`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson_sections`
--
ALTER TABLE `lesson_sections`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson_users`
--
ALTER TABLE `lesson_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `lesson_articles`
--
ALTER TABLE `lesson_articles`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT для таблицы `lesson_banners`
--
ALTER TABLE `lesson_banners`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `lesson_menu`
--
ALTER TABLE `lesson_menu`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `lesson_polls`
--
ALTER TABLE `lesson_polls`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `lesson_poll_variants`
--
ALTER TABLE `lesson_poll_variants`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `lesson_sections`
--
ALTER TABLE `lesson_sections`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `lesson_users`
--
ALTER TABLE `lesson_users`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
