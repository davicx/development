<?php
if (isset($_POST['insert'])) {

  require_once('../includes/connection.inc.php');
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
	//THIS IS WORKING USE TO VALIDATE	
	  if (empty($_POST['title'])) {
		exit();
		}
	//VALIDATE
	
	
	$stmt->bind_param('ss', $_POST['title'], $_POST['article']);
    
	// execute and get number of affected rows
	$stmt->execute();
	if ($stmt->affected_rows > 0) {
	  $OK = true;
	}
  }
  // redirect if successful or display error
  if ($OK) {
	header('Location: http://localhost/ShareShare/site_files/site/user_profile.php');
	exit;
  } else {
	$error = $stmt->error;
  }
}
//My END BELOW 


?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Insert Blog Entry</title>
<link href="style/admin.css" rel="stylesheet" type="text/css">

<head>
<script src="jquery-1.10.2.min.js"></script></head> 
</head>

<body>
<h1>Insert New Post</h1>
<?php if (isset($error)) {
  echo "<p>Error: $error</p>";
} ?>
<form name = "form1" id="form1" method="post" action="" onsubmit="return validate()"> 
  <p>
    <label for="title">url:</label>
    <input name="title" type="text" class="widebox" id="title">
  </p>
  <p>
    <label for="article">caption:</label>
    <textarea name="article" cols="60" rows="8" class="widebox" id="article"></textarea></input><div id="errfn">   </div>
  </p>
  <p>
<input type="submit" name="insert" value="Insert New Entry" id="insert"> 


  </p>
</form>
</body>
</html>