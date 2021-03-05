<?php
// Create connection
//global $conn; 
$conn = new mysqli("localhost","root","","sharespace");


if($conn->connect_errno) {
	die("404 error");
}


?> 