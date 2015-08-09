<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title><?= $title;?></title>
	<meta name="description" content="<?= $description;?>">
	<?php
		foreach ($styles as $style):
	?>
			<link rel="stylesheet" type="text/css" href="<?= URL::base();?>public/css/<?=$style;?>.css">
	<?php
		endforeach;
	?>
</head>
<body>
	<div class="layer">
    <div class="container">
      <div class="header"><h1>Логотип</h1></div>
 
      <div class="left">
        <h3>Меню</h3>
        <br />
        <ul>
          <li><a href="<?php echo URL::site(); ?>">Главная</a></li>
          <li><a href="<?php echo URL::site('articles'); ?>">Статьи</a>
            <ul>
              <li><a href="<?php echo URL::site('articles/1-about_framework'); ?>">О фреймворке</a></li>
              <li><a href="<?php echo URL::site('articles/2-yii_framework'); ?>">YII фреймворк</a></li>
              <li><a href="<?php echo URL::site('articles/3-symfony_framework'); ?>">Фреймворк Symfony</a></li>
            </ul>
          </li>
          <li><a href="<?php echo URL::site('about'); ?>">О сайте</a></li>
          <li><a href="<?php echo URL::site('contacts'); ?>">Мои контакты</a></li>  
        </ul>
      </div>
      <div class="content"><?php echo $content; ?></div>
 
      <div class="clearing"></div>
      <div class="footer">2015&copy;mim3009 Все права защищены</div>
    </div>
  </div>
</body>
</html>