<?php 
session_start(); 
$_SESSION['name']='david';


?>

<?php include 'includes/connect.php';?>

<!DOCTYPE html>
<html>
<body>

<h3>My First Heading</h3>

<?php
	//retrieve session data
	echo "Pageviews = ". $_SESSION['name'];

?>
<br />
<a href="logged_in.php">Index</a> 

</body>
</html> 