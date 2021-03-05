<?php
$conn = mysqli_connect("localhost","root","","dashboard");

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

 
	$id = $_POST['post_id']; 
	

	
	$sql = "SELECT * FROM liason_connection WHERE post_id='$id'";
	$result = $conn->query($sql) or die(mysqli_error());
	

	while($row=$result->fetch_array()) {
		$liason_connection['staff_name']= $row['staff_name'];
		$liason_connection['contact_name']= $row['contact_name'];
		$liason_connection['contact_title']= $row['contact_title'];	
		$liason_connection['contact_college']= $row['contact_college'];	
		$liason_connection['date']= $row['date'];	
		$liason_connection['purpose']= $row['purpose'];	
		$liason_connection['created']= $row['created'];	
	}
	//echo ($id);
  
	//echo "Purpose " . $liason_connection['purpose'] . " ";	
	echo json_encode( $liason_connection );

	

?>