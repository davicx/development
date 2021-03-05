<?php
if (isset($_POST['register'])) {
  $username = trim($_POST['username']);
  $password = trim($_POST['pwd']);
  $retyped = trim($_POST['conf_pwd']);
  require_once('includes/register_user.inc.php');
}
?>
<!DOCTYPE HTML>
<html>
<head>
	<title>Register</title>
</head>

<body>


		
				<?php
				if (isset($success)) {
				  echo "<p>$success</p>";
				} elseif (isset($errors) && !empty($errors)) {
				  echo '<ul>';
				  foreach ($errors as $error) {
					echo "<li>$error</li>";
				  }
				  echo '</ul>';
				}
				?>
				
				
				<form id="form1" method="post" action="">
				  <p>
					<label for="username">Username:</label>
					<input type="text" name="username" id="username" required>
				  </p>
				  <p>
					<label for="pwd">Password:</label>
					<input type="password" name="pwd" id="pwd" required>
				  </p>
				  <p>
					<label for="conf_pwd">Confirm password:</label>
					<input type="password" name="conf_pwd" id="conf_pwd" required>
				  </p>
				  <p>
					<input name="register" type="submit" id="register" value="Register">
				  </p>
				  <p><a href="index.php">Or login to you existing account!</a> </p>
				  
				</form>
				</div>
				</div>
				</div>
				</div>


</body>
</html>
