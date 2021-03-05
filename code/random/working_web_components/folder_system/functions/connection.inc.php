<?php
//Server Connect
$host		= "localhost";
$user_name	= "root";
$password 	= "";
$dbname 	= "shareshare";


// Create connection
global $conn; 

$conn = mysqli_connect($host, $user_name, $password , $dbname);

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

?> 
