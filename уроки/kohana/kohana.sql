-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Авг 09 2015 г., 17:54
-- Версия сервера: 5.6.24
-- Версия PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `kohana`
--

-- --------------------------------------------------------

--
-- Структура таблицы `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(10) NOT NULL COMMENT 'Идентификатор статьи',
  `title` varchar(250) NOT NULL COMMENT 'Название статьи',
  `alt_title` varchar(250) NOT NULL COMMENT 'Название в урл',
  `author` varchar(100) NOT NULL COMMENT 'Автор статьи',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата публикации',
  `content_short` text NOT NULL COMMENT 'Текст статьи',
  `content_full` text NOT NULL COMMENT 'Полный текст статьи'
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `articles`
--

INSERT INTO `articles` (`id`, `title`, `alt_title`, `author`, `date`, `content_short`, `content_full`) VALUES
(1, 'О фреймворках', 'about_framework', 'Петя Иванов', '2012-04-01 14:20:33', 'Фреймворк - в информационных\r\nсистемах структура программной системы; программное обеспечение, облегчающее разработку\r\nи объединение разных компонентов большого программного проекта. В отличие от библиотек,\r\nкоторые объединяют набор подпрограмм близкой функциональности, фреймворк содержит в себе\r\nбольшое количество разных по назначению библиотек.', 'Фреймворк - в информационных\r\nсистемах структура программной системы; программное обеспечение, облегчающее разработку\r\nи объединение разных компонентов большого программного проекта. В отличие от библиотек,\r\nкоторые объединяют набор подпрограмм близкой функциональности, фреймворк содержит в себе\r\nбольшое количество разных по назначению библиотек.'),
(2, 'Фреймворк Yii', 'yii_framework', 'Вася Петров', '2012-04-01 14:20:33', 'Yii - это высокопроизводительный\r\nвеб-фреймворк, написанный на PHP, и реализующий парадигму MVC. Yii — аббревиатура, которая\r\nрасшифровывается как "Yes It Is!"', 'Yii - это высокопроизводительный\r\nвеб-фреймворк, написанный на PHP, и реализующий парадигму MVC. Yii — аббревиатура, которая\r\nрасшифровывается как "Yes It Is!"'),
(3, 'Фреймворк Symfony', 'symfony_framework', 'Гриша Сидоров', '2012-04-01 14:23:29', 'Symfony — свободный каркас,\r\nнаписанный на PHP5, который использует паттерн Model-View-Controller.\r\nSymfony предлагает\r\nбыструю разработку и управление веб-приложениями, позволяет легко решать рутинные задачи\r\nвеб-программиста. Работает только с PHP 5. Имеет поддержку множества баз данных. Информация\r\nо реляционной базе данных в проекте должна быть связана с объектной моделью. Это можно\r\nсделать при помощи ORM инструмента. Symfony поставляется с двумя из них: Propel и Doctrine.', 'Symfony — свободный каркас,\r\nнаписанный на PHP5, который использует паттерн Model-View-Controller.\r\nSymfony предлагает\r\nбыструю разработку и управление веб-приложениями, позволяет легко решать рутинные задачи\r\nвеб-программиста. Работает только с PHP 5. Имеет поддержку множества баз данных. Информация\r\nо реляционной базе данных в проекте должна быть связана с объектной моделью. Это можно\r\nсделать при помощи ORM инструмента. Symfony поставляется с двумя из них: Propel и Doctrine.');

-- --------------------------------------------------------

--
-- Структура таблицы `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(10) NOT NULL COMMENT 'Идентификатор комментария',
  `article_id` int(10) NOT NULL COMMENT 'Идентификатор статьи',
  `user` varchar(50) NOT NULL COMMENT 'Имя пользователя',
  `message` text NOT NULL COMMENT 'Текст комментария'
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `comments`
--

INSERT INTO `comments` (`id`, `article_id`, `user`, `message`) VALUES
(2, 1, 'Рома', 'Привет'),
(5, 2, 'Вадим', 'Крутой пост!!!');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор статьи',AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор комментария',AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
