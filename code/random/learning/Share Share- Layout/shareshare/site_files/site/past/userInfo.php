<?php
require_once('../includes/session_timeout.inc.php');
require_once('../includes/connection.inc.php');	
$conn = dbConnect('read');
	
	//Create local variable with user name 
	$user_name = $_SESSION['varname'];
	$from = $user_name;
	$to = $user_name;
	
	//Get user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $user_name);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $user_id = $result_user_id;
      $stmt_user_id -> close();
    }
	
	$conn = dbConnect('write');
	$OK = false;
//	$name = $_POST['name'];
//	$age = $_POST['age'];

	$stmt = $conn->stmt_init();
	$sql = "INSERT INTO posts (post_from, post_to, url, caption, created) VALUES('$from','$to',?, ?, NOW())";		  
	if ($stmt->prepare($sql)) {
		//Validate
		if (empty($_POST['name'])) {
			exit();
		}
		$stmt->bind_param('ss', $_POST['name'], $_POST['message']);
		//Execute and get number of affected rows
		$stmt->execute();
		if ($stmt->affected_rows > 0) {
			$OK = true;
		}
	} if ($OK) {
		//echo "Inserted";
		} else {
			$error = $stmt->error;
		}

?>