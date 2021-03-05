<?php 
require_once 'connection.inc.php';
require_once 'protect.php';

$username =  ($_POST['username']);
$time = time();

$sql = 'INSERT INTO users (username, join_date) VALUES (?, ?)';			  
$stmt = $conn->stmt_init();
$stmt = $conn->prepare($sql);
// bind parameters and insert the details into the database
$stmt->bind_param('ss', $username, $time);
$stmt->execute();

	


?>