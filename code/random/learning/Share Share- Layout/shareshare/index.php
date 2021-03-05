<?php
$error = '';
if (isset($_POST['login'])) {
	session_start();
	$username = trim($_POST['username']);
	$password = trim($_POST['pwd']);

	$_SESSION['varname'] = $username;
	$redirect = 'http://localhost/ShareShare/site_files/site/user_profile.php';
	require_once('site_files/includes/authenticate.inc.php');
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
		<div class="site-wrapper">	
			<!-- Navigation-->
			<div id = "navigation">
					<a href="#home">Share Share</a>
			</div>	
			<!--Login-->
			<div id = "login-main">	
				<h2> Share Share </h2>
					<p> Share everything you love </p>
					<!--<p> Make a bookmarks as a drop down from the tool bar </p>-->

					<form id="form1" method="post" action="">
						<p><label for="username">Username:</label><input type="text" name="username" id="username"></p>
						<p><label for="pwd">Password:</label><input type="password" name="pwd" id="pwd"></p>
						<p><input name="login" type="submit" name ="login" id="login" value="Log in"></p>
					</form>
					<p><a href="site_files/site/register.php">Or sign up for a new account!</a> 
				<!-- Session Logout -->
				<?php 
					if ($error) {
					  echo "<p>$error</p>";
					} elseif (isset($_GET['expired'])) {
				?>
					<p id = "expired-session">Your session has expired. Please log in again.</p>
				<?php } ?>
				
			</div>
	</body>
</html>