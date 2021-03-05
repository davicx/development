<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
require_once('../functions/includes/session_timeout.inc.php');
		
	$logged_in_user = $_SESSION['varname'];
	$result_user_profile = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_name = '$logged_in_user'");

?>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="../images/favicon.ico" />
	
	<!-- CSS -->
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" href="../css/report.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	<!-- JS -->
	<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/main.js"></script>
	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/demos/style.css">


    <body>

	<div id = "fixed-header-background"> </div>

	<div id = "site-wrapper">
		<!-- Header -->
		<?php require_once('../functions/includes/header.php');	?>

		<section id = "connection-list">		

		</section>

		<section id = "report-connection">
			<form name="input" id="target" action="../functions/function.php" onsubmit="return validateForm()" method="post">
				<div class = "report-connection-formatting">						
					<?php while($row_user_profile = mysqli_fetch_array($result_user_profile)) {	 ?>
					
						<div class = "connection-user-image-placeholder"><img border="0" id = "connection-user-image" class = "liaison-submit-user-image" src="../images/<?php echo ($row_user_profile['image_name']); ?>" alt="OSU"  ></div>
						<p class = "liaison-submit-user-name"><label><?php echo ($row_user_profile['first_name']) . " " . ($row_user_profile['last_name']); ?> </label> </p>
					
					<?php }?>

					<!-- Form Input -->
					<h3 class = "submit-liaison-header"> Submit a Liaison </h3>
					<p class = "individual-connection-subtitle"><label>Select College:</label>
						 <select name = "college" id = "college_id">
							<option value="coasc" >College of Agricultural Science</option>
							<option value="cobus" >College of Business</option>
							<option value="ceoas" >College of CEOAS</option>
							<option value="coedu" >College of Education</option>
							<option value="cofor" >College of Forestry</option>
							<option value="colar" >College of Liberal Arts</option>
							<option value="copha" >College of Pharmacy</option>
							<option value="cophh" >College of Public Health</option>		
							<option value="cosci" >College of Science</option>
							<option value="covme" >College of Vet Medicine</option>		
							<option value="gssho" >Graduate School</option>
	
							<option value="uestu" >UESP</option>									
						</select>					
					</p>		
					
					<p class = "individual-connection-subtitle"><label> Contact Name: </label><input type="text" name="contact" id = "contact_id" value = "" class = "individual-connection-text"> </p><p class = "contact-error"></p>
					<p class = "individual-connection-subtitle"><label> Title: </label> <input type="text" name="title" id = "title_id" value = "" class = "individual-connection-text"> </p> 
					<p class = "individual-connection-subtitle"><label> Date: </label><input type="text" name= "date" id="datepicker_id" class = "individual-connection-text"></p><p class = "year-error"></p>
					<p class = "individual-connection-subtitle"><label> Purpose: </label><textarea rows="4" cols="50" name = "purpose" id = "purpose_id" class = "individual-connection-purpose">Please describe the contact. </textarea></p>									
					
					<br /><input type="submit" name="submit" id = "submit-form" value="Submit">
				</div>
			</form> 
		</section>

	</div>
	
		<!-- Footer -->
		<footer>
		</footer> 
    </body>
</html>
