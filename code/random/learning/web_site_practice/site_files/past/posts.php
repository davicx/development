<?php 
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
require_once('../functions/includes/session_timeout.inc.php');
	$logged_in_user = $_SESSION['varname'];
	
	//Query database to get all posts to user 
	$result = mysqli_query($conn,"SELECT * FROM liason_connection");

?>

<!DOCTYPE html>
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>	
	<script src="js/main.js" type="text/javascript"></script>	
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id = "site-wrapper">
		<section id = "user-posts">
			<h3>Posts</h3>
				<?php while($row = mysqli_fetch_array($result)) {	 
						$post_id = ($row['post_id']);
						$individual_post = "post_" . ($row['post_id']);						
						$individual_post = new Posts($post_id);
						$individual_post->getUserPost($post_id);			
				?>  
					<div class = "individual-post">
						<p><b>Post ID: 		</b><?php echo ($individual_post->post_id);			?></p>	
						<p><b>Post From: 	</b><?php echo ($individual_post->staff_name);		?></p>	
						<p><b>Post To: 		</b><?php echo ($individual_post->contact_name);	?></p>	
					</div><br />				
				<?php } ?>	

		</section>		
				
	</div>	
</body>
</html> 













