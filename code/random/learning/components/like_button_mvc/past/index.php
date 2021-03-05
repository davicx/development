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
	

	while($row = mysqli_fetch_array($result)) {	
		//Create a unique name for each post so that this can be used as the instantiated object's name 
		$post_id = ($row['post_id']);
		$individual_post = "post_" . ($row['post_id']);
		
		//Create new post object 
		$individual_post = new Posts($post_id);
		
		//Get all data associated with that object 
		$individual_post->getUserPost($post_id);
		
		echo ($individual_post->post_from) . "<br />";
		echo ($individual_post->post_to) . "<br />";
		echo ($individual_post->post_text) . "<br />";
		echo ($individual_post->created) . "<br />";
		echo "<br />";

	}
	
	//$Posts_vasquezd = new Posts($post_id);
	//$Posts_vasquezd->getUserPost($post_id);

?>

<!DOCTYPE html>
<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>	
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<div id = "site-wrapper">
		<section id = "user-posts">
			<h3>Posts</h3>
			
				<p><b>Post ID: 		</b><?php echo ($Posts_vasquezd->post_id);		?></p>	
				<p><b>Post From: 	</b><?php echo ($Posts_vasquezd->post_from);	?></p>	
				<p><b>Post To: 		</b><?php echo ($Posts_vasquezd->post_to);		?></p>	
				<p><b>Post Text: 	</b><?php echo ($Posts_vasquezd->post_text);	?></p>	
				<p><b>Image url: 	</b><?php echo ($Posts_vasquezd->image_url);	?></p>	
				<p><b>Article text 	</b><?php echo ($Posts_vasquezd->article_text);	?></p>	
				<p><b>Link URL  	</b><?php echo ($Posts_vasquezd->link_url);		?></p>	
				<p><b>Like id: 		</b><?php echo ($Posts_vasquezd->like_id);		?></p>	
				<p><b>Comment id: 	</b><?php echo ($Posts_vasquezd->comment_id );	?></p>	
				<p><b>Created	 	</b><?php echo ($Posts_vasquezd->created);		?></p>		
				<p><b>Updated		</b><?php echo ($Posts_vasquezd->updated);		?></p>		
		
		</section>		
				
	</div>	
</body>
</html> 