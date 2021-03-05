<?php
//require_once(__DIR__.'/constants.php');
require_once('constants.inc.php');
global $conn; 

//Database Connection 
$conn = mysqli_connect($host, $user_name, $password , $dbname);

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?>