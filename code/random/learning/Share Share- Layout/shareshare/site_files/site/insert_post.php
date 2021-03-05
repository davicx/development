<?php 
	require_once('../includes/connection.inc.php');
	require_once('../includes/session_timeout.inc.php');
	$conn = dbConnect('read');
	
	$logged_in_user = $_SESSION['varname'];
		
	//Get Logged in user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $logged_in_user);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $logged_in_user_id = $result_user_id;
      $stmt_user_id -> close();
    }
	
	if (isset($_POST['new_post'])) {
		$new_post = ($_POST['new_post']);
		$post_id = intval($_POST['post_id']);
		
		//SQL to update new post to database
		$sql = "UPDATE posts SET caption=? WHERE post_id=?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('si', $new_post, $post_id);
		$stmt->execute();
		
		//Output to callback function 
		echo ($_POST['new_post']);

		if ($stmt->errno) {
		  echo "Could not update post" . $stmt->error;
		}
		$stmt->close();

	}
	
	//PHP Function 1: Update a like status for a post
	if (isset($_POST['like_id'])) {
		$post_id = intval($_POST['like_id']);
		$result_likes = mysqli_query($conn,"SELECT * FROM post_likes WHERE post_id = '".$post_id."'");
		$loop_count = 0;	
		$like_array[0] = 1;

		//Create array
		while($row_likes = mysqli_fetch_array($result_likes)) {
			$like_array[$loop_count]= $row_likes['liked'];
			$loop_count = $loop_count + 1;
		}
		//If post has been liked already unlike otherwise like the post
		if (in_array($logged_in_user_id, $like_array))   {
			mysqli_query($conn,"DELETE FROM post_likes WHERE post_id = ('$post_id') AND liked = $logged_in_user_id ");
			//echo "UnLiked";
		} else {
			mysqli_query($conn,"INSERT INTO post_likes (post_id, liked) VALUES ('$post_id', '$logged_in_user_id' )");
			//echo "Liked";
		}
	}
		

?>