<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
include '../functions/function.php';
require_once('../functions/includes/session_timeout.inc.php');
	
	$logged_in_user = $_SESSION['varname'];
	//Get all user information, connection information 
	$result = mysqli_query($conn,"SELECT * FROM liason_connection WHERE staff_name = '$logged_in_user' ORDER BY date DESC ");	
	
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

	
	<!-- JS -->
	<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
    <script src="../js/main.js"></script>

   
	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="/resources/demos/style.css">
		
    <body>

	<div id = "fixed-header-background"></div>

	<div id = "site-wrapper">
		<?php require_once('../functions/includes/header.php');	?>
	
		<!-- SECTION: User Profile -->
		<section id = "user-profile">

			<?php 
			$result_user_profile = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_name = '$logged_in_user' ");
			while($row_user_profile = mysqli_fetch_array($result_user_profile)) {	 ?>
			
			<div class = "connection-position">	
				<!-- Upload New User Image -->
				<div class = "image-upload-position">
					<form action="" method="post" enctype="multipart/form-data" id="uploadImage" class = "individual-connection-edit-text">
						<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
						<input type="file" name="image" id="image">
						<p><input type="submit" name="upload" id="upload" value="Change Image"></p>
					</form>
				</div>
				
				<!-- Display User Data and also Hidden Data on Update Profile Click -->				
				<img border="0" id = "connection-user-image" src="user_images/<?php echo $row_user_profile['image_name']; ?>" alt="OSU" width="100">
				
				<p class = "individual-connection-subtitle"><strong> Name </strong> </p>
				
				<p class = "individual-connection-text" id = "profile-updated-first" ><?php echo $row_user_profile['first_name']; ?> </p>
				<p class = "individual-connection-edit-text"> First Name: </p>
				<input type="text" name="edit-first-name" value = "<?php echo $row_user_profile['first_name']; ?>" id = "first-name-value" class = "individual-connection-edit-text">
				
				<p class = "individual-connection-text" ><?php echo $row_user_profile['last_name']; ?> </p>
				<p class = "individual-connection-edit-text"> Last Name: </p>
				<input type="text" name="edit-last-name" value = "<?php echo $row_user_profile['last_name']; ?>" id = "last-name-value" class = "individual-connection-edit-text">
				
				<p class = "individual-connection-subtitle"><strong> Title </strong> </p>
				<p class = "individual-connection-text"><?php echo $row_user_profile['title']; ?></p>
				<input type="text" name="edit-title" value = "<?php echo $row_user_profile['title']; ?>" id = "title-value" class = "individual-connection-edit-text">
				
				<p class = "individual-connection-subtitle"><strong> Biography </strong> </p>
				<p class = "individual-connection-text"><?php echo $row_user_profile['biography']; ?> </p>
				<textarea rows="4" cols="40" class = "individual-connection-edit-text" id = "biography-value"  ><?php echo $row_user_profile['biography']; ?> </textarea> 				
				
				<button id = "edit-profile" class="">Edit Profile</button>
				<button id = "save-edit-profile" class="">Save</button>
				<button id = "cancel-edit-profile" class="">Cancel</button>
			</div>
			<?php } ?>
		</section> 

		<section id = "user-connection-list">	
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
			<div class = "profile-connection-short"> 
				<div class = "profile-liaison-short">
			
						<div class = "connection-style profile-connection-font-position">
							<p> <a href="#" id= "connection-link-id" class = "<?php echo $post_id; ?>"><?php echo ($individual_post->contact_college); ?> </a></p>
						</div>	
						<img border="0" src="user_images/<?php echo ($individual_post->staff_image); ?>" class = "profile-connection-post-image" alt="Staff Image" height="34" >
						<p class = "profile-connection-staff-name"><?php echo ($individual_post->staff_first_name) ." "  . ($individual_post->staff_last_name); ?></p>

						<button id = "<?php echo "edit_" . $individual_post->post_id; ?>" class="edit-button">Edit</button>
						<button id = "<?php echo "delete_" . $individual_post->post_id; ?>"  class="delete-button">Delete</button>
				</div>
				
				<div id = "<?php echo "update_form_" . $individual_post->post_id; ?>"class = "connection-edit-form-area">				
					<form method="post" action="../functions/profile.php" class = "ajax"> 
						<p>Contact Name</p>
						<input type="text" name="contact" value = "<?php echo $individual_post->contact_name; ?>"><br>
		
						<p>Title </p>
						<input type="text" name="title" value = "<?php echo $individual_post->contact_title; ?>"><br>
						
						<p>Date</p>
						<input type="text" name="date" value = "<?php echo $individual_post->liason_date; ?>"><br>
						
						<p>Purpose</p>
						<textarea rows="4" cols="50" name = "purpose"><?php echo $individual_post->purpose; ?></textarea> 
						<input type="hidden" name = "post-id" value="<?php echo $individual_post->post_id; ?>"><br />
						
						<input type="submit" id = "<?php echo "save_" . $individual_post->post_id; ?>" class = "save"  value="Save"/>			
						<input type="submit" id = "<?php echo "cancel_" . $individual_post->post_id; ?>" class = "cancel" value="Cancel"/>
				
					</form>	
						
				</div>
			
				<p class="form-output"></p>
			
			</div>	
			<?php } ?>	
		</section>

	</div>
	
		<!-- Footer -->
		<footer>
		</footer> 
    </body>
</html>
