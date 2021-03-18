<?php
/*
Notification Methods 
	1) Method 1: Instantiate Notification 
	2) Method 2: Get All Notification Information 
	3) Method 3: Create Regular Notification
	4) Method 4: Create Group Notification 
	5) Method 5 Create List Notification 
	6) Method 6: Get Total Notifications 
	7) Method 7: Delete Group Notification 
	8) Method 8: Delete Individual Notification 
	9) Method 9: Notification Seen 

*/

include 'connection.inc.php';

class Notifications {
	public $notification_id = "";
	public $master_site = "";
	public $notification_to = "";
	public $notification_from = "";	
	public $notification_time = ""; 
	public $notification_message = ""; 
	public $notification_type = ""; 
	public $full_link = ""; 
	public $link_url = ""; 
	public $group_id = ""; 
	public $list_id = ""; 
	public $from_logged_in_user = ""; 
	public $status_unseen = ""; 
	public $link_clicked = ""; 
	public $notification_made = ""; 
	public $notification_time_message = ""; 
	
	//Notification From Information
	public $notification_from_user_id = "";
	public $notification_from_fname = "";
	public $notification_from_image = "";

	//Total Notifications 
	public $total_notifications = "";
	public $group_notifications = "";	
	public $friend_requests = "";	
	public $new_files = "";	
	public $new_links= "";	
	public $new_notifications = "";	
		
	//Time Related 
	public $month = "";
	public $day = "";
	public $time_hours = "";
	public $full_posted_time = "";
	
	
	//METHOD 1: Instantiate Notification 
	public function __construct($notification_to) {
		$this->notification_to = $notification_to;
	}

			
	//METHOD 2: Get All Notification Information  
	public function getNotification($notification_id) {
		global $conn;
		
		//POST PART 1: Get All post Information from database 
		$result = mysqli_query($conn,"SELECT * FROM notifications WHERE notification_id = '$notification_id' ");

		while($row = mysqli_fetch_array($result)) {				
			$notification_from 			= $row['notification_from']; 	
			$this->notification_to 		= $row['notification_to']; 
			$this->notification_from 	= $notification_from; 
			$this->notification_time 	= $row['notification_time'];
			$this->notification_message = $row['notification_message']; 			
			$this->notification_type 	= $row['notification_type'];			
			$this->full_link 			= $row['full_link'];	
			$this->link_url 			= $row['link_url'];	
			$this->group_id 			= $row['group_id']; 	
			$this->list_id 				= $row['list_id']; 	
			$this->from_logged_in_user 	= $row['from_logged_in_user']; 	
			$this->status_unseen 		= $row['status_unseen'];			
			$this->link_clicked 		= $row['clicked']; 		
			$this->notification_made	= $row['notification_time'];
	

			//USER INFORMATION: Get Information From User who posted Notification
			$result_user = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_name = '$notification_from' ");
			while($row_user  = mysqli_fetch_array($result_user )) {	
				
				//Get First Name of who made notification if set, otherwise use their user name
				$notification_from_fname = $row_user['first_name'];  	
				
				if($notification_from_fname != "") {
					$this->notification_from_fname = $notification_from_fname;					
				} else {
					$this->notification_from_fname = $notification_from;
				}
				
				$this->notification_from_user_id = $row_user['user_id']; 
				
				//Get user image but make sure user has an image, if they don't set image as default
				$current_notification_image = $row_user['image_name'];
				
				if(file_exists('../../user_uploads/user_image/' . $current_notification_image)) { 
					$this->notification_from_image =$current_notification_image;
				} else { 						
					$this->notification_from_image = "default.png";
				} 
			}
			
			//TIME RELATED 
			//ONID
			//$this->month 				= "April";
			//$this->day 					= 1;
			//$this->time_hours 			= 1;
			//$this->full_posted_time 	= "update notif class";
			//$this->notification_time_message = "update notif"; 
			
			//Time Related
			$dateArray 					= date_parse($row['notification_time']);
			$monthNum 					= $dateArray['month'];
			$monthName 					= $dateObj->format('F'); 
			$this->month 				= $monthName;
			$this->day 					= $dateArray['day'];
			
			$dateObj   					= DateTime::createFromFormat('!m', $monthNum);
			$posted_time_army 			= $dateArray['hour'] . ":" . $dateArray['minute'];
			//Convert time to am/pm
			$posted_time 				= date( 'g:i A', strtotime( $posted_time_army ) );
			$this->time_hours 			= $posted_time;
			$this->full_posted_time 	= $monthName . " " . $dateArray['day'] . " at " . $posted_time;
					
			//STEP 2: Created Posted Message
			date_default_timezone_set('America/Los_Angeles');
			
			$posted_date = $row['notification_time']; 
			$post_made_object = new DateTime($posted_date);
			$current_date = date('m/d/Y h:i:s a', time());
			$current_date_object = new DateTime($current_date);
			$current_date_time = strtotime($current_date);
			$post_made_time = strtotime($posted_date);
			
			//Part 2: Get Days, Hours and Minutes Elapsed Since Post
			$time_elapsed_since_post_object = $post_made_object->diff($current_date_object);
			$years_since_posted =  $time_elapsed_since_post_object->y;
			$months_since_posted =  $time_elapsed_since_post_object->m;	
			$hours_since_post = $time_elapsed_since_post_object->h;
			$days_since_posted =  $time_elapsed_since_post_object->days;		
			$minutes_since_post = round(($current_date_time - $post_made_time) / 60,0);	
			$posted_time_message = "";
			
			//YEAR: Poster over a Year Ago
			if($years_since_posted > 0) {
				if($years_since_posted == 1){
					$posted_time_message = "1 Year Ago";
				} else {
					$posted_time_message = $years_since_posted . " Years Ago";
				}
				
			
			//YEAR: Posted LESS than a year ago 				
			} else if ($years_since_posted == 0){
				//$posted_time_message = "Less then a Year Ago"; 
			
				//MONTH: Posted Less More then a month Ago		
				if($months_since_posted > 0) { 
					if($months_since_posted == 1){
						$posted_time_message = "1 Month Ago";
					} else {
						$posted_time_message = $months_since_posted . " Months Ago";
					}
					
				//MONTH: Posted less then a month ago		
				} else if ($months_since_posted == 0) {
					//$posted_time_message = "Less then a Month Ago"; 
					
					//DAY: Posted More then a Day Ago
					if($days_since_posted > 0) {
						//$posted_time_message = " More Then a Day Ago";
						if($days_since_posted == 1){
							$posted_time_message = "1 Day Ago";
						} else {
							$posted_time_message = $days_since_posted . " Days Ago";
						}	
					
					//DAY: Posted Less then a Day Ago
					} else if ($days_since_posted == 0) {
						//$posted_time_message = "Less Then a Day Ago";									
						//HOUR: 
						if($hours_since_post > 0) { 
							if($hours_since_post == 1){
								$posted_time_message = "1 Hour Ago";
							} else {
								$posted_time_message = $hours_since_post . " Hours Ago";
							}																

						//MINUTES: 
						} else if ($hours_since_post == 0) {
							//$posted_time_message = " Minutes Ago";
							if($minutes_since_post > 0) {
								if($minutes_since_post == 1){
									$posted_time_message = "1 Minute Ago";
								} else {
									$posted_time_message = $minutes_since_post . " Minutes Ago";
								}										
							} else if ($minutes_since_post == 0){
								$posted_time_message = "Just Now";
							}							
						}				
						
					}	
				} 
			}
			//echo $posted_time_message;
			$this->notification_time_message = $posted_time_message; 
	
		}
		
	}

	
	//METHOD 3: Create Regular Notification
	public function createNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type) {
		global $conn;
		
		//Notification Variables 
		$status_unseen = 1;

		//See if notification is from the logged in user 
		if ($notification_from == $notification_to) {	
			$from_logged_in_user = 1;	
		} else {
			$from_logged_in_user = 0;				
		}

		$stmt = $conn->prepare("INSERT INTO notifications (master_site, notification_from, notification_to, notification_time, 
			notification_message, notification_type, link_url, full_link, from_logged_in_user, status_unseen) 
			VALUES (?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?)");
		
		$stmt->bind_param("sssssssii", $master_site, $notification_from, $notification_to, 
			$notification_message, $notification_type, $notification_link, $notification_link, $from_logged_in_user, $status_unseen);

		if ($stmt->execute()) {
			//echo "success";
			echo "normal";	
		} else {
			echo "Error: <br>" . mysqli_error($conn);
		}
		$stmt->close();				
	}	
	
	//METHOD 4: Create Regular Notification to a Group
	public function createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id) {
		global $conn;
		
		//Notification Variables 
		$status_unseen = 1;

		//If notification is from the logged in user don't notify them 
		if ($notification_from == $notification_to) {	
			$from_logged_in_user = 1;	
			
		//Create a Notification 	
		} else {
			$from_logged_in_user = 0;
			$notification_count  = 1;
			
			$stmt = $conn->prepare("INSERT INTO notifications (master_site, notification_from, notification_to, notification_time, 
				notification_message, notification_type, link_url, full_link, group_id, from_logged_in_user, notification_count, status_unseen) 
				VALUES (?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?)");
			
			$stmt->bind_param("sssssssiiii", $master_site, $notification_from, $notification_to, 
				$notification_message, $notification_type, $notification_link, $notification_link, $group_id, $from_logged_in_user, $notification_count, $status_unseen);

			if ($stmt->execute()) {
				//echo "success";
				//echo "normal";	
			} else {
				//echo "Error: <br>" . mysqli_error($conn);
			}
			$stmt->close();					
		}		
	}	
	
	
	//METHOD 4: Create Group Invite Notification
	public function createGroupInviteNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id) {
		global $conn;
		
		$status_unseen 			= 1;		
	
		//STEP 1: Make sure Notification is not a duplicate
		$result_notification = mysqli_query($conn, "SELECT * FROM notifications WHERE notification_from = '$notification_from' 
			AND notification_to = '$notification_to' 
			AND notification_type = 'group_invite' 
			AND group_id = '$group_id' 
			AND notification_deleted = '0'");	
		
		$notification_found_count = mysqli_num_rows($result_notification);

		if($notification_found_count < 1) {
			
			//STEP 2: Only Create Notification for Users who were just invited 
			if (strcasecmp($notification_to, $notification_from) !=0) {
				
				//Insert Notification
				$stmt = $conn->prepare("INSERT INTO notifications
				(master_site, notification_from, notification_to, notification_time, notification_message, notification_type, group_id, link_url, full_link, status_unseen) 
				VALUES (?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?)");

				$stmt->bind_param("sssssssii", $master_site, $notification_from, $notification_to, $notification_message, $notification_type, $group_id, $notification_link, $notification_link, $status_unseen);

				if ($stmt->execute()) {
					//echo "success";
					echo "group";
				} else {
					echo "Error: <br>" . mysqli_error($conn);
				}
				$stmt->close();					

			}
		}
	}	


	//METHOD 5 Create List Notification
	public function createListNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $list_id, $group_id, $from_logged_in_user) {
		global $conn;
		
		//Notification Variables 
		$status_unseen = 1;
	
		//Insert into Notification Table 
		$stmt = $conn->prepare("INSERT INTO notifications
			(master_site, notification_from, notification_to, notification_time, notification_message, notification_type, 
			group_id, list_id, link_url, full_link, from_logged_in_user, status_unseen) 
			VALUES (?,?,?, NOW(),?,?,?,?,?,?,?,?)");
		
		$stmt->bind_param("sssssiissii", $master_site, $notification_from, $notification_to, $notification_message, $notification_type, 
		$group_id, $list_id, $notification_link, $notification_link, $from_logged_in_user, $status_unseen);

		if ($stmt->execute()) {
			//echo "success";
			echo "list";	
		} else {
			echo "Error: <br>" . mysqli_error($conn);
		}
		$stmt->close();					
	}
	

	//METHOD 6: Get Total Notifications 
	public function getTotalNotifications($logged_in_user) {
		global $conn;

		//Get all Notifications 
		$result_notifications = mysqli_query($conn, "SELECT notification_id FROM notifications WHERE notification_to = '$logged_in_user' AND status_unseen = '1'");

		$group_notifications = mysqli_num_rows($result_notifications);
		$this->group_notifications = $group_notifications;

		//Get all current Friend Requests 
		$result_friends = mysqli_query($conn, "SELECT primary_id FROM pending_requests WHERE request_type = 'friend' AND sent_to = '$logged_in_user' AND status = '1' ");

		$friend_notifications = mysqli_num_rows($result_friends);
		$this->friend_requests = $friend_notifications;

		//Get all Notifications Related to User Requests (New friend, group, added to group) 
		$result_notifications = mysqli_query($conn, "SELECT primary_id FROM pending_requests WHERE sent_to = '$logged_in_user' AND status = '1' ");

		$notifications_action = mysqli_num_rows($result_notifications);
		$this->new_notifications = $notifications_action;
				
	}


	//METHOD 7: Delete Group Notification 
	public function deleteGroupNotification($master_site, $notification_from, $notification_to, $notification_type, $group_id) {
		global $conn;
		

		//Delete Notification				
		$sql = "DELETE FROM notifications WHERE master_site='$master_site' 
			AND notification_from = '$notification_from' 
			AND notification_to = '$notification_to' 
			AND group_id = '$group_id' 
			AND notification_type = '$notification_type'";
		
		if ($conn->query($sql) === TRUE) {
			echo "Record deleted successfully";
		} else {
			echo "Error deleting record: " . $conn->error;
		}
		
		/*
				//Update Status to Unseen
		if (!($stmt = $conn->prepare("UPDATE notifications SET notification_deleted = ? WHERE notification_id = ? "))) {
			echo "Prepare failed: (" . $conn->errno . ") " . $conn->error;
		}
				
		if (!$stmt->bind_param('ii', $status_unseen, $notification_id)) {
			echo "Binding parameters failed: (" . $stmt->errno . ") " . $stmt->error;
		}
		if (!$stmt->execute()) {
			echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
		}			
		
		*/
	}	

	//METHOD 7: Delete Group Notification 
	public function deleteIndividualNotification($notification_from, $notification_to, $notification_type, $group_id) {
		global $conn;
		
		//Delete Notification				
		$sql = "DELETE FROM notifications WHERE notification_from = '$notification_from' 
			AND notification_to = '$notification_to' 
			AND group_id = '$group_id' 
			AND notification_type = '$notification_type'";
		
		if ($conn->query($sql) === TRUE) {
			echo "Record deleted successfully";
		} else {
			echo "Error deleting record: " . $conn->error;
		}
	
	}		
	

	
	//METHOD 9: Set Notification to Seen
	public function updateNotificationSeen($logged_in_user, $notification_id) {
		global $conn;
				
		if (!($stmt = $conn->prepare("UPDATE notifications SET status_unseen = ? WHERE notification_id = ? "))) {
			echo "Prepare failed: (" . $conn->errno . ") " . $conn->error;
		}
				
		if (!$stmt->bind_param('ii', $status_unseen, $notification_id)) {
			echo "Binding parameters failed: (" . $stmt->errno . ") " . $stmt->error;
		}
		if (!$stmt->execute()) {
			echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
		}	
		
	}	
	

}





/*
//NOTES 
//Post Notifications 
	1) made a comment on your wall 
	2) put a photo on your wall
	3) put a video on your wall
	4) put an article on your wall
	5) put a link on your wall
	6) put a message on your wall
	7) shared a file on your wall
	
//Group Notifications 
	1) added a file to a group
	2) commented in a group
	3) posted to a group
	
//List Notifications 
	1) added an item to a list 
	
//All Other Notifications 
	1) Friends: wants to be friends 
	2) Friends: Accepted your friend request
	3) List: Invited you to a list
	4) List: Accepted your list request	
	5) Group: Invited you to a group
	6) Group: Accepted your group request
	
//Notification Type
	1) friend
	2) post
	3) comment
*/	
/* All Categories */
/*
CURRENT SITE
wishlist
shareshare

TYPE
wall
group
friend
file
link
notifications (maybe have this or have it be the sum of all)

CATEGORY
SUB CATEGORY 

POSTS 
post_comment 
post_new photo 
post_new video
post_new article 
post_new link
post_new text
post_new file

GROUPS 
group_link
group_file
group_link
group_wall_comment
group_wall_post
*/
?>
