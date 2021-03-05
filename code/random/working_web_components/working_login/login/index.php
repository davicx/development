<?php
session_start();

if (isset($_SESSION['varname'])) {
	echo "Yes, mail is set";    
}else{  
	echo "N0, mail is not set";
}

$error = '';
if (isset($_POST['login'])) {
	//session_start();
	$username = trim($_POST['username']);
	$password = trim($_POST['pwd']);
	$_SESSION['varname'] = $username;

	$redirect = 'http://localhost/working_systems/working_login/login/secretpage.php';

	require_once('includes/authenticate.inc.php');
}


?>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />	
		<title>Shared</title>	

	</head>

	<body>
		<form id="form1" method="post" action="">
			<p><label for="username">Username:</label><input type="text" name="username" id="username"></p>
			<p><label for="pwd">Password:</label><input type="password" name="pwd" id="pwd"></p>
			<p><input name="login" type="submit" name = "login" id="login" value="Log in"></p>
		</form>

			<?php 
				if ($error) {
				  echo "<p>$error</p>";
				} elseif (isset($_GET['expired'])) {
			?>
				<p id = "expired-session">Your session has expired. Please log in again.</p>
			<?php } ?>

		<?php include('includes/logout.inc.php'); ?>
	</body>
</html>