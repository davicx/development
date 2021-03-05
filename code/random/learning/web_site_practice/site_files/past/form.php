<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
    <script src="../js/main.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="../images/favicon.ico" />
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" type="text/css" href="../css/report.css">
	<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	

<script>
$(function() {
$( "#datepicker" ).datepicker();
});
</script>
	
	
</head>
    <body>
	
	
	<div id = "fixed-header-background">

	</div>

	<div id = "site-wrapper">
		<!-- Header -->
		<header id = "fixed">
			<img border="0" id = "header-logo" src="../images/osu-tag.png" alt="OSU" width="100">
			<h1 id = "header-text"> Career Services Dashboard </h1>
			
		<div id="container" >
			<!-- Navigation Bar -->
			<div id = "navigation-background">
				<nav id="navigation">
					<ul>
						<li><a href="../index.php">Home</a></li>
						<li><a href="connections.php">Connections</a></li>
						<li><a href="#">Reporting</a></li>
						<li><a href="#">Docs</a></li>
						<li><a href="#">Calendar</a></li>
						<li><a href="site/profile.php">Profile</a></li>
						<li><a href="#">FAQ</a></li>
					</ul>
				</nav>
			</div>	
		</div>
		
		</header>
		
		<!-- Main Body  -->	
<!DOCTYPE HTML>
<html>
<head>



		<form method="post" action="">
		   <p>Contact Name: <input type="text" name="name"> </p>
		   <span class="error"></span>
		   
		   <p>Title: <input type="text" name="name"></p>
		   <span class="error"></span><br>
		   
		   E-mail: <input type="text" name="email">
		   <span class="error"></span>
		   <br><br>
		   Website: <input type="text" name="website">
		   <span class="error"></span>
		   <br><br>
		   Comment: <textarea name="comment" rows="5" cols="40"></textarea>
		   <br><br>
		   Gender:
		   <input type="radio" name="gender" value="female">Female
		   <input type="radio" name="gender" value="male">Male
		   <span class="error"></span>
		   <br><br>
		   <input type="submit" name="submit" value="Submit">
		</form>



	</div>
	
		<!-- Footer -->
		<footer>
		</footer> 
    </body>
</html>
