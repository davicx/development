<?php
echo "test";
/*
include 'includes/connect.php';
	
	if (isset($_POST["submit"]) && (!empty($_POST["contact"]))) {
		$contact =  clean_input($_POST['contact']);
		$title =  clean_input($_POST['title']);
		$date =  clean_input($_POST['date']);
		$college =  clean_input($_POST['college']);
		$purpose =  clean_input($_POST['purpose']);
		
		//Prepare statement and insert values 
		$insert = $conn->prepare("INSERT INTO liason_connection (contact_name, contact_title, contact_college, purpose) VALUES (?,?,?,?) ");
		$insert->bind_param('ssss', $contact, $title, $college, $purpose);
		if ($insert->execute()) {
			echo "worked";
			//echo header();
			header("Location: http://www.yahoo.com");
			die();
		}
	} else {
		echo "Can not be processed";
	}

	
function clean_input($data) {
   $data = trim($data);
   $data = stripslashes($data);
   $data = htmlspecialchars($data);
   return $data;
}
*/

?>
