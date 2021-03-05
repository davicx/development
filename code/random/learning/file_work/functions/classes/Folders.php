<?php
//include '../functions/includes/connect.php';
require_once('connect.php');	

class File {
	public $fileId = "";
	public $squareId = "";
	public $userId = "";
	public $folderNameLong = "";
	public $folderNameSystem = "";
	public $imageName = "";	
	public $folderRoot = "";
	public $folderPath = "";
	public $folderCreated = "";
	public $folderLastModified = "";
	public $folderName = "";
	
	public function __construct($fileId ) {
		$this->fileId = $fileId;
	}
	
	public function getFileInfo($fileId) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM files WHERE file_id = '$fileId' ");

		while($row = mysqli_fetch_array($result)) {		
			$this->squareId 			= $row['square_id']; 
			$this->userId 				= $row['user_id'];
			$this->folderNameLong		= $row['folder_name_long']; 
			$this->folderNameSystem		= $row['folder_name_system']; 
			$this->imageName 			= $row['image_name']; 
			$this->folderRoot 			= $row['folder_root']; 
			$this->folderPath	 		= $row['folder_path']; 
			$this->folderCreated		= $row['folder_created']; 
			$this->folderLastModified	= $row['folder_last_modified']; 
			$this->folderName			= $row['folder_name']; 
		  }	
	}
	
	public function renameFolder($fileID, $newFileName) {
		/*
		global $conn;
		
		mysqli_query($conn,"UPDATE files SET file_name='$newFileName' WHERE file_id='$fileID'");	
		echo $newFileName;
		*/
	}

	public function moveFolder($fileID, $newPath) {
		/*
		global $conn;	
		$fileID = $fileID;
		$newPath = $newPath;
		$fileArray = explode("/",$newPath);
		$fileRoot = end($fileArray);	

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
		*/
	}
		
	
	public function deleteFolder($file_id) {
	/*
		global $conn;
		$file_id = $file_id;
		mysqli_query($conn,"UPDATE files SET status=0, status_change = (current_timestamp) WHERE file_id = $file_id");
	*/
	}
	
	public function copyFolder($file_id, $newPath) {
		/*
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
		*/
	}

	
//Active = 1
//Deleted = 0
	
	
}
	