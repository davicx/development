<?php
if (isset($_POST['register'])) {
  $username = trim($_POST['username']);
  $password = trim($_POST['pwd']);
  $retyped = trim($_POST['conf_pwd']);
  require_once('../includes/register_user_mysqli.inc.php');
}
?>
<!DOCTYPE HTML>
<html>
<head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hootwork</title>

     <!-- Bootstrap core CSS -->
	 
    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/cover.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet"> 		
    <link href="css/contact.css" rel="stylesheet"> 	
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
		<div class="site-wrapper">
		<!-- Header-->
		<header>

			<!--Login-->
			<form action="http://localhost/ShareShare/index.php">
				<div id = "login">	
					  <button type="submit" value="Login" class="login-button btn btn-default">Login</span></button>
				</div>
			</form>
		
			
		</header>


		<!--Body-->
				<div class="content">
				<div class="container-non-responsive">
					<div id = "login-menu">

		
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
				  <p><a href="login.php">Or login to you existing account!</a> </p>
				  
				</form>
				</div>
				</div>
				</div>
				</div>

    </div>

</body>
</html>
