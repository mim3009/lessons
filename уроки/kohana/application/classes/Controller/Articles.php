<?php defined('SYSPATH') or die('No direct script access.');
 
class Controller_Articles extends Controller_Common {
 
    public function action_index()
    {
        $articles = array();
        $content = View::factory('/pages/articles')
                    ->bind('articles', $articles);
        $article = new Model_Article();
        $articles = $article->get_all();
        $this->template->content = $content;
    }
 
    public function action_article()
    {
        $id = $this->request->param('id');
 
        $content = View::factory('/pages/article')
                        ->bind('article', $article)
                        ->bind('comments', $comments);
 
        $article = Model::factory('Article')->get_article($id);
 
        $comments_url = 'comments/' . $id;
        $comments = Request::factory($comments_url)->execute();
 
        $this->template->content = $content;
    }    
 
} 

?>