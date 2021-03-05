<?php
require_once('../includes/connection.inc.php');
// create database connection
$conn = dbConnect('read');
//This is the initial select statement to get all the posts made to vasquezd
//generic posts are considered from and to the same person
$sql = 'SELECT * FROM posts WHERE post_to = "vasquezd" ORDER BY created DESC';
$result = $conn->query($sql) or die(mysqli_error());

$from = "vasquezd ";
$to = "james";

?>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>Manage Blog Entries</title>
		<link href="style/admin.css" rel="stylesheet" type="text/css">
		<link href="../../style/post.css" rel="stylesheet" type="text/css">
	</head>

	<body>
	<h1>Manage Blog Entries</h1>
		<p><a href="post_insert.php">Insert new post</a></p>

	
		<div id ="post">
		<!-- This generates all of the posts-->
		<?php while($row = $result->fetch_assoc()) { ?>
		    <div id = "post-border">
				<p><?php echo $row['url']; ?></p>
				<p><?php echo $row['video_url']; ?></p>
				<p><?php echo $row['caption']; ?></p>
				<p><?php echo $row['created']; ?></p>
				<p><?php echo ($from); ?><?php echo ($to); ?></p>
				<p><a href="post_update.php?post_id=<?php echo $row['post_id']; ?>">EDIT</a></p>
				<p><a href="post_delete.php?post_id=<?php echo $row['post_id']; ?>">DELETE</a></p>

	  
			<!--Comments-->
			<!--This generates all of the comments made on each individual post. The SQL query must be in here to refresh for each post -->
			<?php $sql = 'SELECT * FROM comments WHERE post_id = "6" ORDER BY created DESC';
				  $result_comment = $conn->query($sql) or die(mysqli_error());
			?>	  
			<?php while($row = $result_comment->fetch_assoc()) { ?>
				<div id = "comment">
					<p><?php echo $row['comment']; ?></p>
					<p><?php echo $row['comment_from']; ?></p>
				</div>	
			
			<?php } ?>					
		
			<!--Likes-->
				<form id = "like" action="" method="post">
					<input type = "submit" value = "like" name='like'/>
				</form>
				<?php
					//The like will either update the post id or comment id
					if(isset($_POST['like'])) {
						mysqli_query($conn,"UPDATE posts SET likes = likes + 1 WHERE post_id = '2'");
					}
				?>	
	
				
	    <?php } ?>
			</div>
		
		</div>	  
	  		
	</body>
</html>