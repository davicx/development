<?php

include 'connection.inc.php';

class Post {
	public $post_id = "";
	public $post_from = "";
	public $post_from_image = "";
	public $post_from_fname = "";
	public $post_from_lname = "";
	public $post_from_user_id = "";	
	public $post_from_logged_in_user = "";	
	public $post_to = "";
	public $post_type= ""; 
	public $category = ""; 
	public $post_caption = "";
	public $post_url = "";	
	public $video_code = "";	
	public $image_url = "";	
	public $file_url = "";	
	public $file_name = "";	
	public $file_name_server = "";	
	public $article_title = ""; 
 	public $article_text = ""; 		
	public $contains_file = "";
	public $group_id = "";
	public $unique_id = "";
	public $display_edit = "";
	public $updated = "";
	public $created = "";
	
	//Time and Posted Related 
	public $posted_time_display = "";
	public $posted_time_message = "";
	public $month = "";
	public $day = "";
	public $time_hours = "";		

	//Post Likes 
	public $total_likes = "";
	public $liked_by_logged_in_user = ""; //1 means they liked it 0 means they did not 
	public $like_array = array();
	public $total_up_votes = "";
	public $total_down_votes = "";	
	public $up_vote_by_logged_in_user = "";	
	public $down_vote_by_logged_in_user = "";	
	
	//Comments
	public $total_comments = "";	
	public $new_comments = "";	
	public $array_comments_unseen = array();	
	
	public function __construct($post_id) {
		$this->post_id = $post_id;
	}


	//METHOD 1: Get all posts by posted to  
	public function getUserPost($post_id, $logged_in_user) {
		global $conn;
		$logged_in_user = strtolower($logged_in_user);
		$logged_in_user_test = strtolower($logged_in_user);
		
		//POST PART 1: Get All post Information from database 
		$result = mysqli_query($conn,"SELECT * FROM posts WHERE post_id = '$post_id' ");

		while($row = mysqli_fetch_array($result)) {	
			$this->post_from = $row['post_from'];
			$post_from = $row['post_from']; 
			$post_to = $row['post_to']; 
			$this->post_to = $post_to; 
			$this->post_type = $row['post_type']; 
			$post_caption = $row['post_caption']; 
			$this->post_caption = $post_caption;	
			$this->post_url = $row['post_url']; 
			$this->video_code = $row['video_code']; 	
			$this->image_url = $row['image_url']; 
			$this->file_url  = $row['file_url']; 
			$this->file_name = $row['file_name']; 			
			$this->file_name_server = $row['file_name_server']; 			
			$this->article_title = $row['article_title']; 
			$this->article_text = $row['article_text']; 	
			$this->group_id = $row['group_id']; 		
			$this->contains_file = $row['contains_file']; 		
			$this->unique_id = $row['unique_id']; 		
			$this->updated = $row['updated']; 
			$this->created = $row['created']; 	
			

			//PART 2: Find if post is from logged in user			
			$post_from = strtolower($post_from);
			$logged_in_user =  strtolower($logged_in_user);
			
			if(strcmp($logged_in_user, $post_from)==0) {
				$this->post_from_logged_in_user = 1;			
				$this->display_edit = "";			
			} else {
				$this->post_from_logged_in_user = 0; 			
				$this->display_edit = "hide"; 			
			}

			//PART 3: Create an array of likes
			$result_likes = mysqli_query($conn,"SELECT * FROM post_likes WHERE post_id = '$post_id' ");

			$post_like_count = 0;
			//$likedByUser = 0;
			$like_array_test = array();
			
			while($row_likes = mysqli_fetch_array($result_likes)) {			
				$this->like_array[$post_like_count]	=  strtolower($row_likes['liked_by_name']);
				$like_array_test[$post_like_count] = $row_likes['liked_by_name'];
				$post_like_count = $post_like_count + 1;		
			}
			
			$this->total_likes = $post_like_count;
		
			//PART 4: Find out if logged in user has liked this post already
			if (in_array(strtolower($logged_in_user), $like_array_test)) {
				$this->liked_by_logged_in_user = 1; //User was in array
			}
			else {
				$this->liked_by_logged_in_user = 0; //User not in array 			
			}
		
			//PART 5: Get Information about who made the Post 
			$result_user = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_name = '$post_to' ");

			while($row_user = mysqli_fetch_array($result_user)) {	
				$this->post_from_image = $row_user['image_name'];
				$this->post_from_fname = $row_user['first_name'];
				$this->post_from_lname = $row_user['last_name'];
				$this->post_from_user_id = $row_user['user_id'];			
			}
		} 
	}	

	
	//METHOD 2: Get a Message to Display of when post was made 
	public function getPostedTimeMessage($post_id, $logged_in_user) {
		global $conn;
		
		$result = mysqli_query($conn,"SELECT * FROM posts WHERE post_id = '$post_id' ");

		while($row = mysqli_fetch_array($result)) {		
			//$this->updated = $row['updated']; 
			$dateArray = date_parse($row['updated']);
			$posted_date = $row['created']; 	
		}	
		
		//PART 1: Date and Time Related (Needs to be Organized)
		$monthNum  = $dateArray['month'];
		$dateObj   = DateTime::createFromFormat('!m', $monthNum);
		$monthName = $dateObj->format('F'); 
		$this->month = $monthName;
		$this->day = $dateArray['day'];
		$dayNumber = $dateArray['day'];
		$posted_time_army = $dateArray['hour'] . ":" . $dateArray['minute'];
		
		//Part 1A: Convert time to am/pm
		$posted_time = date( 'g:i A', strtotime( $posted_time_army ) );
		$this->time_hours = $posted_time;
				
		//Part 1B: Get Current Date and Posted Date and Convert to Date Time Object
		date_default_timezone_set('America/Los_Angeles');
		
		//$posted_date = $row['created']; 
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
		$this->posted_time_message = $posted_time_message; 	
	} 
	

	//METHOD TEMP: Get a Message to Display of when post was made 
	public function getPostedTimeMessageONID($post_id, $logged_in_user) {
		$this->posted_time_message = "one minute (onid)"; 	
	} 
	
	
	//METHOD 2: Delete Post
	public function deletePost($post_id) {
		global $conn;
		$sql = "UPDATE posts SET post_status= '0' WHERE post_id='$post_id'";

		if (mysqli_query($conn, $sql)) {
			echo "Record updated successfully";
		} else {
			echo "Error updating record: " . mysqli_error($conn);
		}
	} 
	
	
	//METHOD 3: Update Post	
	public function updatePost($newFirstName, $newLastName, $newEmail, $newBiography, $primary_id) {
		global $conn;
		$sql = "UPDATE persons SET first_name = ?, last_name = ?, email = ?, biography= ? WHERE primary_id = ?";
		$stmt = $conn->prepare($sql);
		$stmt->bind_param('ssssi', $newFirstName, $newLastName, $newEmail, $newBiography, $primary_id);
		$stmt->execute();	
	}



//APPENDIX
	
	//Methods to Finish//
	//Purchase Post Item 
	public function purchasePost($post_id) {
		global $conn;
		
		echo "success";

	} 	

	//On this one we need to 
	public function likePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function cancelLikePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function dislikePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function cancelDislikePost() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function updateComment() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function deleteComment() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
	public function makeComment() {
		echo "Post is from ";
		echo $this->post_from;
	} 
	
}
	
	/*
	post_id 
	master_site
	post_type
	post_status
	parent
	group_id 
	list_id 
	post_from 
	post_to 
	post_caption
	post_url 
	post_url_caption
	video_code 
	image_url
	file_url 
	file_name file_name_server 
	article_title 
	article_text 
	contains_file 
	unique_id 
	purchased 
	purchased_by
	password_email 
	password_notes 
	comment_seen 
	updated created
*/

	/* GET COMMENTS
	//STEP 3 Create an array of new commments
	$result_new_comments = mysqli_query($conn,"SELECT * FROM comments WHERE post_id = '$post_id' AND updated >= '$comment_seen'");

	$newCommentCount = 0;
	$commentArrayNew = array();
	
	while($row_new_comments = mysqli_fetch_array($result_new_comments)) {			
		$newCommentArray[$newCommentCount] = $row_new_comments['comment_id'];
		$commentArrayNew[$newCommentCount] = $row_new_comments['comment'];	
		$newCommentCount = $newCommentCount + 1;					
	}

	$this->new_comments = $newCommentCount;		
	$this->array_comments_unseen = $commentArrayNew;		

	
	*/
	//METHOD 3: Get Comments
			/*
			//PART 11: Get Comments 
			$result_comments = mysqli_query($conn,"SELECT * FROM comments WHERE post_id = '$post_id' and comment_deleted = '0'");

			$commentCount = 0;
			$commentArray = array();
			
			while($row_comments = mysqli_fetch_array($result_comments)) {			
				$newCommentArray[$commentCount] = $row_comments['comment_id'];
				$commentArray[$commentCount] = $row_comments['comment'];	
				$commentCount = $commentCount + 1;		
				
			}
			
			$this->total_comments = $commentCount;
			
			*/	
	//METHOD 4: Get Notification Information 
	
				/*
			//PART 6: Get Information for notifications and new comments 
			//Part 6A: Get last time post comments where looked at 
			if ($result = mysqli_prepare($conn, "SELECT comment_seen FROM posts WHERE post_id=?")) {
				$result -> bind_param("i", $post_id);
				$result -> execute();
				$result -> bind_result($result_seen);
				$result -> fetch();
				$comment_seen = $result_seen;
				$result -> close();
			} 
			*/
			/*

			*/

	
	///SORT
	/*

		//PART 4: Get Upvotes  
		$result_up_vote = mysqli_query($conn,"SELECT * FROM post_votes WHERE post_id = '$post_id' AND up_vote = 1");

		$up_vote_count = 0;
		$up_vote_current_user = 0;
		$array_up_vote = array();
		
		while($row_up_vote  = mysqli_fetch_array($result_up_vote )) {			
			$array_up_vote[$up_vote_count] = $row_up_vote['up_vote_user'];
			$up_vote_count = $up_vote_count + 1;		
		}
		
		//Get upvotes and if current user up or downvoted 
		$this->total_up_votes = $up_vote_count;
		if (in_array($logged_in_user_test, $array_up_vote)) {
			$this->up_vote_by_logged_in_user = 1;
		} else {
			$this->up_vote_by_logged_in_user = 0;		
		}
		*/
		/*
		//PART 5: Get Downvotes  	
		$result_down_vote = mysqli_query($conn,"SELECT * FROM post_votes WHERE post_id = '$post_id' AND down_vote = 1");

		$down_vote_count = 0;
		$down_vote_current_user = 0;
		$array_down_vote = array();
		
		while($row_down_vote  = mysqli_fetch_array($result_down_vote )) {			
			$array_down_vote[$down_vote_count] = $row_down_vote['down_vote_user'];
			$down_vote_count = $down_vote_count + 1;		
		}
		
		//$logged_in_user_test
		$this->total_down_votes = $down_vote_count;
		if (in_array($logged_in_user_test, $array_down_vote)) {
			$this->down_vote_by_logged_in_user = 1;
		} else {
			$this->down_vote_by_logged_in_user = 0;		
		}

	*/

?>