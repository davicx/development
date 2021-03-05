<?php
	require_once('includes/session_timeout.inc.php');
	
	$username = $_SESSION['varname'];
		if (isset($_SESSION['varname'])) {
		echo "Yes, mail is set";    
		}else{  
			echo "N0, mail is not set";
		}

?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Secret page</title>
</head>

<body>
<h1>Restricted area</h1>


		<a href="http://localhost/working_systems/working_login/login/secretpage2.php" target="">Secret 2</a> 
		<a href="http://localhost/working_systems/working_login/login/index.php" target="">Index</a> 
		
		<form id="logoutForm" method="post" action="">
			<input name="logout" class="text_button" type="submit" id="logout" value="Log out">
		</form>
<?php include('includes/logout.inc.php'); ?>
</body>
</html>
