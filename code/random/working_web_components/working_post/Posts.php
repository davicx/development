<?php
include 'includes/connect.php';

class Posts{
	public $post_id = "";
	public $post_from = "";
	public $post_to = "";
	public $post_text = "";
	public $image_url = "";
	public $link_url = "";
	public $article_text = "";
	public $like_id = "";
	public $comment_id = "";
	public $created = "";
	public $updated = "";
		
	
	public function __construct($post_id) {
		$this->post_id = $post_id;
	}

	public function getUserPost($post_id) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM posts WHERE post_id = '$post_id' ");

		while($row = mysqli_fetch_array($result)) {		
			$this->post_from = $row['post_from']; 
			$this->post_to = $row['post_to']; 
			$this->post_text = $row['post_text']; 
			$this->image_url = $row['image_url']; 
			$this->link_url = $row['link_url']; 
			$this->article_text = $row['article_text']; 
			$this->like_id = $row['like_id']; 
			$this->comment_id = $row['comment_id']; 
			$this->created = $row['created']; 
			$this->updated = $row['updated']; 
		  }
	} 
	
	public function updatePost($newFirstName, $newLastName, $newEmail, $newBiography, $primary_id) {
		global $conn;
		$sql = "UPDATE persons SET first_name = ?, last_name = ?, email = ?, biography= ? WHERE primary_id = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('ssssi', $newFirstName, $newLastName, $newEmail, $newBiography, $primary_id);
		$stmt->execute();	
	}

	public function makeComment() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function updateComment() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function deleteComment() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function likePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 

	public function unlikePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 
		
	public function deletePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
}




?>

