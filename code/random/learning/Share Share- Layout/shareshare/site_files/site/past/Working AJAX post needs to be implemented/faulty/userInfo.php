<?php
  require_once('../../includes/connection.inc.php');
	  $conn = dbConnect('write');
  		$name = $_POST['name'];
		$age = $_POST['age'];
 
		mysqli_query($conn,"INSERT INTO comments (title, comment) VALUES ('Peter', 'Griffin')");
?>
