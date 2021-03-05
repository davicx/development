<?php
require_once('connection.inc.php');	

class User{
	public $id = "";
	public $userName = "";
	public $firstName = "";
	public $lastName = "";
	public $email = "";
	public $biography = "";
	public $userImage = "";
	
	public function __construct($userName ) {
		$this->userName = $userName;
	}
	
	//Get user info with username 
	public function getUserInfo($userName) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_name = '$userName' ");

		while($row = mysqli_fetch_array($result)) {		
			$this->id 			= $row['user_id']; 
			$this->firstName 	= $row['first_name'];
			$this->lastName 	= $row['last_name']; 
			$this->email 		= $row['email']; 
			$this->biography 	= $row['biography']; 
			$this->userImage 	= $row['image_name']; 
			
		  }
	} 
	
	public function updateUserInfo($newFirstName, $newLastName, $newEmail, $newBiography, $primary_id) {
		global $conn;
		$sql = "UPDATE user_profile SET first_name = ?, last_name = ?, email = ?, biography= ?, image_name=? WHERE primary_id = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('sssssi', $newFirstName, $newLastName, $newEmail, $newBiography, $userImage, $primary_id);
		$stmt->execute();	
	}
	 
	
	public function deleteUser() {
		echo "Post is from ";
		echo $this->from;
	} 
	
}




?>

