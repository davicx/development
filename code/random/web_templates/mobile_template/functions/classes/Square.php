<?php
//include '../functions/includes/connect.php';
require_once('connection.inc.php');	

class Square {
	public $squareID 		= "";
	public $squareName 		= "";
	public $userID 			= "";
	public $squareImage 	= "";
	public $squareStatus	= "";
	public $squareUsers 	= array();
		
	public function __construct($squareId ) {
		$this->squareID = $squareId;
	}
	
	
	//Get square users
	public function getSquareUsers($loggedInUser, $squareID) {
		global $conn;
		$square_id = $squareID;
		$user_name = $loggedInUser;
		
		$sql = "SELECT user_name FROM square_users WHERE square_id = '$square_id'";
		$result_square_friend = $conn->query($sql) or die(mysqli_error());	
		
		//Declare array to hold all users in each square
		$all_square_users = array();
		
		while($row_square_friend = mysqli_fetch_array($result_square_friend)) {
			$logged_in_user_friend = $row_square_friend['user_name'];
				if (strcasecmp($user_name, $logged_in_user_friend) == 0) {
					//echo "Logged in " . $row_square_friend['user_name'];
					//echo "<br />";
				} else {	
					array_push($all_square_users, $logged_in_user_friend);
					//echo $row_square_friend['user_name'];
					//echo "<br />";
				}
		}
		
		$current_square_user = $all_square_users[0];			
		$sql = "SELECT image_name, first_name, last_name FROM user_profile WHERE user_name = '$current_square_user' ";
		$result_individual_user = $conn->query($sql) or die(mysqli_error());	

		//Get Square Name
		while($row_individual_user = mysqli_fetch_array($result_individual_user)) { 
			$this->squareImage = $row_individual_user['image_name'];
		} 
	
		$this->squareUsers= $all_square_users;
		
		//Get Square Status	
		$sql = "SELECT user_name, status FROM square_users WHERE square_id = '$square_id'";
		$result_square_friend = $conn->query($sql) or die(mysqli_error());	

		$pending = "";
		
		while($row_square_friend = mysqli_fetch_array($result_square_friend)) {
			$row_cnt = $result_square_friend->num_rows;
	
			if($row_cnt<=2) {
				$status = $row_square_friend['status'];
				if($status == 0) {
					$pending = "pending";
					break; 
				} else {
					$pending = "not_pending";
				} 
			} else {
				//$pending = false;
				$pending = "not_pending";	
			}
		//	echo "not pending";

		}
		$this->squareStatus = $pending;
		//echo $pending;
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


	
}
	