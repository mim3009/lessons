<strong>Список всех статей</strong>
<br />
<?php foreach($articles as $article): ?>
 
    <div>
    	<a href="<?= 'articles/' . $article['id'] . '-' . $article['alt_title'];?>"><strong><?php echo $article['title']; ?></strong></a><br/> 
    </div>
 
<?php endforeach;?>