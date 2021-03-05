<?php
if (isset($_POST['register'])) {
  $username = trim($_POST['username']);
  $retyped = trim($_POST['conf_pwd']);  
  $pword = trim($_POST['pwd']);

  require_once('../functions/includes/register_user.inc.php');
  
}
?>
<!DOCTYPE HTML>
<html>
	<head>
        <title>ShareSpace</title>
		

	</head>

	<body>


	
			<section id = "login">

						<form id="form1" class = "" method="post" action="">
							<p><label for="username">Username:</label><input type="text" name="username" id="username" placeholder="Username" required></p>
							<p><label for="pwd">Password:</label><input type="password" placeholder="Password" name="pwd" id="pwd" required></p>
							<p><label for="conf_pwd">Confirm password:</label><input type="password" placeholder="Confirm Password"name="conf_pwd" id="conf_pwd" required></p>			
							<p><input name="register" type="submit" id="register" value="Register"></p>
								
						</form>	
							<p ><a href="../index.php">Or login to you existing account!</a> </p>	
						<?php
							if (isset($success)) {
							  echo "<p>$success</p>";
								header("Location: ../index.php?message=You have registered");
								die();
							} elseif (isset($errors) && !empty($errors)) {
							  echo '<ul class = "alert">';
							  foreach ($errors as $error) {
								echo "<li>$error</li>";
							  }
							  echo '</ul>';
							}
						?>
	
			</section>
	
	</body>
</html>
