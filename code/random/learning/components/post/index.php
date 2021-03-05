<?php 
//This is working but I need to create a new post for each post class and place inside an array
//Then this array will be sorted numerically on the post_id field to display posts. 
include 'Posts.php';
include 'Comments.php';
include 'includes/connect.php';
//include 'includes/functions.php';

$logged_in_user = "Vasquezd";
$logged_in_user_id = 1;
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
	<script src="js/main_comment.js" type="text/javascript"></script>	
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id = "site-wrapper">
		
		<section id = "user-posts">
			<h3>Posts</h3>
			<!-- Individual Posts--> 
			<?php
				while($row = mysqli_fetch_array($result)) {
					$post_id = ($row['post_id']);
					$individual_post = "post_" . ($row['post_id']);
					$individual_post_id = ($row['post_id']);
					$individual_text_id = "text_" . ($row['post_id']);
					$editable_text_id = "edit_text_" . ($row['post_id']);
					$save_button_id = "save_" . ($row['post_id']);
					$cancel_button_id = "cancel_" . ($row['post_id']);	
					$individual_like_id = "like_" . ($row['post_id']);	
					$individual_post = new Posts($post_id, $logged_in_user);
					$individual_post->getUserPost($post_id);			
			?>
			
			<div class = "individual-post">
				<!-- Post User Info -->
				<div class = "post-user-info">
					<div class = "post-makers-image">
						<p><img border="0" src="images/8.jpg" alt="profile" width="40" > </p>
					</div>
					<div class = "individual-post-info">			
						<p class = "display-inline"><b>Post ID: 		</b><?php echo ($individual_post->created);			?></p>	
						<p class = "display-inline"><b>Post From: 		</b><?php echo ($individual_post->post_from);		?></p>	
						<p class = "display-inline"><b>Post To: 		</b><?php echo ($individual_post->post_to);			?></p>	
					</div>
				</div>
				
				<!-- Post Message -->
				<div class = "post-message">
					<p id = "<?php echo ($individual_text_id) ?>" class = "post-text"><b></b><?php echo ($individual_post->post_text);?></p>
					<textarea rows="4" cols="50" id = "<?php echo $editable_text_id ?>" class = "post-text" style="display:none"><?php echo ($individual_post->post_text);?></textarea>
						<!-- All editing buttons -->
						<div class = "editing-buttons">
							<?php if (strcasecmp($individual_post->post_from,$logged_in_user)==0) { ?>
								<button type="button" id="<?php echo $individual_post_id; ?>" class="edit-button">Edit</button>	
								<button type="button" id="<?php echo $save_button_id; ?>" class="save-button" style="display:none" >Save</button>	
								<button type="button" id="<?php echo $cancel_button_id; ?>" class="cancel-button" style="display:none" >Cancel</button>	
							<?php	} else { ?>
								<button type="button" id="" class="">Report</button>	
							<?php	} ?>
						</div>
				</div>
				<!-- Like or Comment (comment moves cursor to comment box) on Post -->
				<div class = "post-like-comment">
					<?php echo "<p class = \"total-post-likes\"><br />" . "Total Likes: " . ($individual_post->total_likes) . "<br /></p>"; 		
						if (in_array($logged_in_user_id, ($individual_post->like_id))) {
							echo "<p id =  " .  $individual_like_id . " class = \"like\"><strong>Unlike</strong></p>";
						} else {
							echo "<p id = " .  $individual_like_id . " class = \"like\"><strong>Like</strong></p>";
						} 
					?>
				</div>
				
				<div class = "post-comments">
					<?php
						$result_comments = mysqli_query($conn,"SELECT * FROM comments WHERE comment_post_id = '$post_id'");
						while($row_comments  = mysqli_fetch_array($result_comments )) {
							$individual_comment 	= "comment_" . $post_id ;
							$individual_comment 	= new Comments($post_id, $logged_in_user);
							$individual_comment->getPostComments($post_id);


							
						?>
						<div class = "individual-post-comment">
							<!--<p class = "float-left"><?php echo $individual_comment->comment_from;?></p>	
							<p class = "float-left"><?php echo $individual_comment->comment_to;	?></p>	-->
							<p><?php echo $individual_comment->comment;		?></p>	
							<p><?php echo $individual_comment->created;		?></p>			
						</div>
						
					<?php } ?>	

				</div>
				
				<!-- Make a Comment Box -->
				<div class = "make-comment">
					<textarea class = "comment-text-area" id = ""  ></textarea>
				
				</div>
				
					
				
				
			</div>
			<?php } ?>
		
		</section>		
				
	</div>	
</body>
</html> 
