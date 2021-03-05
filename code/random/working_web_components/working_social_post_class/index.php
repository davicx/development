<?php
	require_once('functions/includes/constants.php');
	require_once('functions/includes/connection.inc.php');		
	require_once('functions/classes/Post.php');		
	
	$post_id = 1;
?>
<!DOCTYPE html>
<html>
    <head>
        <title>ShareSpace</title>
		<!-- CSS -->
	    <link rel="stylesheet" href="css/normalize.css" /> 
		<link rel="stylesheet" href="css/style.css" />
	
		<!-- Javascript  -->	
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="js/main.js"></script>
    </head>
    <body> 
		<header>
			<nav>

			</nav>
		</header>
		
		<div id ="site-wrapper">
			<section id = "posts">
				<div class = "post">
						<?php 
							$Current_Post = new Post($post_id);

							//Get friends list
							$Current_Post->getPostInfo($post_id);
							echo $Current_Post->postFrom;
							echo "<br />";
							echo $Current_Post->postTo;
							echo "<br />";
							
							//Get post likes 
							$post_likes = $Current_Post->postLikes;
							
							$arrlength = count($post_likes);

							for($x = 0; $x < $arrlength; $x++) {
								echo $post_likes[$x];
								echo "<br>";
							}
							
							//Get post comment ID 
							$comments = $Current_Post->commentIDs;
							
							$arrlength = count($comments);

							for($x = 0; $x < $arrlength; $x++) {
								echo $comments[$x];
								echo "<br> ";
							}
							
							//Like Post 
							$likedBy = "vasquezk";	
							//echo $Current_Post->unlikePost($post_id, $likedBy);
							
							//Delete Post
							
							
							//unlikePost($postID, $likedBy) {
							
							
							
							//Delete post 
							//$delete_id = 2;
							//$Current_2 = new Post($delete_id);
							//$Current_2->deletePost($delete_id);
							
							
			
						?>
										
				</div>
			
		

			</section>
		</div>

    </body>
</html>