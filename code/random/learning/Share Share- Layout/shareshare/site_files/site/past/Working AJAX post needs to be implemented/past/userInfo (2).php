<?php
  require_once('../includes/connection.inc.php');
//if (isset($_POST['insert'])) {
if (isset($_POST['submit'])) {
  // initialize flag
  $OK = false;
  // create database connection
  $conn = dbConnect('write');
  // initialize prepared statement
  $stmt = $conn->stmt_init();
  // create SQL
  $sql = 'INSERT INTO posts (url, caption, created)
		  VALUES(?, ?, NOW())';		  
  if ($stmt->prepare($sql)) {

  // bind parameters and execute statement
	  if (empty($_POST['title'])) {
		exit();
		}
	//validate and bind parameters
	$stmt->bind_param('ss', $_POST['title'], $_POST['article']);
    
	// execute and get number of affected rows
	$stmt->execute();
	if ($stmt->affected_rows > 0) {
	  $OK = true;	
	}
  }
  // redirect if successful or display error
  if ($OK) {
	  echo "inserted";
	//header('Location: http://localhost/ShareShare/site_files/posts/post_list.php');
	//exit;
  } else {
	$error = $stmt->error;
  }
}
?>