<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
include '../functions/function.php';

require_once('../functions/includes/session_timeout.inc.php');
	$logged_in_user = $_SESSION['varname'];
	//Query database to get all posts 
	$result = mysqli_query($conn,"SELECT * FROM liason_connection ORDER BY date DESC ");
	$result_recent = mysqli_query($conn,"SELECT * FROM liason_connection ORDER BY date DESC LIMIT 1");
	
?>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

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
	
</head>
    <body>

	<div id = "fixed-header-background">

	</div>

	<div id = "site-wrapper">
		<div id = "site-border-wrapper">
			<!-- Header -->
			<?php require_once('../functions/includes/header.php');	?>

			<!-- SECTION: All Connections -->
			<section id = "connection-list">	

				<?php 
				//Create an array of post objects from the Post Class (liaison connection) 
					$previousPostDate = "";
					while($row = mysqli_fetch_array($result)) {	 
						$post_id = ($row['post_id']);
						$individual_post = "post_" . ($row['post_id']);						
						$individual_post = new Posts($post_id);
						$individual_post->getUserPost($post_id);				
				?>  
				
				<!-- Header based on Month and Year -->
				<h3 class = "connection-list-date"> 	
					<?php 
						//Check the post date and generate a post header for each new month if it does not equal the last month 
						$currentPostDate = ($individual_post->liason_date_month). " " . ($individual_post->liason_date_year);
						if (strcasecmp($currentPostDate, $previousPostDate) == 0) {
						} else {
							echo $currentPostDate;
						}		
						$previousPostDate = ($individual_post->liason_date_month). " " . ($individual_post->liason_date_year);
					?> 
					
				</h3>

				<!-- Connection Posts-->
				<div class = "connection"> 
					<div class = "connection-style connection-font-position">
						<p class = "college-fill" > <a href="#" id= "connection-link-id" class = "<?php echo $post_id; ?>"><?php echo ($individual_post->contact_college); ?> </a></p>
					</div>	
					<img border="0" src="user_images/<?php echo ($individual_post->staff_image); ?>" class = "staff-connection-image" alt="Staff Image" height="34" >
					<p class = "staff-connection"><?php echo ($individual_post->staff_first_name) ." "  . ($individual_post->staff_last_name); ?></p>
				</div>	
				<?php } ?>	

			</section>
			
			<!-- SECTION: Individual Connection All Details -->
			<section id = "individual-connection">
			
				<?php 
				//This is wrong it should be the post information on the user 
					$result_user_profile = mysqli_query($conn,"SELECT image_name, first_name, last_name FROM user_profile WHERE user_name = '$logged_in_user' ");

					while($row_user_profile = mysqli_fetch_array($result_user_profile)) {	 ?>
					<!--<img border="0" id = "connection-user-image" src="../images/" alt="OSU" width="80">-->
					<div class = "connection-staff-image">
						<div id = "connection-staff-image"></div>
					</div>	
					<h3 class = "individual-connection-title" id = "contact-college"></h3>	
				
				<?php }?>
				
			<div class = "connection-position">	
				<p class = "staff-connection-name" id = "staff-name"><strong> </strong> </p>
				<p class = "individual-connection-subtitle"><strong> Contact </strong> </p>
				<p class = "individual-connection-text" id = "contact-name"> </p>
				
				<p class = "individual-connection-subtitle"><strong> Title </strong> </p>
				<p class = "individual-connection-text" id = "contact-title"> Internship Coordinator </p>
				
				<p class = "individual-connection-subtitle"><strong> Date </strong> </p>
				<p class = "individual-connection-text"  id = "date" > </p>
				
				<p class = "individual-connection-subtitle"><strong> Purpose </strong> </p>
				<p class = "individual-connection-text" id = "purpose"> </p>									
			</div>
		
			</section>
		
		</div>
	</div>
<?php require_once('../functions/includes/logout.inc.php'); ?>
		<!-- Footer -->

    </body>
</html>
