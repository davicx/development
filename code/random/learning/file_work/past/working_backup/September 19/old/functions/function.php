<?php
	include 'includes/connect.php';
	

if (isset($_POST["current_test_id"])) { 
	$file_id = $_POST["current_test_id"];
	
	$result = mysqli_query($conn,"SELECT * FROM files WHERE file_id = '$file_id'");
	
	while($row = mysqli_fetch_array($result)) {
		$local_file = $row['file_location'];
		$download_file = $row['file_name']; 
	}
	
	
	/*
	$download_rate = 20.5;
	if(file_exists($local_file) && is_file($local_file)) {
		header('Cache-control: private');
		header('Content-Type: application/octet-stream');
		header('Content-Length: '.filesize($local_file));
		//header('Content-Disposition: filename='.$download_file);
		header('Content-Disposition: attachment; filename="' . str_replace('"', '\\"', ($mask ? $mask : basename($download_file))) . '"');
		flush();
		$file = fopen($local_file, "r");
		while(!feof($file)) {
			// send the current file part to the browser
			print fread($file, round($download_rate * 1024));
			// flush the content to the browser
			flush();
			// sleep one second
			sleep(.1);
		
		}
		echo "success";
		fclose($file);}
	else {
		die('Error: The file '.$local_file.' does not exist!');
		echo "error";
	}
	*/
	//echo $local_file;

}




?>
