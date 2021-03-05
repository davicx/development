<?php 

include '../Posts.php';
include '../includes/connect.php';
//require_once('../includes/session_timeout.inc.php');
//$logged_in_user = $_SESSION['varname'];

$logged_in_user = "vasquezd";
$logged_in_user_id = 1;

/*
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
		$stmt_user_id -> bind_param("s", $logged_in_user);
		$stmt_user_id -> execute();
		$stmt_user_id -> bind_result($result_user_id);
		$stmt_user_id -> fetch();
		$logged_in_user_id = $result_user_id;
		$stmt_user_id -> close();
	}
*/	
	//Function 1: Edit a posts text when user clicks on edit button in html 
	if(isset($_POST['post_to_process']) && isset($_POST['post_id_process'])) {
		$new_post = $_POST['post_to_process'];		
		$post_id = $_POST['post_id_process'];

		//SQL to update new post to database
		$sql = "UPDATE posts SET post_text=?, updated = NOW() WHERE post_id=?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('si', $new_post, $post_id);
		$stmt->execute();
		
		//Output to callback function 
		if ($stmt->errno) {
		  echo "Could not update post" . $stmt->error;
		}
		$stmt->close();
		
		echo ($new_post);
	}
	
	//Function 2: Like or Unlike a Post
	if (isset($_POST['like_id'])) {
		$post_id = intval($_POST['like_id']);
		
		$result_likes = mysqli_query($conn,"SELECT * FROM post_likes WHERE post_id = '$post_id'");
		$loop_count = 0;	
		$like_array[0] = 1;

		//Create array
		while($row_likes = mysqli_fetch_array($result_likes)) {
			$like_array[$loop_count]= $row_likes['liked'];
			$loop_count = $loop_count + 1;
		}
		//If post has been liked already unlike otherwise like the post
		if (in_array($logged_in_user_id, $like_array))   {
			mysqli_query($conn,"DELETE FROM post_likes WHERE post_id = ('$post_id') AND liked = '$logged_in_user_id'");
			//echo "UnLiked";
		} else {
			mysqli_query($conn,"INSERT INTO post_likes (post_id, liked) VALUES ('$post_id', '$logged_in_user_id')");
			//echo "Liked";
		}

	}
	
	


?>	