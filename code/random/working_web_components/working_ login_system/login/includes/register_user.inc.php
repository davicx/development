<?php
require_once('classes/CheckPassword.php');
require_once('connection.inc.php');
//$conn = dbConnect('write');

$usernameMinChars = 6;
$errors = array();

if (strlen($username) < $usernameMinChars) {
  $errors[] = "Username must be at least $usernameMinChars characters.";
}
if (preg_match('/\s/', $username)) {
  $errors[] = 'Username should not contain spaces.';
}
$checkPwd = new Ps2_CheckPassword($password, 7);
$checkPwd->requireMixedCase();
$checkPwd->requireNumbers(2);
//$checkPwd->requireSymbols();
$passwordOK = $checkPwd->check();
if (!$passwordOK) {
  $errors = array_merge($errors, $checkPwd->getErrors());
}
if ($password != $retyped) {
  $errors[] = "Your passwords don't match.";
}

//Prepared statement
if ($stmt = mysqli_prepare($conn, "SELECT user_name FROM user_login WHERE user_name=?")) {
    mysqli_stmt_bind_param($stmt, "s", $username);
    mysqli_stmt_execute($stmt);
	$result = $stmt->get_result();
	$row = mysqli_fetch_array($result);
	//Check prepared statement to see if record exists
	$numrows=mysqli_num_rows($result);
	//If record exists then store output in errors (Username exists in database)
	if($numrows > 0){
	$errors[] = "User Name Exists.";
	}
	
    mysqli_stmt_close($stmt);
}
if (!$errors) {
  // include the connection file
  require_once('connection.inc.php');

  // create a salt using the current timestamp

  $salt = time();
  // encrypt the password and salt with SHA1
  $pwd = sha1($password . $salt);
  // prepare SQL statement
  $sql = 'INSERT INTO user_login (user_name, salt, password) VALUES (?, ?, ?)';
		  		  
  $stmt = $conn->stmt_init();
  $stmt = $conn->prepare($sql);
  // bind parameters and insert the details into the database
  $stmt->bind_param('sis', $username, $salt, $pwd);
  $stmt->execute();
  
 
  //This is new and working it pulls the user_id and then it updates the user_profile table with this id it matches the username to avoid confusing
	$stmt_id = mysqli_prepare($conn, "SELECT user_id FROM user_login WHERE user_name=?");
    mysqli_stmt_bind_param($stmt_id, "s", $username);
    mysqli_stmt_execute($stmt_id);
	$result_id = $stmt_id->get_result();
	$row_id = mysqli_fetch_array($result_id);
	$user_id = $row_id[0];
	
	mysqli_query($conn,"INSERT INTO user_profile(user_name, user_id) VALUES ('$username', $user_id)");
    mysqli_stmt_close($stmt_id);

  
  if ($stmt->affected_rows == 1) {    
	$success = "$username has been registered. You may now log in.";
  } else {
	$errors[] = 'Sorry, there was a problem with the database.';
  }
  
}