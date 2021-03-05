<?php
$conn = mysqli_connect("localhost","root","","dashboard");
// Check connection
if (mysqli_connect_errno()) {
  //echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

if (isset($_POST["reportYear"]) && (!empty($_POST["reportYear"]))) {	
	$reportYear = $_POST['reportYear']; 
	//$reportYear = 2014; 
	
	$sql = "SELECT * FROM liason_connection WHERE year='$reportYear'";
	$result = $conn->query($sql) or die(mysqli_error());
	
	//Initialize count to 0 and then add all liasion connections to array. 

	$count = 0;
	while($row=$result->fetch_array()) {	
		$college_totals[$count]= $row['college_code'];
		$count = $count + 1;	
	}

	//print_r(array_count_values($college_totals));
	echo json_encode(array_count_values($college_totals));
}
?>