<?php
include_once('connection.inc.php');
	$conn = dbConnect('write');
	if(isset($_POST['insert'])) {
				mysqli_query($conn,"UPDATE posts SET likes = likes + 1 WHERE post_id = '6'");
			}
?>