<?php
ob_start();
require_once('includes/constants.inc.php');
require_once('functions.php');
require_once('includes/connection.inc.php');
require_once('classes/Posts.php');
require_once('classes/Notifications.php');
require_once('classes/File.php');
 
/*
FUNCTIONS A: All Functions Related to Making a Post
	1) Function A1: Post Text  
	2) Function A2: Post a Photo
	3) Function A3: Post a Video
	4) Function A4: Post an Article
	5) Function A5: Post a File 
	
FUNCTIONS B: All Functions Related to Post Actions 
	1) Function B1: Like a Post 
	2) Function B2: UnLike a Post	
	3) Function B3: Delete a Post  	
	4) Function B4: Edit Post Caption (Save New Caption) 

FUNCTIONS C: All Functions Related to Commenting on a Post 
	1) Function C1: Make a New Comment 
	2) Function C2: Edit a Comment
	3) Function C3: Delete a Comment 
*/ 


//FUNCTIONS A: All Functions Related to Making a Post
 
//FUNCTIONS A: All Functions Related to Making a Post
$uploadResult = false;
$max = 10485760;

//Function A1: Post Text
if (isset($_POST["post_text_from"]) && (!empty($_POST["post_comment"]))) {	
	$logged_in_user  	= $_POST["post_text_from"]; 
	$post_from     		= $_POST["post_text_from"]; 
	$post_to     		= $_POST["post_to"]; 
	$group_id 			= $_POST["group_id"];
	$list_id			= $_POST["list_id"];
	$post_comment		= $_POST["post_comment"];	
	$post_type	        = $_POST["post_type"];	
	$parent	        	= $_POST["parent_folder"];
	$post_url		    = "";		
	$article_title		= "";
	$article_text		= "";	
	$master_site	    = $_POST["master_site"];
	$post_id            = 0;
	$post_status 	    = 1;	

	//STEP 1: Insert into posts table 	
	$stmt = $conn->prepare("INSERT INTO posts(master_site, parent, group_id, list_id, post_from, post_to, post_caption, post_url, post_type, article_title, article_text, post_status, updated ) 
		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())");
	$stmt->bind_param("siissssssssi", $master_site, $parent, $group_id, $list_id, $post_from, $post_to, $post_comment, $post_url, $post_type, $article_title, $article_text, $post_status);

	if ($stmt->execute()) {
		echo "New record created successfully";
	} else {
		echo "Error: <br>" . mysqli_error($conn);
	}
	$stmt->close();

	
	//STEP 2: Add New Text Notifications 
	$notification_message = $_POST["notification_message"];
	$notification_link    = $_POST["notification_link"];	
	$notification_type    = $_POST["notification_type"];	
	$notification_from    = $post_from;
	
	$Current_Notification = new Notifications($logged_in_user);
	$notification_to_array = getActiveGroupMembers($group_id);
	$notification_to_count = count($notification_to_array);

	//Loop Through all Group Member and Send them a Notification 
	for($x = 0; $x < $notification_to_count; $x++) {
		$notification_to = $notification_to_array[$x];				
		$Current_Notification->createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id);
	}		
	
}

//Function A2: Post a Photo
if (isset($_POST['post-photo-upload'])) {

	require_once(FUNCTIONS_FOLDER . 'classes/Upload.php');
	try {
	 
		if(isset($_POST['destination'])){ $destination = $_POST['destination']; } else { $destination =  "../../user_uploads/post_images/"; }		
		$upload = new Upload($destination);
		$upload->setMaxSize($max);
		$originalFileName = $upload->getName();
		$upload->move();
		$upload_result = $upload->getMessages();
		$uploadResult = $upload->getUploadOutcome(); 
		$serverImageName = $upload_result[0]; 
		$no_file_added_test = "No file selected.";

		//STEP 1: Get All Additional information to make the Photo Post from the Page 
		if(isset($_POST['master-site'])){ $master_site = $_POST['master-site']; }else { $master_site = "shareshare"; }	 		
		if(isset($_POST['logged-in-user'])){ $logged_in_user = $_POST['logged-in-user']; } else { $logged_in_user = "error"; }	
		if(isset($_POST['photo-caption'])){ $post_caption = $_POST['photo-caption']; } else { $post_caption = "A new photo"; } 
		if(isset($_POST['post-type'])){ $post_type = $_POST['post-type']; } else { $post_type = "photo"; }		
		if(isset($_POST['group-id'])){ $group_id = $_POST['group-id']; } else { $group_id = 0; }	
		if(isset($_POST['redirect'])){ $redirect = $_POST['redirect']; } else { $redirect = "#"; }
		if(isset($_POST['group-id'])){ $group_id = $_POST['group-id']; } else { $group_id = 0; }		
		if(isset($_POST['board-id'])){ $board_id = $_POST['board-id']; } else { $board = 1; }		
		if(isset($_POST['post-from'])){ $post_from = $_POST['post-from']; } else { $post_from = $group_id; }
		if(isset($_POST['post-to'])){ $post_to = $_POST['post-to']; } else { $post_to = $group_id; }		
		if(isset($_POST['notification-message'])){ $notification_message = $_POST['notification-message']; } else { $notification_message = ""; }
		if(isset($_POST['notification-type'])){ $notification_type = $_POST['notification-type']; } else { $notification_type = "new_file"; }
		if(isset($_POST['notification-link'])){ $notification_link = $_POST['notification-link']; } else { $notification_link = $page_redirect; }	
		
		//STEP 2: Create remaining variables 
		$file_name_full = $originalFileName; 
		$file_name = preg_replace('/\\.[^.\\s]{3,4}$/', '', $file_name_full); //Remove Extension and store Seperately 
		$file_extension = pathinfo($file_name_full, PATHINFO_EXTENSION);
		$file_name_server = $serverImageName; 
		$image_url = $serverImageName; 
		$file_image = getFileType($serverImageName, $logged_in_user); 				
		$user_name = $logged_in_user; 		
		$user_id = getUserID($logged_in_user); 		
		$file_status = 1;
		$post_status = 1;		
		
		//STEP 3: Insert Post into Database 
		$stmt = $conn->prepare("INSERT INTO posts( master_site, post_type, post_status, group_id, board_id, post_from, post_to, post_caption,
			image_url, file_name, file_name_server, updated, created) 
			VALUES (?,?,?,?,?,?,?,?,?,?,?, NOW(), NOW())");
			
		$stmt->bind_param("ssiiissssss", $master_site, $post_type, $post_status, $group_id, $board_id, $post_from, $post_to, $post_caption, $image_url, $file_name_full, $file_name_server);

		if ($stmt->execute()) {
			
			//STEP 4: Add New Post Notifications 
			$notification_from    = $post_from;
			
			$Current_Notification = new Notifications($logged_in_user);
			$notification_to_array = getActiveGroupMembers($group_id);
			$notification_to_count = count($notification_to_array);

			//Loop Through all Group Member and Send them a Notification 
			for($x = 0; $x < $notification_to_count; $x++) {
				$notification_to = $notification_to_array[$x];				
				$Current_Notification->createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id);
			}		
				
		} else {
			//echo "Error: <br>" . mysqli_error($conn);
		}	
		
		//STEP 5: Page Redirect 
		//$page_redirect = 'Location: ' . $redirect;
		//header($page_redirect); 
		//exit();
			
	} catch (Exception $e) {
			echo $e->getMessage();
	}		
} 
	
//Function A3: Post a Video
if (isset($_POST["post_from_video"]) && (!empty($_POST["video_url"]))) {
	$logged_in_user     = $_POST["post_from_video"];  
	$post_from          = $_POST["post_from_video"];  
	$post_to     		= $_POST["post_to"]; 
	$master_site	    = $_POST["master_site"];
	$video_url 			= $_POST["video_url"];
	$video_caption	    = $_POST["video_caption"];
	$post_type	        = $_POST["post_type"];
	$current_date 		= date("Y-m-d H:i:s");
	$video_code 		= processVideo($video_url);
	$post_status 	    = 1;
	

	if (isset($_POST["group_id"])) { $group_id = $_POST["group_id"];} else { $group_id = 0; }	
	if (isset($_POST["list_id"])) { $list_id = $_POST["list_id"]; } else {	$list_id = 0; }
	
	//STEP 1: Insert into posts table 	
	$stmt = $conn->prepare("INSERT INTO posts(master_site, group_id, list_id, post_from, post_to, post_url, video_code, post_caption, post_type, post_status, updated, created) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())");
	$stmt->bind_param("siissssssi",  $master_site, $group_id, $list_id, $post_from, $post_to, $video_url, $video_code, $video_caption, $post_type, $post_status);

	if ($stmt->execute()) {
		//echo "New record created successfully";
	
		//STEP 2: Notifications
		if(isset($_POST['notification_message'])){ $notification_message = $_POST['notification_message']; } else { $notification_message = "shared a video";} 
		if(isset($_POST['notification_type'])){ $notification_type = $_POST['notification_type']; } else { $notification_type = "new_post_video";} 
		if(isset($_POST['notification_link'])){ $notification_link = $_POST['notification_link']; } else { $notification_link =  "groups_posts.php?group_id=" . base64_encode($group_id);} //This default link may break it?
		$notification_from    = $post_from;
		
		$Current_Notification = new Notifications($logged_in_user);						
		$notification_to_array = getActiveGroupMembers($group_id);
		$notification_to_count = count($notification_to_array);		
			
		//Loop Through all Group Member and Send them a Notification 
		for($x = 0; $x < $notification_to_count; $x++) {
			$notification_to = $notification_to_array[$x];				
			$Current_Notification->createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id);
			echo "Success: " . $notification_to;
		}				
		
	} else {
		echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}
	$stmt->close();
}

//Function A4: Post an Article 
if (isset($_POST['post-article-upload'])) {

	require_once(FUNCTIONS_FOLDER . 'classes/Upload.php');
	try {
	 
		if(isset($_POST['destination'])){ $destination = $_POST['destination']; } else { $destination =  "../../user_uploads/post_images/"; }		
		$upload = new Upload($destination);
		$upload->setMaxSize($max);
		$originalFileName = $upload->getName();
		$upload->move();
		$upload_result = $upload->getMessages();
		$uploadResult = $upload->getUploadOutcome(); 
		$serverImageName = $upload_result[0]; 
		$no_file_added_test = "No file selected.";

		//STEP 1: Get All Additional information to make the Photo Post from the Page 
		if(isset($_POST['master-site'])){ $master_site = $_POST['master-site']; }else { $master_site = "shareshare"; }	 		
		if(isset($_POST['logged-in-user'])){ $logged_in_user = $_POST['logged-in-user']; } else { $logged_in_user = "error"; }	
		if(isset($_POST['article-caption'])){ $post_caption = $_POST['article-caption']; } else { $post_caption = "A new article"; } 
		if(isset($_POST['article-title'])){ $article_title = $_POST['article-title']; } else { $article_title = "Article Title"; } 
		if(isset($_POST['article-link'])){ $post_url = $_POST['article-link']; } else { $post_url = "#"; } 
		if(isset($_POST['post-type'])){ $post_type = $_POST['post-type']; } else { $post_type = "photo"; }		
		if(isset($_POST['group-id'])){ $group_id = $_POST['group-id']; } else { $group_id = 0; }	
		if(isset($_POST['redirect'])){ $redirect = $_POST['redirect']; } else { $redirect = "#"; }
		if(isset($_POST['group-id'])){ $group_id = $_POST['group-id']; } else { $group_id = 0; }		
		if(isset($_POST['post-from'])){ $post_from = $_POST['post-from']; } else { $post_from = $group_id; }
		if(isset($_POST['post-to'])){ $post_to = $_POST['post-to']; } else { $post_to = $group_id; }		
		if(isset($_POST['notification-message'])){ $notification_message = $_POST['notification-message']; } else { $notification_message = ""; }
		if(isset($_POST['notification-type'])){ $notification_type = $_POST['notification-type']; } else { $notification_type = "new_file"; }
		if(isset($_POST['notification-link'])){ $notification_link = $_POST['notification-link']; } else { $notification_link = $page_redirect; }	
		
		//STEP 2: Create remaining variables 
		$file_name_full = $originalFileName; 
		$file_name = preg_replace('/\\.[^.\\s]{3,4}$/', '', $file_name_full); //Remove Extension and store Seperately 
		$file_extension = pathinfo($file_name_full, PATHINFO_EXTENSION);
		$file_name_server = $serverImageName; 
		$image_url = $serverImageName; 
		$file_image = getFileType($serverImageName, $logged_in_user); 				
		$user_name = $logged_in_user; 		
		$user_id = getUserID($logged_in_user); 		
		$file_status = 1;
		$post_status = 1;		

		//STEP 3: Insert Post into Database 
		$stmt = $conn->prepare("INSERT INTO posts( master_site, post_type, post_status, group_id, post_from, post_to, post_caption, post_url,
			image_url, file_name, file_name_server, article_title, updated, created) 
			VALUES (?,?,?,?,?,?,?,?,?,?,?,?, NOW(), NOW())");
			
		$stmt->bind_param("ssiissssssss", $master_site, $post_type, $post_status, $group_id, $post_from, $post_to, $post_caption, $post_url, $image_url, $file_name_full, $file_name_server, $article_title);

		if ($stmt->execute()) {
			
			//STEP 4: Add New Post Notifications 
			$notification_from    = $post_from;
			$Current_Notification = new Notifications($logged_in_user);
			$notification_to_array = getActiveGroupMembers($group_id);
			$notification_to_count = count($notification_to_array);

			//Loop Through all Group Member and Send them a Notification 
			for($x = 0; $x < $notification_to_count; $x++) {
				$notification_to = $notification_to_array[$x];				
				$Current_Notification->createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id);
			}		
				
		} else {
			//echo "Error: <br>" . mysqli_error($conn);
		}	
		
		//STEP 5: Page Redirect 
		//$page_redirect = 'Location: ' . $redirect;
		//header($page_redirect); 
		//exit();
			
	} catch (Exception $e) {
			echo $e->getMessage();
	}	
} 
	
//Function A5: Post a File 
if (isset($_POST['post-file-upload'])) {

	require_once(FUNCTIONS_FOLDER . 'classes/Upload.php');
	try {
	 
		if(isset($_POST['destination'])){ $destination = $_POST['destination']; } else { $destination =  "../../user_uploads/user_file_uploads/"; }		
		$upload = new Upload($destination);
		$upload->setMaxSize($max);
		$originalFileName = $upload->getName();
		$upload->move();
		$upload_result = $upload->getMessages();
		$uploadResult = $upload->getUploadOutcome(); 
		$serverImageName = $upload_result[0]; 
		$no_file_added_test = "No file selected.";
		
		//STEP 1: Get All Additional information to make the Photo Post from the Page 
		if(isset($_POST['master-site'])){ $master_site = $_POST['master-site']; }else { $master_site = "shareshare"; }	 		
		if(isset($_POST['logged-in-user'])){ $logged_in_user = $_POST['logged-in-user']; } else { $logged_in_user = "error"; }	
		if(isset($_POST['file-caption'])){ $post_caption = $_POST['file-caption']; } else { $post_caption = "A new file"; } 
		if(isset($_POST['post-type'])){ $post_type = $_POST['post-type']; } else { $post_type = "file"; }		
		if(isset($_POST['group-id'])){ $group_id = $_POST['group-id']; } else { $group_id = 0; }	
		if(isset($_POST['redirect'])){ $redirect = $_POST['redirect']; } else { $redirect = "#"; }
		if(isset($_POST['group-id'])){ $group_id = $_POST['group-id']; } else { $group_id = 0; }		
		if(isset($_POST['post-from'])){ $post_from = $_POST['post-from']; } else { $post_from = $group_id; }
		if(isset($_POST['post-to'])){ $post_to = $_POST['post-to']; } else { $post_to = $group_id; }		
		if(isset($_POST['notification-message'])){ $notification_message = $_POST['notification-message']; } else { $notification_message = ""; }
		if(isset($_POST['notification-type'])){ $notification_type = $_POST['notification-type']; } else { $notification_type = "new_file"; }
		if(isset($_POST['notification-link'])){ $notification_link = $_POST['notification-link']; } else { $notification_link = $page_redirect; }	
		
		//STEP 2: Create remaining variables 
		$file_name_full = $originalFileName; 
		$file_name = preg_replace('/\\.[^.\\s]{3,4}$/', '', $file_name_full); //Remove Extension and store Seperately 
		$file_extension = pathinfo($file_name_full, PATHINFO_EXTENSION);
		$file_name_server = $serverImageName; 
		$image_url = $serverImageName; 
		$file_image = getFileType($serverImageName, $logged_in_user); 				
		$user_name = $logged_in_user; 		
		$user_id = getUserID($logged_in_user); 		
		$file_status = 1;
		$post_status = 1;		
		
		//STEP 3: Insert Post into Database 
		$stmt = $conn->prepare("INSERT INTO posts( master_site, post_type, post_status, group_id, post_from, post_to, post_caption,
			image_url, file_name, file_name_server, updated, created) 
			VALUES (?,?,?,?,?,?,?,?,?,?, NOW(), NOW())");
			
		$stmt->bind_param("ssiissssss", $master_site, $post_type, $post_status, $group_id, $post_from, $post_to, $post_caption, $image_url, $file_name_full, $file_name_server);

		if ($stmt->execute()) {
			
			//STEP 4: Add New Post Notifications 
			$notification_from    = $post_from;
			
			$Current_Notification = new Notifications($logged_in_user);
			$notification_to_array = getActiveGroupMembers($group_id);
			$notification_to_count = count($notification_to_array);

			//Loop Through all Group Member and Send them a Notification 
			for($x = 0; $x < $notification_to_count; $x++) {
				$notification_to = $notification_to_array[$x];				
				$Current_Notification->createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id);
			}		
					
			//STEP 5: Page Redirect 
			//$page_redirect = 'Location: ' . $redirect;
			//header($page_redirect); 
			//exit();

		} else {
			//echo "Error: <br>" . mysqli_error($conn);
		}	
	
	} catch (Exception $e) {
			echo $e->getMessage();
	}		
} 	


//FUNCTIONS B: All Functions Related to Post Actions 
//Function B1: Like a Post 
 if (isset($_POST["like_post"]) && (!empty($_POST["like_post"]))) {
	$logged_in_user = $_POST["logged_in_user"]; 
	$post_id     	= $_POST["post_id"]; 
	$user_id 		= getUserID($logged_in_user);
	
	//STEP 1: Make Sure User Has Not Already Liked Post 
	$result_likes = mysqli_query($conn,"SELECT * FROM post_likes WHERE post_id = '$post_id' AND liked_by_name = '$logged_in_user' ");
	$user_post_like_count = $result_likes->num_rows;
	
	if ($user_post_like_count == 0){
		
		//STEP 2: Insert into likes table 	
		$stmt = $conn->prepare("INSERT INTO post_likes(post_id, liked_by, liked_by_name) VALUES (?, ?, ?)");
		$stmt->bind_param("iis",  $post_id, $user_id, $logged_in_user);
		$user_post_like_count = $user_post_like_count + 1;
		if ($stmt->execute()) {
			
			//STEP 3: Get count of new post likes 
			$result_total_likes = mysqli_query($conn,"SELECT * FROM post_likes WHERE post_id = '$post_id'");
			$total_post_likes = $result_total_likes->num_rows;	
			echo $total_post_likes;
	
		} else {
			echo "Error: " . $sql . "<br>" . mysqli_error($conn);
		}			
	} 
}	

//Function B2: UnLike a Post	
if (isset($_POST["unlike_post"]) && (!empty($_POST["unlike_post"]))) {
	$logged_in_user = $_POST["logged_in_user"]; 
	$post_id     	= $_POST["post_id"]; 
	$user_id 		= getUserID($logged_in_user);
	
	//STEP 1: Delete the users Like 
	$sql = "DELETE FROM post_likes WHERE liked_by_name ='$logged_in_user' and post_id = '$post_id'";
	
	if (mysqli_query($conn, $sql)) {
		
		//STEP 2: Get count of new post likes 
		$result_total_likes = mysqli_query($conn,"SELECT * FROM post_likes WHERE post_id = '$post_id'");
		$total_post_likes = $result_total_likes->num_rows;	
		echo $total_post_likes;		
		
		//echo "Record deleted successfully";
	} else {
		echo "Error deleting record: " . mysqli_error($conn);
	}
}	
 
//Function B3: Delete a Post  
if (isset($_POST["delete_post_id"]) && (!empty($_POST["delete_post_id"]))) {
	$post_id = $_POST["delete_post_id"];
	
	//STEP 1: Delete post from Posts  
	$sql = "UPDATE posts SET post_status= '0' WHERE post_id='$post_id'";

	if (mysqli_query($conn, $sql)) {
		echo "Record updated successfully";
	} else {
		echo "Error updating record: " . mysqli_error($conn);
	}
	
	//STEP 2: Delete post from Notifications 
	//When post is made create a unique ID
	//Get Unique ID to get its Post ID
	//Use this to store the post ID in the Notifications Table
	//Delete notifications with this ID
}

//Function B4: Edit Post Caption (Save New Caption)
/* Part 3: Save Edited Post */
if (isset($_POST["post_id"]) && (!empty($_POST["new_post_caption"]))) {
	$post_id 				 = $_POST["post_id"];
	$new_post_caption 		 = $_POST["new_post_caption"];
	$logged_in_user 		 = $_POST["logged_in_user"];

	$sql = "UPDATE posts SET post_caption = ? WHERE post_id = '$post_id'";
	$stmt = $conn->prepare($sql);
	$stmt->bind_param('s', $new_post_caption);
	
	if ($stmt->execute()) {
		//echo $post_caption_edited;
	}
}

//FUNCTIONS C: All Functions Related to Commenting on a Post 
//Function C1: Make a New Comment 
if (isset($_POST["logged_in_user"]) && (!empty($_POST["new_comment"]))) {
	$logged_in_user	  	 = $_POST["logged_in_user"]; 
	$post_id	  		 = $_POST["post_id"]; 
	$comment_is_child  	 = 0; 
	$comment		  	 = $_POST["new_comment"]; 
	$comment_from	  	 = $_POST["logged_in_user"]; 

 	//Step 1: Insert into comments table 	
	$stmt = $conn->prepare("INSERT INTO comments(post_id, comment_is_child, comment, comment_from, updated, created) 
		VALUES (?,?,?,?, NOW(), NOW())");
	$stmt->bind_param("iiss", $post_id, $comment_is_child, $comment, $comment_from);

	if ($stmt->execute()) {
		echo "New record created successfully";
		
		//STEP 4: Add New Post Notifications 
		$notification_from    = $post_from;

		$Current_Notification = new Notifications($logged_in_user);
		$notification_to_array = getActiveGroupMembers($group_id);
		$notification_to_count = count($notification_to_array);

		//Loop Through all Group Member and Send them a Notification 
		for($x = 0; $x < $notification_to_count; $x++) {
			$notification_to = $notification_to_array[$x];				
			$Current_Notification->createGroupNotification($master_site, $notification_from, $notification_to, $notification_message, $notification_link, $notification_type, $group_id);
		}	
		
	} else {
		echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}
	$stmt->close();
} 
 
//Function C2: Edit a Comment
if (isset($_POST["comment_id"]) && (!empty($_POST["comment_caption_edited"]))) {
	$comment_id 			 = $_POST["comment_id"];
	$comment_caption_edited = $_POST["comment_caption_edited"];

	$sql = "UPDATE comments SET comment = ? WHERE comment_id = '$comment_id'";
	$stmt = $conn->prepare($sql);
	$stmt->bind_param('s', $comment_caption_edited);
	
	if ($stmt->execute()) {
		echo $comment_caption_edited;
	}
}

//Function C3: Delete a Comment 
 if (isset($_POST["delete_comment_id"]) && (!empty($_POST["delete_comment_id"]))) {
	$delete_comment_id = $_POST["delete_comment_id"];

	$sql = "UPDATE comments SET comment_deleted = '1' WHERE comment_id ='$delete_comment_id'";

	if (mysqli_query($conn, $sql)) {
		echo "Record updated successfully";
	} else {
		echo "Error updating record: " . mysqli_error($conn);
	}
} 
 

?>