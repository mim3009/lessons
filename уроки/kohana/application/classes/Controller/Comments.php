<?php defined('SYSPATH') or die('No direct script access.');
 
class Controller_Comments extends Controller {
 
//Посмотреть урок сообщения об ошибке чтобы ифпост исправить!!! + Валидация комментариев
/*








*/

    public function action_index()
    {
        if($this->request->is_initial())
            Request::initial()->redirect(URL::site(''));
 
        $article_id = $this->request->param('id');
 
        $content = View::factory('/comments/show')
                    ->bind('comments', $comments);
 
        if($_POST){
	        $_POST = Arr::map('trim', $_POST);
	 
	        $post = Validation::factory($_POST);
	        $post -> rule('user', 'not_empty')
		    -> rule('user', 'min_length', array(':value', 2))
		    -> rule('user', 'max_length', array(':value', 20))
		    -> rule('email', 'email')
		    -> rule('message', 'not_empty')
		    -> rule('message', 'max_length', array(':value', 100));
	 
	        if($post -> check()){
	            Model::factory('Comment')->create_comment($article_id, $_POST['user'], $_POST['message']);
	            URL::site(Request::detect_uri());
	        }
	        else
	        {
	           $content->errors = $post->errors('validation');
        	}
        }
 
        $comments = Model::factory('Comment')->get_comments($article_id);
        $this->response->body($content);
    }
 
}

?>