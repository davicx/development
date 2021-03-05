<?php
require_once('connection.inc.php');	

class Friends{
	public $userName = "";
	public $userID = "";
	public $totalFriends = "";
	public $friendListID = array();
	public $friendListUserNames = array();

	public function __construct($userName ) {
		$this->userName = $userName;
	}
	
	//Get list of friends including friend user name, user id and total number of friends
	public function getFriendList($userName) {
		global $conn;
		$result = mysqli_query($conn,"SELECT * FROM friends WHERE user_name = '$userName' ");

		$friendCount = 0;
		while($row = mysqli_fetch_array($result)) {			
			$this->friendListID[$friendCount]			= $row['friend_id'];
			$this->friendListUserNames[$friendCount]	= $row['friend_user_name'];
			$friendCount = $friendCount + 1;		
		}
		
		$this->totalFriends = $friendCount;
	} 
	
	//Add friend actually adds it to the pending table 
	public function addFriend($requestFrom, $requestTo) {
		global $conn;
		$requestType	= "friend";
		$sentFrom 	  	= $requestFrom;
		$sentTo 	  	= $requestTo;
		$key 			= $requestFrom . $requestTo;
		$status 		= 1;
		
		//Check to see if a request has already been sent
		$check = mysqli_query($conn,"SELECT * FROM pending_requests WHERE request_key = '$key' ");
		$count = $check->num_rows; 
		
		//If it has not insert friend request into pending rows
		if($count == 0){
			$insert = $conn->prepare("INSERT INTO pending_requests (request_type, sent_by, sent_to, request_key, status) VALUES (?,?,?,?,?) ");
			$insert->bind_param('ssssi', $requestType, $sentFrom, $sentTo, $key, $status);
			
			if ($insert->execute()) {
				echo "added key";
			} else {
				echo "error";
			}
		} else {
			echo "Request already Sent";
		}
	} 
	
	//Delete friend from database
	public function deleteFriend($requestFrom, $requestTo) {
		global $conn;
		$sql = "DELETE FROM friends WHERE user_name='$requestFrom' and friend_user_name = '$requestTo'";

		if ($conn->query($sql) === TRUE) {
			echo "Record deleted successfully";
		} else {
			echo "Error deleting record: " . $conn->error;
		}
	} 
}




?>

