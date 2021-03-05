<?php
$conn = mysqli_connect("localhost","root","","dashboard");
// Check connection
if (mysqli_connect_errno()) {
  //echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
	
//Check to make sure post is set and not empty 
if (isset($_POST["post_id"]) && (!empty($_POST["post_id"]))) {	
	$id = $_POST['post_id']; 

	//Get all liaison connection information and put in array $liasion_connection
	$sql = "SELECT * FROM liason_connection WHERE post_id='$id'";
	$result = $conn->query($sql) or die(mysqli_error());
	
	while($row=$result->fetch_array()) {
		$liason_connection['staff_name']= $row['staff_name'];
		$user_name = $row['staff_name'];
		$liason_connection['contact_name']= $row['contact_name'];
		$liason_connection['contact_title']= $row['contact_title'];	
		$liason_connection['contact_college']= $row['contact_college'];	
		$liason_connection['date']= $row['date'];	
		$liason_connection['purpose']= $row['purpose'];	
		$liason_connection['created']= $row['created'];	
	}
	
	//Get all user liaison information (could be SQL join)
	$sql = "SELECT * FROM user_profile WHERE user_name='$user_name'";
	$result_user_info = $conn->query($sql) or die(mysqli_error());
	
	while($row_user_info=$result_user_info->fetch_array()) {
		$liason_connection['first_name']= $row_user_info['first_name'];
		$liason_connection['last_name']= $row_user_info['last_name'];
		$liason_connection['image_name']= $row_user_info['image_name'];
	}
	
	//return JSON array to be processed by main.js
	echo json_encode( $liason_connection );
}

?>