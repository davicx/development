<?php
// Create connection
//global $conn; 
$conn = new mysqli("localhost","root","","dashboard");

echo $conn->connect_errno;

if($conn->connect_errno) {
	die("404 error");
}


?> 