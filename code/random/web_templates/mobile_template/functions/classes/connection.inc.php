<?php
//WAMP 
//Server Connect
$host		= "localhost";
$user_name	= "root";
$password 	= "";
$dbname 	= "sharespace";


/*
//LIVE SERVER
//Server Connect

$host		= "mysql.beta.mysharesquare.com";
$user_name	= "vasquezd";
$password 	= "Pgcb1e3K4ZerHPj";
$dbname 	= "sharespace717";
*/

/*
//AMPPS SERVER

$host		= "localhost";
$user_name	= "root";
$password 	= "mysql";
$dbname 	= "sharespace";
*/



// Create connection
global $conn; 

$conn = mysqli_connect($host, $user_name, $password , $dbname);

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?> 
