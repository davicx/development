<?php

include 'connection.inc.php';

class User {
	public $user_id = 0;
	public $user_name = "";
	public $user_email = "";

	public function __construct($user_id) {
		$this->user_id = $user_id;
	}

	//METHOD 1: Get all posts by posted to  
	public function getUser() {
		 
	}	


	//METHOD 2: Delete Post
	public function deleteUser($user_id) {
		global $conn;
		$sql = "UPDATE posts SET post_status= '0' WHERE post_id='$post_id'";

		if (mysqli_query($conn, $sql)) {
			echo "Record updated successfully";
		} else {
			echo "Error updating record: " . mysqli_error($conn);
		}
	} 

}
?>