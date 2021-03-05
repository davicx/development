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
	
	public function renameFile($newFileName, $fileID) {
		global $conn;
		
		mysqli_query($conn,"UPDATE files SET file_name='$newFileName' WHERE file_id='$fileID'");	
		echo $newFileName;
	}

	public function moveFile($newFileName, $fileID) {

	}
		
	
	public function deleteFile() {
		//move status to 0
		echo "delete file from database, move to deleted folder for that user";
	}
	
	public function copyFile() {
		echo "copy and put a new file on server and in new location";
	}
//Active = 1
//Deleted = 0
	
	
}
	