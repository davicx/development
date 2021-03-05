<?php 
//This is working but I need to create a new post for each post class and place inside an array
//Then this array will be sorted numerically on the post_id field to display posts. 
include 'Posts.php';
include 'includes/connect.php';
$logged_in_user = "Vasquezd";
$user_being_visited = "Vasquezd";
	//If you visit someone elses page the WHERE post_to will become there id
	
	//Query database to get all posts to user 
	$result = mysqli_query($conn,"SELECT * FROM posts WHERE post_to = '$logged_in_user'");

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
						//The individual post ID is just the number each additional post adds a prefix to differentiate 
						$individual_post_id = ($row['post_id']);
						$individual_text_id = "text_" . ($row['post_id']);
						$editable_text_id = "edit_text_" . ($row['post_id']);
						$save_button_id = "save_" . ($row['post_id']);
						$cancel_button_id = "cancel_" . ($row['post_id']);
						
						$individual_post = new Posts($post_id);
						$individual_post->getUserPost($post_id);			
				?>  
					<div class = "individual-post">
						<p><b>Post ID: 		</b><?php echo ($individual_post->post_id);			?></p>	
						<p><b>Post From: 	</b><?php echo ($individual_post->post_from);		?></p>	
						<p><b>Post To: 		</b><?php echo ($individual_post->post_to);			?></p>	
						<p id = "<?php echo ($individual_text_id) ?>" class = "post-text"><b></b><?php echo ($individual_post->post_text);?></p>
						<textarea rows="4" cols="50" id = "<?php echo $editable_text_id ?>" class = "post-text" style="display:none"><?php echo ($individual_post->post_text);?></textarea>
						<p><b>Created	 	</b><?php echo ($individual_post->created);			?></p>		
						<!-- All editing buttons -->
						<button type="button" id="<?php echo $individual_post_id; ?>" class="edit-button">Edit</button>	
						<button type="button" id="<?php echo $save_button_id; ?>" class="save-button" style="display:none" >Save</button>	
						<button type="button" id="<?php echo $cancel_button_id; ?>" class="cancel-button" style="display:none" >Cancel</button>		
					</div><br />				
				<?php } ?>	

		</section>		
				
	</div>	
</body>
</html> 

