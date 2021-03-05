<?php
require_once('../includes/session_timeout.inc.php');
require_once('../includes/connection.inc.php');	
$conn = dbConnect('read');
	
	//Create local variable with user name 
	$user_name = $_SESSION['varname'];
	
	//Get user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $user_name);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $user_id = $result_user_id;
      $stmt_user_id -> close();
    }
	
	//Get user information from database
	$sql = 'SELECT * FROM user_profile WHERE user_name = "'.$user_name.'"';
	$result = $conn->query($sql) or die(mysqli_error());
	
	//Posts- Get posts, comments and friends
	$sql = 'SELECT * FROM posts WHERE post_to = "'.$user_name.'" ORDER BY created DESC';
	$result_post = $conn->query($sql) or die(mysqli_error());
	
	//Friends- Get all Friends
	$sql = "SELECT friends.friends_id, user_profile.user_name, user_profile.first_name, user_profile.user_id 
	FROM friends INNER JOIN user_profile ON (user_profile.user_id = friends.friend_id) WHERE (friends.user_id = '$user_id')";
	$result_friends = $conn->query($sql) or die(mysqli_error());

	$from = "vasquezd ";
	$to = "james";
	
	//Logout
	//run this script only if the logout button has been clicked
	if (isset($_POST['logout'])) {
	//Empty the $_SESSION array
	$_SESSION = array();
	//Invalidate the session cookie
	if (isset($_COOKIE[session_name()])) {
	setcookie(session_name(), '', time()-86400, '/');
	}
	//End session and redirect
	session_destroy();

	header('Location: http://localhost/ShareShare/index.php');
	exit;
	}	

?>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>ShareShare</title>
	<meta name="description" content=".">
	<meta name="author" content="">
	
	<!-- CSS -->

    
	<!-- 
	<!-- Just for debugging purposes. -->
	<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>
	<body>
	
  
		<div id ="new_posts">	
				<form id = "form" class = "ajax" action = "function.php" method = "post">
					<!--<div><input type = "text" name = "name" placeholder = "Your Name"></div>-->
					<div><textarea name = "message" rows="4" cols="50"> </textarea></div>
					<input type = "submit" value = "New Post">
				</form>
			</div>	
			<!---->

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="main.js"></script>

	</body>
</html>