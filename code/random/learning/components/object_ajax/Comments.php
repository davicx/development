<?php
include 'includes/connect.php';

class Comments{
	public $logged_in_user = "";
	public $comment_id = "";
	public $post_id = "";
	public $comment_from = "";
	public $comment_to = "";
	public $comment = "";
	public $comment_like_id = array();
	public $comment_total_likes = "";
	public $created = "";
	public $updated = "";
		
	
	public function __construct($post_id, $logged_in_user) {
		$this->post_id = $post_id;
		$this->logged_in_user = $logged_in_user;
	}

	public function getPostComments($post_id) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM comments WHERE comment_post_id = '$post_id'");

		while($row = mysqli_fetch_array($result)) {		
			$this->comment_from = $row['comment_from']; 
			$this->comment_to = $row['comment_to']; 
			$this->comment = $row['comment']; 
			$this->created = $row['created']; 
			$this->updated = $row['updated']; 
		}
	}
}	
	/*	
		//If you like it so logged in user id matches one then it stays liked 
		$result_likes = mysqli_query($conn,"SELECT * FROM comment_likes WHERE comment_id = '$post_id' ");	
		
		while($row_likes = mysqli_fetch_array($result_likes)) {		
			$this->like_id[] = $row_likes['liked'];
		}
	
		//Get total number of likes for each post
		$this->total_likes = count($this->like_id);
		  
	} 
	*/	

?>

