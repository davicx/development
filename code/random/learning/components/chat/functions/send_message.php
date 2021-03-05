<?php 
require_once 'connection.inc.php';
require_once 'protect.php';


$username = "david";
$message = protect($_POST['message']);
$time = time();
$time = $time + 10800;


$sql = 'INSERT INTO messages (username, message_content, message_time) VALUES (?, ?, ?)';			  
$stmt = $conn->stmt_init();
$stmt = $conn->prepare($sql);
// bind parameters and insert the details into the database
$stmt->bind_param('ssi', $username, $message, $time);
$stmt->execute();



?>