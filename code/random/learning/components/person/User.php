<?php
include 'includes/connect.php';

class User{
	public $id = "";
	public $userName = "";
	public $firstName = "";
	public $lastName = "";
	public $email = "";
	public $biography = "";
	
	
	public function __construct($userName ) {
		$this->userName = $userName;
	}

	public function getUserInfo($userName) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM Persons WHERE user_name = '$userName' ");

		while($row = mysqli_fetch_array($result)) {		
			$this->id 			= $row['primary_id']; 
			$this->firstName 	= $row['first_name'];
			$this->lastName 	= $row['last_name']; 
			$this->email 		= $row['email']; 
			$this->biography 	= $row['biography']; 
		  }
	} 
	
	public function updateUserInfo($newFirstName, $newLastName, $newEmail, $newBiography, $primary_id) {
		global $conn;
		$sql = "UPDATE persons SET first_name = ?, last_name = ?, email = ?, biography= ? WHERE primary_id = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('ssssi', $newFirstName, $newLastName, $newEmail, $newBiography, $primary_id);
		$stmt->execute();	
	}
	 
	
	public function deleteUser() {
		echo "Post is from ";
		echo $this->from;
	} 
	
}




?>

