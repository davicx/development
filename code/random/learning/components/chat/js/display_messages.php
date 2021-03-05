<?php 
require_once 'connection.inc.php';

$fiveMinutesAgo = time()-600;

	//$sql = 'SELECT username, message_content, message_time FROM messages WHERE user_name = "'.$user_name.'"';
	//WHERE message_time > ' . $fiveMinutesAgo . '
	$sql = 'SELECT username, message_content, message_time FROM messages ORDER BY message_time';
	
	//$sql = 'SELECT * FROM messages ';
	$result = $conn->query($sql) or die(mysqli_error());
	
	while($row = $result->fetch_assoc()) {
		//echo $row['username'] . "<br />"; 
		//echo $row['message_content']; 
		echo  "<p>" . $row['message_content'] . "</p>";
		
	};

	
	
?>

