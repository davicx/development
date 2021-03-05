<?php
	require_once('../includes/connection.inc.php');
	$conn = dbConnect('read');
	$me = "vasquezd";
	$my_id = 70;
	$user_id = $_POST['name'];
	//$post_id will be generated from what post is clicked on
	//If(get all rows and if none equal 70 run this query)
	if(isset($_POST['name'])) {
		
		//INSERT
		//mysqli_query($conn,"INSERT INTO post_likes (post_id, liked, time_stamp) VALUES ('5', '$user_id', now())");
	
		//DELETE	
		//mysqli_query($conn,"DELETE FROM post_likes WHERE post_id = 6 AND liked = ('$user_id')");
		
		//FRIENDS
		//if(you are already friends display)
		//else 
		mysqli_query($conn,"INSERT INTO friends (user_name, user_id, friend_id) VALUES ('$me', '$my_id','$user_id' )");
		
	}
	//Else (delete row)

?>