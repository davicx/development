<?php
// Create connection
$conn = mysqli_connect("localhost","root","","chat3");

// Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?> 