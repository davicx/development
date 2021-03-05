<?php 
include 'User.php';
include 'includes/connect.php';
	$userName = "Vasquezd";
	$Vasquezd = new User($userName);
	$Vasquezd->getUserInfo($userName);
?>


<!DOCTYPE html>
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>	
	<script src="js/js.js" type="text/javascript" charset="utf-8"></script>	
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

	<h3>User Profile</h3>
		<!--<form action="includes/function.php" method="post" id = "edit-user-profile">-->
		<form action="" method="post" id = "edit-user-profile">
			<p><b>First name: 	</b><textarea rows="1" cols="50" name = "firstName"><?php echo ($Vasquezd->firstName); ?></textarea></p>	
			<p><b>Last name: 	</b><textarea rows="1" cols="50" name = "lastName"><?php echo ($Vasquezd->lastName); ?></textarea></p>	
			<p><b>Email:	 	</b><textarea rows="1" cols="50" name = "email"><?php echo ($Vasquezd->email); ?></textarea></p>	
			<p><b>Biography: 	</b><textarea rows="4" cols="50" name = "biography"><?php echo ($Vasquezd->biography); ?></textarea></p>	
		<input type="submit" name = "submit">
		<div id = "content" style = "border: 1px solid red;"></div>
		
</body>
</html> 
