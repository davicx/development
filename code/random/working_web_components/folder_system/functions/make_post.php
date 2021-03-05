<?php
include 'connection.inc.php';

if (isset($_POST["rename_square"]) && (!empty($_POST["user_name"]))) {	
	$square_id = $_POST["rename_square"];
	$user_name = $_POST["user_name"];
	$square_name = $_POST["new_square_name"];
	
	mysqli_query($conn,"UPDATE squares SET square_name='$square_name' WHERE square_id=$square_id");	
	echo $square_name;
}


?>