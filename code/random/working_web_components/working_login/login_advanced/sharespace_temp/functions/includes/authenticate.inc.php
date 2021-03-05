<?php
//require_once('../includes/constants.inc.php');	
require_once('/../includes/connection.inc.php');
//$conn = dbConnect('read');

// get the username's details from the database
$sql = 'SELECT salt, password FROM user_login WHERE user_name = ?';
// initialize and prepare statement
$stmt = $conn->stmt_init();
$stmt->prepare($sql);
// bind the input parameter
$stmt->bind_param('s', $username);
// bind the result, using a new variable for the password
$stmt->bind_result($salt, $storedPwd);
$stmt->execute();
$stmt->fetch();
// encrypt the submitted password with the salt and compare with stored password

/*Security*/
if (sha1($password . $salt) == $storedPwd) {
	$_SESSION['authenticated'] = 'Jethro Tull';
	// get the time the session started
	$_SESSION['start'] = time();

  //Login tracking

  session_regenerate_id();
  header("Location: $redirect");
  exit;
} else {
  // if no match, prepare error message
  $error = 'Invalid username or password';
  $error = 'Invalid username or password' . "Stored Password " . $storedPwd . " Salt: " . $salt . " Password " . $password;
}