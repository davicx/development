<?php
include '../functions/includes/connect.php';
//require_once('connect.php');	
$file_id = 41;

//Rename Working
/*
	$newFileName = "This is my new, new name.docx";
	
	$sql = "UPDATE files SET file_name = ? WHERE file_id='$file_id'";
	$stmt = $conn->prepare($sql);
	$stmt->bind_param('s', $newFileName);
		if ($stmt->execute()) {
		echo $newFileName;
	}
*/		
	
//Move
//Update root to new folder
//Delete or add this to file path
//Move david.jpg to vasquezd




//Copy		



//Delete
/*
mysqli_query($conn,"UPDATE files SET status=0, status_change = (current_timestamp) WHERE file_id = $file_id");
echo "file deleted";
*/



//Share to New Square

		
		

		
		

		
		
		
	$result = mysqli_query($conn,"SELECT * FROM files WHERE file_id = '34' ");

	while($row = mysqli_fetch_array($result)) {		
		//echo $row['file_name'];  
	

	  }	
	  
		  
		  
		  
		  
		
?>
