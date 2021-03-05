<?php
require_once('connection.inc.php');	

class Message{
	public $messageID 		= "";
	public $userName 		= "";
	public $messageContent 	= "";
	public $messageTime		= "";
	public $firstName		= "";
	public $profileImage	= "";

	
	public function __construct($messageID, $userName, $messageContent, $messageTime) {
		$this->messageID		= $messageID;
		$this->userName		 	= $userName;
		$this->messageContent 	= $messageContent;
		$this->messageTime		= $messageTime;
	}

	public function getUserInfo($userName) {
		global $conn;
		$user_name = $userName; 
		$sql = "SELECT image_name, first_name FROM user_profile WHERE user_name = '$user_name'";
		$result = $conn->query($sql) or die(mysqli_error());
	
		while($row = mysqli_fetch_array($result)) {		
			$this->firstName 	= $row['first_name']; 
			$this->profileImage = $row['image_name'];
		  }
	} 
	

}

?>

