<?php 
include 'includes/connect.php';
require_once('includes/session_timeout.inc.php');
$logged_in_user = $_SESSION['varname'];

//echo $logged_in_user;

if (isset($_POST["firstName"]) && (!empty($_POST["firstName"]))) {
		$firstName 	=  $_POST['firstName'];
		$lastName 	=  $_POST['lastName'];
		$title		=  $_POST['title'];
		$biography 	=  $_POST['biography'];
		//echo $firstName;
		//$updatedUserInfo = array('firstName' => $firstName, 'lastName' => $lastName, 'title' => $title, 'biography' => $biography);
	//	echo json_encode($updatedUserInfo);	

		//Prepare statement and insert values 
		$sql = "UPDATE user_profile SET first_name = ?, last_name = ?, title = ?, biography = ? WHERE user_name = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('sssss', $firstName, $lastName, $title, $biography, $logged_in_user);
			if ($stmt->execute()) {
			

			header("Location: http://localhost/dashboard/site_files/profile.php");
			die();
		}

} else {
	echo "Can not be processed!";
}
/*	
	function clean_input($data) {
	   $data = trim($data);
	   $data = stripslashes($data);
	   $data = htmlspecialchars($data);
	   return $data;
	}

*/
?>