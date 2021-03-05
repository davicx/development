<?php 
session_start(); 
include 'includes/connect.php';

?>
<!DOCTYPE html>
<html>
<body>

<h3>My First Heading</h3>


<?php
	//retrieve session data
	echo "Pageviews = ". $_SESSION['name'];

?>

<br />
<a href="index.php">Next Page</a> 


</body>
</html> 