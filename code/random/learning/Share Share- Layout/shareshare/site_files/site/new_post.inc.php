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

	//INSERT POST
	if(isset($_POST['new_wall_post'])) {
	
	$OK = false;

	$stmt = $conn->stmt_init();
	$sql = "INSERT INTO posts (post_from, post_to, caption, created) VALUES('$from','$to',?, NOW())";		  
	if ($stmt->prepare($sql)) {
		//Validate
		if (empty($_POST['new_wall_post'])) {
			exit();
		}
		$stmt->bind_param('s', $_POST['new_wall_post']);
		//Execute and get number of affected rows
		$stmt->execute();
		
		if ($stmt->affected_rows > 0) {
			$OK = true;
		}
	} if ($OK) {
		echo "Inserted";
		} else {
			$error = $stmt->error;
		}
	}	
?>
