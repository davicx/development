<?php 
include '../User.php';
include '../includes/connect.php';
	$userName = "Vasquezd";
	$Vasquezd = new User($userName);
	//$Vasquezd->getUserInfo($userName);

//Function 1: Update User Information on form submission
if(!empty($_POST)){

echo "Success";
	//On submit of Edit User Profile this will update the current class instantiation. The post can be placed inside the updateUserInfo() method. 
	$newFirstName 	= $_POST["firstName"];
	$newLastName 	= $_POST["lastName"];
	$newEmail 		= $_POST["email"];
	$newBiography 	= $_POST["biography"]; 
	$primary_id = 7;
	
	$Vasquezd->updateUserInfo($newFirstName, $newLastName, $newEmail, $newBiography, $primary_id);
}	


?>	