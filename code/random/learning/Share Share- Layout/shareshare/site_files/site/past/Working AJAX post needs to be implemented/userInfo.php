<?php
include_once('connection.inc.php');
	$conn = dbConnect('write');
	$OK = false;
//	$name = $_POST['name'];
//	$age = $_POST['age'];
	$from = "vasquezd";
	$to = "vasquezd";
	
	$stmt = $conn->stmt_init();
	$sql = "INSERT INTO posts (post_from, post_to, url, caption, created) VALUES('$from','$to',?, ?, NOW())";		  
	if ($stmt->prepare($sql)) {
		//Validate
		if (empty($_POST['name'])) {
			exit();
		}
		$stmt->bind_param('ss', $_POST['name'], $_POST['age']);
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

?>