<?php
	//This redirect is messed up
	require_once('functions/includes/constants.inc.php');
	require_once('functions/includes/session_timeout_index.inc.php');
	include('functions/includes/logout.inc.php'); 
	require_once('functions/includes/connection.inc.php');		
		
	$error = '';
	
	if (isset($_POST['login'])) {
		//session_start();
		$user_login = "Ycombinator";
		$username = trim($_POST['username']);
		$password = trim($_POST['pwd']);
		$_SESSION['varname'] = $username;
		
		$redirect = "site_files/squares.php";
		
		require_once('functions/includes/authenticate.inc.php');	
	}

	if(isset($_SESSION['status'])){
		header("Location: site_files/squares.php");
		echo "logged in";
	} else {
		echo "not logged in";
	}
?>
<!DOCTYPE html>
<html>
    <head>
        <title>ShareSpace</title>
		<!-- CSS -->
    </head>
    <body> 
		<header>

		</header>


			<!-- SECTION: Login Area -->
			<section id = "login">

				<form id = "login-form" class="" method="post" action="">
					
						<input type="text" placeholder=" username" name="username" id="username" class ="login-email">
						<input type="password" placeholder="password" name="pwd" id="pwd" class ="login-password"><br /> <br />
						<button type="submit" name = "login" id="login-btn" class="login-in ss-button ss-font">log in</button>					
						<input type="button" value="sign up" onclick="window.location.href='site_files/register.php'" id="sign-up"> 
						<br /> <br />
						<label class="login-remember" for="remember">
							<input id="remember" type="checkbox"> keep me signed in
						</label>
				
				</form>
	
			<?php 
				if(!empty($_GET['message'])) {
					$message = $_GET['message'];
					echo $message;
				}
				
				if ($error) {
				  echo "<p class=\"expired-session\"><b>$error</b></p>";
				} elseif (isset($_GET['expired'])) {
			?>
				<p id = "expired-session" class="expired-session"><b>Your session has expired. Please log in again.</b></p>
			<?php } ?>
				
			</section>

		
		<script>    
		if(typeof window.history.pushState == 'function') {
			window.history.pushState({}, "Hide", "index.php");
		}
		</script>	
    </body>
</html>