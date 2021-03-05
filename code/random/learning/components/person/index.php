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
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

	<h3>User Profile</h3>
		<p><b>User name: 	</b><?php echo ($Vasquezd->userName);	?></p>	
		<p><b>User id: 		</b><?php echo ($Vasquezd->id);			?></p>	
		<p><b>First name: 	</b><?php echo ($Vasquezd->firstName);	?></p>	
		<p><b>Last name: 	</b><?php echo ($Vasquezd->lastName);	?></p>	
		<p><b>Biography: 	</b><?php echo ($Vasquezd->biography);	?></p>		
		
		<div class = "box">
			<p> I am File </p>
		</div>

		
	</body>
</html> 