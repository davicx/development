<?php
//include '/includes/connect.php';

$conn = mysqli_connect("localhost","root","","dashboard");

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

if(isset($_POST['contact'], $_POST['date'], $_POST['purpose'])) {
		$contact 	= $_POST['contact'];
		$title 		= $_POST['title'];
		$date 		= $_POST['date']; 
		$purpose 	= $_POST['purpose'];
		$user_id 	= $_POST['post-id'];	
		
		//echo $purpose . " " . $user_id . " "  . $contact . " " . $date . " " . $title;

		$sql = "UPDATE liason_connection SET contact_name = ?, contact_title = ?, date = ?, purpose = ? WHERE post_id = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('ssssi', $contact, $title, $date, $purpose, $user_id);
		$stmt->execute();
		
		//Output to callback function 
		if ($stmt->errno) {
		  echo "Could not update post" . $stmt->error;
		}
		$stmt->close();

		} else {
			echo "not set";
		}
?>			