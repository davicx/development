<?php
include 'connect.php';

class Posts{
	public $post_id = "";
	public $staff_name = "";
	public $staff_first_name = "";
	public $staff_last_name = "";	
	public $staff_image = "";
	public $contact_name = "";
	public $contact_title = "";
	public $contact_college = "";
	public $liason_date = "";
	public $liason_date_month = "";
	public $liason_date_year = "";
	public $liason_date_header = "";
	public $purpose = "";
	public $created = "";
	public $updated = "";
		
	
	public function __construct($post_id) {
		$this->post_id = $post_id;

	}

	public function getUserPost($post_id) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM liason_connection WHERE post_id = '$post_id' ");	
		
		while($row = mysqli_fetch_array($result)) {		
			$this->post_id = $row['post_id']; 
			$this->staff_name = $row['staff_name']; 
			$this->contact_name = $row['contact_name']; 
			$this->contact_title = $row['contact_title']; 
			$this->contact_college = $row['contact_college']; 
			$this->liason_date = $row['date']; 
			$this->purpose = $row['purpose']; 
			$this->created = $row['created']; 
			$this->updated = $row['updated']; 
			$user_name = $row['staff_name'];
			//Get String Month
			$date= $row['date'];
			$timestamp = strtotime($date);
			$monthNumber = (date("m",$timestamp));
			$dateObj   = DateTime::createFromFormat('!m', $monthNumber);
			$monthName = $dateObj->format('F'); 
			$this->liason_date_month = $monthName;	
			//Get String Year
			$year = date('Y', $timestamp);
			$this->liason_date_year = $year;
			
			
		  }
		  
		//Update this code to prepared statement  
		$result_user = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_name = '$user_name' ");
		
		while($row_user = mysqli_fetch_array($result_user)) {				
			$this->staff_first_name = $row_user['first_name'];
			$this->staff_last_name = $row_user['last_name'];	
			$this->staff_image = $row_user['image_name'];  
		}
	
	} 
	
	/*
	public function updatePost($newFirstName, $newLastName, $newEmail, $newBiography, $primary_id) {
		global $conn;
		$sql = "UPDATE persons SET first_name = ?, last_name = ?, email = ?, biography= ? WHERE primary_id = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('ssssi', $newFirstName, $newLastName, $newEmail, $newBiography, $primary_id);
		$stmt->execute();	
	}
	*/
	
}

?>

