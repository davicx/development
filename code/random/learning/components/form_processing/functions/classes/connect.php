<?php
// Create connection
global $conn; 
$conn = mysqli_connect("localhost","root","","dashboard");

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?> 