<?php
include 'includes/connect.php';
//May not need to use this 
//include 'includes/classes/Posts.php';
require_once('includes/session_timeout.inc.php');
		

	$logged_in_user = $_SESSION['varname'];

	//Function 1: Insert a new Connection into database 
	if (isset($_POST["submit"]) && (!empty($_POST["contact"]))) {
		$contact =  clean_input($_POST['contact']);
		$title =  clean_input($_POST['title']);
		$date =  clean_input($_POST['date']);
		$year =  date('Y', strtotime($date));
		$college =  clean_input($_POST['college']);
		$purpose =  clean_input($_POST['purpose']);
		
		$result = mysqli_query($conn,"SELECT college FROM colleges WHERE college_code = '$college'");
		while($row = mysqli_fetch_array($result)) {
			$collegeName = $row['college'];
		}
		
		//Prepare statement and insert values 
		$insert = $conn->prepare("INSERT INTO liason_connection (staff_name, contact_name, contact_title, contact_college, college_code, date, year, purpose) VALUES (?,?,?,?,?,?,?,?) ");
		$insert->bind_param('ssssssis', $logged_in_user, $contact, $title, $college, $collegeName, $date, $year, $purpose);
		if ($insert->execute()) {
			header("Location: http://localhost/dashboard/site_files/connection_history.php");
			die();
		}
	} else {
		//echo "Can not be processed!";
	}

	//Function 2: Get Header File for Liaison Connection

				
	//Function 3: Clean data (will still use Prepared Statements) 
	function clean_input($data) {
	   $data = trim($data);
	   $data = stripslashes($data);
	   $data = htmlspecialchars($data);
	   return $data;
	}
	
	//Function 4: File Upload 
	$uploadResult = false;

	$max = 10485760;
	if (isset($_POST['upload'])) {
	  $destination = 'C:/wamp/www/dashboard/site_files/user_images/';
	  
	  require_once('../functions/includes/classes/Upload.php');
	  try {
		$upload = new Upload($destination);
		$upload->setMaxSize($max);
		$upload->move();
		$result = $upload->getMessages();
		$uploadResult = $upload->getUploadOutcome();
		$initialImageName = $result[0]; 

			if($uploadResult==true) {
		
			if (!($stmt = $conn->prepare("UPDATE user_profile SET image_name=? WHERE user_name='$logged_in_user'"))) {
				echo "Prepare failed: (" . $conn->errno . ") " . $conn->error;
			}
					
			if (!$stmt->bind_param('s', $initialImageName)) {
				echo "Binding parameters failed: (" . $stmt->errno . ") " . $stmt->error;
			}
			if (!$stmt->execute()) {
				echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
			}
			//echo "Database Command Excecuted";

			header("Location: profile.php"); /* Redirect browser */
			exit();	
		}
			
		header('Location: profile.php');
	  } catch (Exception $e) {
		echo $e->getMessage();
	  }
	}

?>
