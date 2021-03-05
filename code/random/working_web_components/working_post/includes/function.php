<?php 

include '../Posts.php';
include '../includes/connect.php';
//require_once('../includes/session_timeout.inc.php');
//$logged_in_user = $_SESSION['varname'];

	$logged_in_user = "vasquezd";
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
		$stmt_user_id -> bind_param("s", $logged_in_user);
		$stmt_user_id -> execute();
		$stmt_user_id -> bind_result($result_user_id);
		$stmt_user_id -> fetch();
		$logged_in_user_id = $result_user_id;
		$stmt_user_id -> close();
	}
	
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


?>	