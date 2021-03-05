<?php
require_once('classes/CheckPassword.php');
require_once('includes/connection.inc.php');
//$conn = dbConnect('write');

$usernameMinChars = 6;
$errors = array();

if (strlen($username) < $usernameMinChars) {
  $errors[] = "Username must be at least $usernameMinChars characters.";
}
if (preg_match('/\s/', $username)) {
  $errors[] = 'Username should not contain spaces.';
}
//Step 1: Create new password object
$checkPwd = new Ps2_CheckPassword($pword, 7);

//Step 2: Check Password to make sure it has required number of numbers and mixed case
//$checkPwd->requireMixedCase();
//$checkPwd->requireNumbers(2);
//$checkPwd->requireSymbols();
$passwordOK = $checkPwd->check();
if (!$passwordOK) {
  $errors = array_merge($errors, $checkPwd->getErrors());
}
if ($pword != $retyped) {
  $errors[] = "Your passwords don't match.";
}


//Step 3: Check if user name exists 
if ($result = mysqli_prepare($conn, "SELECT user_name FROM user_profile WHERE user_name=?")) {
	$result -> bind_param("s", $username);
	$result -> execute();
	$result -> bind_result($result_user_id);
	$result -> fetch();
	$user_id = $result_user_id;
	$result -> close();

	if(!empty($user_id)) {
		$errors[] = "User Name Exists.";
	} 
} 

//Step 4: Insert new user into database 
if (!$errors) {

  // include the connection file
	require_once('includes/connection.inc.php');

	//Create a salt using the current timestamp
	$salt = time();
	//Encrypt the password and salt with SHA1
	$pwd = sha1($pword . $salt);
	//Prepare SQL statement
	$sql = 'INSERT INTO user_login (user_name, salt, password) VALUES (?, ?, ?)';
	$stmt = $conn->stmt_init();
	$stmt = $conn->prepare($sql);
	//Bind parameters and insert the details into the database
	$stmt->bind_param('sis', $username, $salt, $pwd);
	$stmt->execute();
	$stmt->close();

	//Pull user_id and update user_profile table with this id 
	if ($result_id = mysqli_prepare($conn, "SELECT user_id FROM user_login WHERE user_name=?")) {
		$result_id -> bind_param("s", $username);
		$result_id -> execute();
		$result_id -> bind_result($result_user_id);
		$result_id -> fetch();
		$user_id = $result_user_id;
		$result_id -> close();
	} 
	
	//Create a default image to start user profile with	
	$default_image = "david.jpg";
	$biography = "They are (or were) a little people, about half our height, and smaller than the bearded dwarves. 
	Hobbits have no beards. There is little or no magic about them except the ordinary everyday sort which helps 
	them to disappear quietly and quickly when large stupid folk like you and me come blundering along, 
	making a noise like elephants which they can hear a mile off <- Not your bio change it here";
	
	mysqli_query($conn,"INSERT INTO user_profile(user_name, user_id, image_name, root_folder, biography, created) VALUES ('$username', '$user_id', '$default_image', '$username', '$biography', NOW())");
    //mysqli_stmt_close($stmt_id);

	
	//EDIT: If new user was invited through email then create a new profile for them that has an existing square with the invite in it. 
	if (isset($_GET["useremail"]) && !empty($_GET["hash"])) {
		//Select information from database to get square id matching code hash 
		$codehash = $_GET["hash"];
		$square_user = $username;
		$status = 1;
		
		//Get the id of the square they were invited to 
		if ($result_id = mysqli_prepare($conn, "SELECT square_id FROM pending_email WHERE codehash =?")) {
			$result_id -> bind_param("s", $codehash);
			$result_id -> execute();
			$result_id -> bind_result($result_hash);
			$result_id -> fetch();
			$square_id = $result_hash;
			$result_id -> close();
		} 
		
		//Creat a new square for the user who just joined from an email invite
		$insert = $conn->prepare("INSERT INTO square_users (square_id, user_name, status) VALUES (?,?,?) ");
		$insert->bind_param('isi', $square_id, $square_user, $status);
			if ($insert->execute()) {
				echo "success";
			} else {
				echo "fail";	
			}			
	} else {

	}	

	//Create new folder on server for new user creation
	if (!file_exists('user_files/user_uploads/'.$username.'')) {
		mkdir('user_files/user_uploads/'.$username.'', 0777, true);
	}
	
	//Insert Folder details 
	$sql = "INSERT INTO folders (folder_name, user_name) VALUES (?, ?)";		  
	$stmt = $conn->stmt_init();
	$stmt = $conn->prepare($sql);
	// bind parameters and insert the details into the database
	$stmt->bind_param('ss', $username, $username);
	$stmt->execute();


	//Check if item was inserted and output message 	
	if ($stmt->affected_rows == 1) {    
		$success = "$username has been registered. You may now log in.";
	} else {
		$errors[] = 'Sorry, there was a problem with the database.';
	}
}