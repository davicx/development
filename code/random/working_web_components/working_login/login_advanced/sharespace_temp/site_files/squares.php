<?php
	require_once('../functions/includes/session_timeout.inc.php');
	require_once('../functions/includes/connection.inc.php');	

	$logged_in_user = $_SESSION['varname'];
	$user_name = $logged_in_user;
	
	
?>

<!DOCTYPE html>
<html>
    <head>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ShareSquare</title>
			

	
    </head>
    <body>		
		<header></header>	
		
			<p> secret page </p>
			<?php include('../functions/includes/logout.inc.php'); ?>
	
    </body>
</html>