<?php
//include '../functions/includes/connect.php';
require_once('../functions/includes/connect.php');	

class File {
	public $fileId = "";
	public $squareId = "";
	public $userId = "";
	public $fileName = "";
	public $serverName = "";
	public $fileLocation = "";
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
			$this->fileLocation 	= $row['file_location']; 
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
	
	
	public function deleteFile() {
		echo "delete file from database, move to deleted folder for that user";
	}
	
	public function copyFile() {
		echo "copy and put a new file on server and in new location";
	}
	
	
	
}
	