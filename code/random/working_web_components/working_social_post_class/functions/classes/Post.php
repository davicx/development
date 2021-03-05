<?php
require_once('connection.inc.php');	

class Post{
	public $postID	 		= "";
	public $postFrom 		= "";
	public $postTo	 		= "";
	public $message			= "";
	public $imageURL 		= "";
	public $linkURL			= "";
	public $articleURL		= "";
	public $postLikes 		= array();
	public $postDislike		= array();
	public $commentIDs		= array();
	
	
	public function __construct($postID) {
		$this->postID = $postID;
	}

	public function getPostInfo($postID) {
		global $conn;
		$post_id = $postID; 
		
		//Step 1: Get all information that is not an array 
		$sql = "SELECT * FROM posts WHERE post_id = '$post_id'";
		$result = $conn->query($sql) or die(mysqli_error());
		
		while($row = mysqli_fetch_array($result)) {		
			$this->postFrom 	= $row['post_from']; 
			$this->postTo 		= $row['post_to'];
			$this->message		= $row['post_text'];
			$this->imageURL		= $row['post_text'];
			$this->linkURL		= $row['post_text'];	
			$this->articleURL		= $row['post_text'];
		  }
			//Step 2: Get all likes and dislikes and store in array 
			//Instantiate array to hold post likes and dislikes
			$post_likes = array();
			$post_dislikes = array();

			$sql = "SELECT liked_by FROM post_likes WHERE post_id = '$post_id'";
			$result_likes = $conn->query($sql) or die(mysqli_error());	

			//Get all likes for that post 
			while($row_likes = mysqli_fetch_array($result_likes)) {
				//echo $row_square_friend['user_name'];
				//echo "<br />";
				$post_likes[] = $row_likes['liked_by'];
			}
			
			$this->postLikes= $post_likes;
			
			//Step 3: Get all comment IDs
			//Instantiate array to hold comment ids 
			$comment_ids = array();		
			
			$sql = "SELECT comment_id FROM comments WHERE comment_post_id = '$post_id'";
			$result_comments = $conn->query($sql) or die(mysqli_error());	

			//Get all likes for that post 
			while($row_comments = mysqli_fetch_array($result_comments)) {
				//echo $row_square_friend['user_name'];
				//echo "<br />";
				$comment_ids[] = $row_comments['comment_id'];
			}
			
			$this->commentIDs = $comment_ids;
			
	} 
	
	
	public function deletePost($postID) {
		global $conn;

		$post_id = $postID;
		mysqli_query($conn,"UPDATE post_likes SET status=0, updated = (current_timestamp) WHERE post_id = $post_id");

	}	
	
	public function likePost($postID, $likedBy) {
		global $conn;
		
		$post_id = $postID;
		$liked_by = $likedBy;
		
		$insert = $conn->prepare("INSERT INTO post_likes (post_id, liked_by) VALUES (?,?) ");
		$insert->bind_param('is', $post_id, $liked_by);
		if ($insert->execute()) {
			echo "worked";
		} else {
			echo "Can not be processed";
		}
		
	}	
	
	 
	public function unlikePost($postID, $likedBy) {
		global $conn;
			
		$post_id = $postID;
		$liked_by = $likedBy;	
		
		$sql = "DELETE FROM post_likes WHERE post_id='$post_id' and liked_by = '$liked_by'";

		if (mysqli_query($conn, $sql)) {
			echo "Post deleted successfully";
		} else {
			echo "Error deleting record: " . mysqli_error($conn);
		}

	}	
 
	public function dislikePost($postID, $likedBy) {
		global $conn;
		
		
	}	

}
/*
	public $postFrom 		= ""; //Username
	public $postTo	 		= ""; //Username
	public $messages 		= ""; //
	public $imageURL 		= "";
	public $linkURL			= "";
	public $articleURL		= "";
	public $postLikes 		= array();
	public $postDislike		= array();
	public $commentIDs		= array();

*/
?>

