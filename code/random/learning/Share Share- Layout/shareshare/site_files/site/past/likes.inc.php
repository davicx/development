<?php		
	require_once('../includes/connection.inc.php');	
	require_once('../includes/session_timeout.inc.php');
	
	$conn = dbConnect('read');
	mysqli_query($conn,"UPDATE posts SET likes = likes + 1 WHERE post_id = '6'");
?>