<?php
require_once('../includes/session_timeout.inc.php');
require_once('../includes/connection.inc.php');	
	$conn = dbConnect('read');

	//Create local variable with user name 
	$user_name = $_SESSION['varname'];
	
	//Get user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $user_name);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $user_id = $result_user_id;
      $stmt_user_id -> close();
    }
	
	//Get user information from database
	$sql = 'SELECT * FROM user_profile WHERE user_name = "'.$user_name.'"';
	$result = $conn->query($sql) or die(mysqli_error());
	
	//Posts- Get posts, comments and friends
	$sql = 'SELECT * FROM posts WHERE post_to = "'.$user_name.'" ORDER BY created DESC';
	$result_post = $conn->query($sql) or die(mysqli_error());
	
	//Friends- Get all Friends
	$sql = "SELECT friends.friends_id, user_profile.user_name, user_profile.first_name, user_profile.user_id 
	FROM friends INNER JOIN user_profile ON (user_profile.user_id = friends.friend_id) WHERE (friends.user_id = '$user_id')";
	$result_friends = $conn->query($sql) or die(mysqli_error());
	//Friends Table
	// 1) friend_id 
	//User Profile 
	//1) user_name, first_name, user_id, 
	
	$from = "vasquezd ";
	$to = "james";
	
	//Logout
	//run this script only if the logout button has been clicked
	if (isset($_POST['logout'])) {
	//Empty the $_SESSION array
	$_SESSION = array();
	//Invalidate the session cookie
	if (isset($_COOKIE[session_name()])) {
	setcookie(session_name(), '', time()-86400, '/');
	}
	//End session and redirect
	session_destroy();

	header('Location: http://localhost/ShareShare/index.php');
	exit;
	}	
?>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>ShareShare</title>
	<meta name="description" content=".">
	<meta name="author" content="">
	
	<!-- CSS -->
	<link href="../../style/style.css" rel="stylesheet" type="text/css" media="screen" />	
	<link href="../../style/user_profile.css" rel="stylesheet" type="text/css" media="screen" />	
    
</head>
	<body>
		<div class="site-wrapper">
			
			<!-- NAVIGATION BAR --> 
			<nav id = "navigation">
					<a href="#home">ShareShare</a>
			</nav>
					<!-- EDIT PROFILE -->
			<aside id = "edit-profile"
				<!--Logout-->
				<form id="" method="post" action="">
					<div id = "login">	
						<input name="logout" type="submit" id="logout" value="Log Out">
					</div>
				</form>
				<a href="display_friends.php">Display Friends</a> 
				<a href="browse_users.php">Browse Users</a> 	
				<a href="update_profile.php">Edit Profile</a> 	
			</aside>
				
			<!-- PERSONAL PROFILE -->	
			<section id="profile">
				<?php while($row = $result->fetch_assoc()) { ?>  
				
				<div id = "profile-left">
					<img class = "img" border="0" src="../../images/profile_image/<?php echo $row['image_name'] ?>" alt="<?php echo $row['image_name'] ?>" width="180">
					<h3><b>Profile </b></h3>
					<p><b>First Name: </b><?php echo $row['first_name']; ?></p>
					<p><b>Last Name: </b><?php echo $row['last_name']; ?></p>
					<p><b>University: </b><?php echo $row['university']; ?></p>
				</div>
				
				<div id = "profile-right">	
						<p><b>Services: </b><?php echo $row['services']; ?></p>
						<p><b>User ID: </b><?php echo $row['user_id']; ?></p>
						<p><b>User Name: </b><?php echo $row['user_name']; ?></p>
						<h3>Biography</h3>			
							<p><b>Bio:</b> <?php echo $row['bio']; ?></p>
				<?php } ?>	
				</div>
				<!--Friends-->		
				<article id = "friend-display">
					<h3 class = "normal"> Friends </h3>
						<?php  while($row_friends = $result_friends->fetch_assoc()) { ?>
						<p>Your Friends ID: <?php   echo $row_friends['first_name'] . " " . $row_friends['user_name'] . " " . $row_friends['user_id'] . "<br />"; ?></p>
						<?php  } ?>
	
				</article>		
				
			</section>
			
			<!--NEWS FEED -->	
			<section id = "feed">
			
				<!--New Post -->
				<div id ="new_posts">	
					<textarea class = "new-post-textarea" name = "message" rows="3" cols="50" id = "new-post-text"> </textarea>
					<button type = "button" id="new-post" class="new-post-button" >Submit</button>	
			
					<div id="wall-post-output"> </div>				
				</div>	
			
				<!-- Current Posts -->
				<?php while($row_post = $result_post->fetch_assoc()) { ?>
				<div id = "<?php $post_id_this = "post-body" . $row_post['post_id']; echo ($post_id_this); ?>" class = "posts">					
					
					<!--Post Head: From and Updated -->
					<div class = "post-head">
						<!-- Posters Image-->
						<img class = "post-user-image" border="0" src="../../images/profile_image/13968393222693506635_f9ca0ecd3d.jpg" alt="hi" height="76">
						<p class = "post-user-info"><?php echo ($from); ?></p>	
						<p class = "post-updated"><?php echo $row_post['updated'];  ?></p>
					</div>
					
					
					<!--Post Body: Images, Video and text -->
					
					<div class = "post-body">
						<!--Image in Post-->
						<img border="0" class = "post-main-image" src="../../images/<?php echo $row_post['image'];  ?>" alt="<?php echo $row_post['image'];  ?>" width="498">
						<!-- Post Caption-->
						<p id="<?php $post_id_this = "caption-text" . $row_post['post_id']; echo ($post_id_this); ?>" class = "post-caption view-post"><?php echo $row_post['caption']; ?><br /><br /></p>
						<!--Edit Box Caption -->	
						<button type="button" id="<?php echo $row_post['post_id']; ?>" class="edit view" ><img border="0" src="edit_button.png" alt="Edit Post" width="15"></button>	
					</div>
		
					<!-- Post Edit-->
					<!-- Text Area, Save and Cancel Button -->
						<button type="button" id="<?php $post_id_this = "save" . $row_post['post_id']; echo ($post_id_this); ?>" class="save hide" >Save</button>
						<button type = "button" id = "<?php $post_id_this = "cancel" . $row_post['post_id']; echo ($post_id_this); ?>" class = "cancel hide"> Cancel </button>
						<textarea name = "message" id = "<?php $post_id_this = "text" . $row_post['post_id']; echo ($post_id_this); ?>" class="updated-post hide" rows="3" cols="50"> <?php echo $row_post['caption']; ?> </textarea> 

					<!--Post Body: Like Bar Actions -->
					<div id="<?php $post_id_this = "like_bar" . $row_post['post_id']; echo ($post_id_this); ?>" class = "post-like-actions">
			
					<!-- Like button-->	
					<p class = "current-post-likes">
					david and 
					<?php 
					//Post Likes- Get all post like data for this user from the database
					$post_id = $row_post['post_id'];
						//echo "POST ID IS " . ($post_id) . "<br />";						
						$sql = "SELECT * FROM post_likes WHERE post_id = '".$post_id."'";
						$result_likes = $conn->query($sql) or die(mysqli_error());
						
						//This displays all the likes for the current post
						$like_array = array();
						while($row_likes = mysqli_fetch_array($result_likes)) {
							$like_array[] = $row_likes['liked'];
							echo $row_likes['liked'];

						}
					?> like this post
					</p>
						
					<?php					
					//If post has been liked already unlike otherwise like the post
					if (in_array($user_id, $like_array))   { ?>
						<p id =  "<?php $post_id_this = "like" . $row_post['post_id']; echo ($post_id_this); ?>" class = "like"><strong> Unlike </strong></p>
							
						<?php
							//echo " You have Liked this post";
						} else { ?>
							<p id =  "<?php $post_id_this = "like" . $row_post['post_id']; echo ($post_id_this); ?>" class = "like"><strong> Like </strong></p>
							<?php
						}	
						?>
					</div>
					
					<!-- Comments -->
					<div class = "comments">
						<p> Comments </p>
					</div>
			
				</div>
			
			<?php } ?>
			</section>
			
		
			</div>		  

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="jscript/main.js"></script>
	</body>
</html>