<?php
	require_once('../includes/connection.inc.php');
	require_once('../includes/session_timeout.inc.php');
	$conn = dbConnect('read');
	
	$logged_in_user = $_SESSION['varname'];
	$from = $logged_in_user;
	$to = $logged_in_user;
	
	//Get Logged in user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $logged_in_user);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $logged_in_user_id = $result_user_id;
      $stmt_user_id -> close();
    }	
	
	//ADD OR REMOVE A FRIEND	
	$edit_friend_id = $_POST['name'];
	
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
		if (in_array($edit_friend_id, $friend_array))   {
			//If user is found in array of friends then Delete Friend				
			mysqli_query($conn,"DELETE FROM friends WHERE user_id = ('$logged_in_user_id') AND friend_id = $edit_friend_id ");
			//echo "Found in array";
		   } else {
		   //If user is not found then add then add them as a friend
		   	mysqli_query($conn,"INSERT INTO friends (user_name, user_id, friend_id) VALUES ('$logged_in_user', '$logged_in_user_id','$edit_friend_id' )");
			//echo "Not found in array";					
		   }
	}
	//DELETE 
		//mysqli_query($conn,"DELETE FROM post_likes WHERE post_id = 6 AND liked = ('$user_id')");	
?>


