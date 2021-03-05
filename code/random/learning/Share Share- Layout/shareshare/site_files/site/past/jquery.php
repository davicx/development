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
		
	$user_id = $_POST['name'];
	
	//FRIEND ADD OR DELETE CODE
	//$post_id will be generated from what post is clicked on
	if(isset($_POST['name'])) {		
		$result = mysqli_query($conn,"SELECT * FROM friends WHERE user_id = ('$logged_in_user_id')");
		$loop_count = 0;	

		//Create array
		while($row = mysqli_fetch_array($result)) {
			$friend_array[$loop_count]= $row['friend_id'];
			$loop_count = $loop_count + 1;
		}

		//Check for a friend match inside of array
		if (in_array($user_id, $friend_array))   {
			//If user is found in array of friends then Delete Friend				
		   	mysqli_query($conn,"DELETE FROM friends WHERE user_id = ('$logged_in_user_id') AND friend_id = $user_id ");
			//echo "You are no longer friends";
		   } else {
		   //If user is not found then add then add them as a friend
		   	mysqli_query($conn,"INSERT INTO friends (user_name, user_id, friend_id) VALUES ('$logged_in_user', '$logged_in_user_id','$user_id' )");
		//	echo "Now you are friends";					
		   }
	}
	
		//INSERT
		//mysqli_query($conn,"INSERT INTO post_likes (post_id, liked, time_stamp) VALUES ('5', '$user_id', now())");
	
		//DELETE 
		//mysqli_query($conn,"DELETE FROM post_likes WHERE post_id = 6 AND liked = ('$user_id')");
	
?>