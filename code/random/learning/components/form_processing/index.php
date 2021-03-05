<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">


	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/report.css">
	<script src="js/vendor/modernizr-2.6.2.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">

	

<script>
$(function() {
$( "#datepicker_id" ).datepicker();
});
</script>
	

	
	<div id = "fixed-header-background">

	</div>

	<div id = "site-wrapper">
		<!-- Header -->
		<header id = "fixed">
			<img border="0" id = "header-logo" src="images/osu-tag.png" alt="OSU" width="100">
			<h1 id = "header-text"> Career Services Dashboard </h1>			
			<div id="container" >
				<!-- Navigation Bar -->
				<div id = "navigation-background">
					<nav id="navigation">
						<ul>
							<li><a href="index.php">Home</a></li>
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
		
			<!-- Main Body -->	
			<section id = "connection-list">		

			</section>
			
			<section id = "report-connection">
				<form name="input" id="target" action="functions/function.php" method="post">	
					<img border="0" id = "connection-user-image" src="images/rachelfinch.jpg" alt="OSU" width="80" height = ""><br /><br />
					<p class = "staff-connection-name"><label> Rachel Finch </label> </p>

					<!-- Form Input -->
					<p class = "individual-connection-subtitle"><label>Select College:</label>
						 <select name = "college" id = "college_id">
							<option value="College of Business">College of Business</option>
							<option value="College of Engineering">College of Engineering</option>
							<option value="College of Forestry">College of Forestry</option>
							<option value="College of CEOAS">College of CEOAS</option>
						</select>					
					</p>		
					
					<p class = "individual-connection-subtitle"><label> Contact Name: </label><input type="text" name="contact" id = "contact_id" value = "" class = "individual-connection-text"> </p>
					<p class = "individual-connection-subtitle"><label> Title: </label> <input type="text" name="title" id = "title_id" value = "" class = "individual-connection-text"> </p> 
					<p class = "individual-connection-subtitle"><label> Date: </label><input type="text" name= "date" id="datepicker_id" class = "individual-connection-text"></p>
					<p class = "individual-connection-subtitle"><label> Purpose: </label><textarea rows="4" cols="50" name = "purpose" id = "purpose_id" class = "individual-connection-purpose">Please describe the contact. </textarea></p>									
					

					<br /><input type="submit" name="submit" id = "submit-form" value="Submit">

				</form> 
			</section>

		</div>
		
		
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
    <script src="js/main.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	
		

    </body>
</html>
