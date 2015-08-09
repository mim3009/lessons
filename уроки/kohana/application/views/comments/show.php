<?php foreach($comments as $comment): ?>
 
    <div style="padding:10px; margin-bottom:10px; border-bottom:#999 1px dashed;">
        <strong><?php echo HTML::chars($comment['user']); ?></strong><br />
        <?php echo HTML::chars($comment['message']); ?>
    </div>
 
<?php endforeach; ?>
<div style="padding:10px;">
  <form action="" method="post">
    <table width="500" border="0" cellspacing="5" cellpadding="5">
      <tr>
        <td>
        Ваше имя: <br />
        <input name="user" type="text" value="<?php echo HTML::chars(Arr::get($_POST, 'user')); ?>" />
        </td>
        <td>
        <strong style="color:#f00;"><?php if(isset($errors['user'])) echo $errors['user']; ?></strong>
        </td>
      </tr>
      <tr>
        <td>
        Ваш e-mail: <br />
        <input name="email" type="text" value="<?php echo HTML::chars(Arr::get($_POST, 'email')); ?>" />
        </td>
        <td>
        <strong style="color:#f00;"><?php if(isset($errors['email'])) echo $errors['email']; ?></strong>
        </td>
      </tr>
      <tr>
        <td>
        Сообщение: <br />
       <textarea name="message" cols="25" rows="5"><?php echo HTML::chars(Arr::get($_POST, 'message')); ?>
  </textarea>
        </td>
        <td valign="middle">
          <strong style="color:#f00;"><?php if(isset($errors['message'])) echo $errors['message']; ?></strong>
        </td>
      </tr>
    </table>
    <input name="send" type="submit" value="Отправить" />
  </form>
</div>