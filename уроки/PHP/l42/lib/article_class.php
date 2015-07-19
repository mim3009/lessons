<?php
	require_once "global_class.php";

	class Article extends GlobalClass{

		public function __construct($db){
			parent::__construct("articles", $db);
		}

		public function getAllSortDate(){
			return $this->getAll("date", false);
		}

		public function getAllOnSectionID($section_id){
			return $this->getAllOnField("section_id", $section_id, "date", false);
		}

		public function searchArticles($words){
			return $this->search($words, array("title", "full_text"));
		}

		public function getTitle($id){
			return $this->getFieldOnID($id, "title");
		}

		public function getIntroText($id){
			return $this->getFieldOnID($id, "intro_text");
		}

		public function getFullText($id){
			return $this->getFieldOnID($id, "full_text");
		}

		public function getMetaDesc($id){
			return $this->getFieldOnID($id, "meta_desc");
		}

		public function getMetaKey($id){
			return $this->getFieldOnID($id, "meta_key");
		}

		public function getImageSrc($id){
			return $this->getFieldOnID($id, "image_src");
		}

		public function getDate($id){
			return $this->getFieldOnID($id, "date");
		}

		public function setTitle($id, $title){
			return $this->setFieldOnID($id, "title", $title);
		}

		public function setIntroText($id, $intro_text){
			return $this->setFieldOnID($id, "intro_text", $intro_text);
		}

		public function setFullText($id, $full_text){
			return $this->setFieldOnID($id, "full_text", $full_text);
		}

		public function setMetaDesc($id, $meta_desc){
			return $this->setFieldOnID($id, "meta_desc", $meta_desc);
		}

		public function setMetaKey($id, $meta_key){
			return $this->setFieldOnID($id, "meta_key", $meta_key);
		}

		public function setImageSrc($id, $image_src){
			return $this->setFieldOnID($id, "image_src", $image_src);
		}

		public function setDate($id, $date){
			return $this->getFieldOnID($id, "date", $date);
		}

	}

?>