<?php
//include '../functions/includes/connect.php';
require_once('connect.php');	

class File {
	public $fileId = "";
	public $squareId = "";
	public $userId = "";
	public $fileName = "";
	public $serverName = "";
	public $imageName = "";	
	public $fileLocation = "";
	public $fileRoot = "";
	public $folderPath = "";
	public $currentFileSize = "";
	public $fileUploaded = "";
	public $fileLastModified = "";
	
	
	public function __construct($fileId ) {
		$this->fileId = $fileId;
	}
	
	public function getFileInfo($fileId) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM files WHERE file_id = '$fileId' ");

		while($row = mysqli_fetch_array($result)) {		
			$this->squareId 		= $row['square_id']; 
			$this->userId 			= $row['user_id'];
			$this->fileName 		= $row['file_name']; 
			$this->serverName 		= $row['server_name']; 
			$this->imageName 		= $row['image_name']; 
			$this->fileLocation 	= $row['file_location']; 
			$this->fileRoot 		= $row['file_root']; 
			$this->folderPath	 	= $row['folder_path']; 
			$this->currentFileSize 	= $row['file_size']; 
			$this->fileUploaded		= $row['file_uploaded']; 
			$this->fileLastModified	= $row['file_last_modified']; 	
		  }	
	}
	
	public function renameFile($fileID, $newFileName) {
		global $conn;
		
		mysqli_query($conn,"UPDATE files SET file_name='$newFileName' WHERE file_id='$fileID'");	
		echo $newFileName;
	}

	public function moveFile($fileID, $newPath) {
		global $conn;	
		$fileID = $fileID;
		$newPath = $newPath;
		$fileArray = explode("/",$newPath);
		$fileRoot = end($fileArray);	

		$sql = "UPDATE files SET folder_path = ?, file_root = ? WHERE file_id='$fileID'";
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
		
	
	public function deleteFile($file_id) {
		global $conn;
		$file_id = $file_id;
		mysqli_query($conn,"UPDATE files SET status=0, status_change = (current_timestamp) WHERE file_id = $file_id");
	}
	
	public function copyFile($file_id, $newPath) {
		global $conn;
		$file_id = $file_id;
		$newPath = $newPath;
		$fileArray = explode("/",$newPath);
		$fileRoot = end($fileArray);	
		
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
		
	}

	
//Active = 1
//Deleted = 0
	
	
}
	