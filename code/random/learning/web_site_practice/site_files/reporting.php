<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
require_once('../functions/includes/session_timeout.inc.php');
		
		
	if (isset($_GET['varname']) && (!empty($_GET['varname']))) {
		$year = $_GET['varname'];	
	} else {
		$year = 2014;
	}

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
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/main.js"></script>
	<script src="../js/reporting.js"></script>
	
	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/demos/style.css">
		
    <body>
		<div class = "get-year"><?php echo $year; ?> </div>
		<div id = "fixed-header-background"></div>
			
		<div id = "site-wrapper">
			<!-- Header -->
			<?php require_once('../functions/includes/header.php');	?>
			
			<!-- Year to Report -->
			
			<aside id = "report-year">
				<h3 class = "year-header-font"> Year </h3>			
					<p class = "button-year-style"><a href="reporting.php?varname=2014" class = "link-year-style">2014 </a></p>
					<p class = "button-year-style"><a href="reporting.php?varname=2015" class = "link-year-style">2015 </a></p>
					<p class = "button-year-style"><a href="reporting.php?varname=2016" class = "link-year-style">2016 </a></p>
					<p class = "button-year-style"><a href="reporting.php?varname=2017" class = "link-year-style">2017 </a></p>
			</aside>
			
			<div id = "report-area"
				<!-- Options -->
				<aside id = "option-bar">
					<div class = "report-float-left">
						<h3 class = ""> Report Options </h3>
					</div>

					<div class = "report-float-left">
						<p> Report by College</p>
						<form>	
							<select class = "college-event-handler">
								<option value="College of Business">College of Business</option>
								<option value="College of Engineering">College of Engineering</option>
								<option value="CEOAS">CEOAS</option>
								<option value="College of Public Health">College of Public Health</option>
							</select>
						</form>	
					</div>	

					<div class = "report-float-left">
						<p> Report by Staff</p>
						<form>
							<select class = "staff-event-handler">
								<option value="Rachel">Rachel</option>
								<option value="David">David</option>
								<option value="Michael">Michael</option>
								<option value="David">David</option>
							</select>
						</form>			
					</div>				
				</aside>
				

				<!-- Reports -->
				<section id = "reports">			
					<div id="chart_div" style="width: 800px; height: 500px;"></div>
				</section>
			</div>	

		
		</div>

		<!-- Footer -->
		<footer>
		</footer> 
    </body>
</html>
