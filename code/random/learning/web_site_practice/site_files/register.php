<?php
if (isset($_POST['register'])) {
  $username = trim($_POST['username']);
  $password = trim($_POST['pwd']);
  $retyped = trim($_POST['conf_pwd']);
  require_once('../functions/includes/register_user.inc.php');

}
?>
<!DOCTYPE HTML>

<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="images/favicon.ico" />
	
	<!-- CSS -->
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" href="../css/report.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	<!-- JS -->
	<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/main.js"></script>
	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>

    <body>

	<div id = "fixed-header-background">

	</div>

	<div id = "site-wrapper">
		<!-- Header -->
			<header>	
				<img border="0" id = "header-logo" src="../images/osu-tag.png" alt="OSU" width="100">
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

		
		<section id = "login-menu">
			<form id="form1" class = "register-form" method="post" action="">
				<p><label for="username">Username:</label><input type="text" name="username" id="username" required></p>	
				<p><label for="pwd">Password:</label><input type="password" name="pwd" id="pwd" required></p>
				<p><label for="conf_pwd">Confirm password:</label><input type="password" name="conf_pwd" id="conf_pwd" required></p>	
				<p><label for="">Email:</label><input type="email" name="email" id="email"></p>				
				<p><input name="register" type="submit" id="register" class = " uk-button" value="Register"></p>
				<p><a href="../index.php">Or login to you existing account!</a> </p>			
			</form>	
			
			<?php
				if (isset($success)) {
				  echo "<p>$success</p>";
				} elseif (isset($errors) && !empty($errors)) {
				  echo '<ul class = "alert">';
				  foreach ($errors as $error) {
					echo "<li>$error</li>";
				  }
				  echo '</ul>';
				}
			?>

			</form>		
		</section>

	</div>
	
		<!-- Footer -->
		<footer>
		</footer> 
    </body>
</html>

