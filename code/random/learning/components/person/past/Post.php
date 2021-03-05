<?php
include 'includes/connect.php';


class Post {
	
	public function __construct() {
		$this->post_id = $post_id;
		$this->from = $from;
		$this->to = $to;
		$this->comment = $comment;
		$this->created = $created;
		$this->updated = $updated;		
	}	
	
	public function sayHello() {
		echo "Hello";
		echo $this->name;
	} 


}

?>