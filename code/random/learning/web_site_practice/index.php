<?php
session_start();
$error = '';
if (isset($_POST['login'])) {
	$username = trim($_POST['username']);
	$password = trim($_POST['pwd']);

	$_SESSION['varname'] = $username;

	$redirect = 'http://localhost/dashboard/site_files/connection_history.php';
	require_once('functions/includes/authenticate.inc.php');
}

if(isset($_SESSION["varname"])) {
	//echo "set";
//	header('Location: http://localhost/dashboard/site_files/connection_history.php');
} else {
//	echo "not set";
}

?>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="images/favicon.ico" />
	
	<!-- CSS -->
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/report.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">

	<!-- JS -->
	<script src="js/vendor/modernizr-2.6.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/main.js"></script>

	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>

    <body>
	<div id = "fixed-header-background"></div>
		<div id = "site-wrapper">
			<!-- Header -->
			<header>	
				<img border="0" id = "header-logo" src="images/osu-tag.png" alt="OSU" width="100">
				<h1 id = "header-text"> Career Services Dashboard </h1>
				
					<!-- Navigation Bar -->		
					<div id = "navigation-position">		
						<div id = "navigation-background">
							<nav id="navigation">
								<ul>
									<li class = "display-hidden"><a href="index.php">Home</a></li>
									<li class = "display-hidden"><a href="site_files/connection_history.php">Connections</a></li>
									<li class = "display-hidden"><a href="#">Reporting</a></li>
									<li class = "display-hidden"><a href="site_files/report_post.php">Report a Liaison</a></li>
									<li class = "display-hidden"><a href="#">Calendar</a></li>
									<li class = "display-hidden"><a href="site/profile.php">Profile</a></li>
									<li class = "display-hidden"><a href="#">FAQ</a></li>
								</ul>
							</nav>
						</div>	
					</div>
			</header>
			
			<!-- Body -->
			<section id = "login-menu">
				<div class = "login-form-position">
					<form id="form1" method="post" action="">
						<p><label for="username">Username:</label><input type="text" name="username" id="username"></p>
						<p><label for="pwd">Password:</label><input type="password" name="pwd" id="pwd"></p>
						<p><input name="login" type="submit" name = "login" id="login" value="Log in"></p>
					</form>
					<a href="http://localhost/dashboard/site_files/register.php" target="">Register</a> 
						<?php 
							if ($error) {
							  echo "<p>$error</p>";
							} elseif (isset($_GET['expired'])) {
						?>
							<p id = "expired-session">Your session has expired. Please log in again.</p>
						<?php } ?>
				</div>
				<!--<?php require_once('functions/includes/logout.inc.php'); ?>-->
			</section>

		</div>
	
		<!-- Footer -->
		<footer>
		</footer> 
    </body>
</html>