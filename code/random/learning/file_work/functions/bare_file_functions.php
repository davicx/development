<?php
include '../functions/includes/connect.php';
$square_id = 1;
//require_once('connect.php');	





//Move
if (isset($_POST["move-file"])) {	
	$file_id = 41;
	//$currentPath = "square_1/vasquezd/music";
	$newPath = "square_1/vasquezd/music/pearl_jam";
	$fileRoot = getFileRoot($newPath);

		$sql = "UPDATE files SET folder_path = ?, file_root = ? WHERE file_id='$file_id'";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('ss', $newPath, $fileRoot);
			if ($stmt->execute()) {
			echo $newPath;

		}
		
	function getFileRoot($newPath) {
		$fileArray = explode("/",$newPath);
		$fileRoot = end($fileArray);
		return $fileRoot;
	}
}

//Copy		
if (isset($_POST["copy-file"])) {	
	$file_id = 41;
	$currentPath = "square_1/vasquezd/music";
	$newPath = "square_1/vasquezd/music/pearl_jam";
	$fileRoot = getFileRoot($newPath);

		$result = mysqli_query($conn,"SELECT * FROM files WHERE file_id = '$file_id'");

		while($row = mysqli_fetch_array($result)) {
			$square_id 		= 	$row['square_id'];
			$user_id 		=   $row['user_id'];
			$file_name 	 	= 	$row['file_name'];
			$server_name 	= 	$row['server_name'];
			$image_name 	= 	$row['image_name'];
			$file_location 	= 	$row['file_location'];
			//$row['file_root'] . " " . $row['folder_path'];
			$status 		= 	$row['status'];
		}

		$insert = $conn->prepare("INSERT INTO files (square_id, user_id, file_name, server_name, image_name, file_location, file_root, folder_path, status) VALUES (?,?,?,?,?,?,?,?,?) ");
		$insert->bind_param('iissssssi', $square_id, $user_id, $file_name, $server_name, $image_name, $file_location, $fileRoot, $newPath, $status);
		if ($insert->execute()) {
			echo "worked";
		} else {
			echo "Can not be processed";
		}
		
	function getFileRoot($newPath) {
		$fileArray = explode("/",$newPath);
		$fileRoot = end($fileArray);
		return $fileRoot;
	}
}




//Share to New Square



//Rename Working
if (isset($_POST["rename-file"])) {	
	$newFileName = "This is my new, new name.docx";
	
	$sql = "UPDATE files SET file_name = ? WHERE file_id='$file_id'";
	$stmt = $conn->prepare($sql);
	$stmt->bind_param('s', $newFileName);
		if ($stmt->execute()) {
		echo $newFileName;
	}
} else {
	//echo "Can not be renamed";
}
	
//Delete Working 
if (isset($_POST["delete-file"])) {	
	mysqli_query($conn,"UPDATE files SET status=0, status_change = (current_timestamp) WHERE file_id = $file_id");
	echo "file deleted";
} else {
	//echo "Can not be deleted";
}


	
  
		
?>
