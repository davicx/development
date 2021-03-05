<?php
include 'includes/connect.php';

//mysqli_query($conn,"UPDATE persons SET biography='Why wopnt this work' WHERE primary_id = 7");

//$sql = "UPDATE persons SET biography=? WHERE primary_id = 7");
$userName = 7;
//$sql = "SELECT first_name FROM persons WHERE user_name = ?";
//$sql = "UPDATE persons SET biography='HELO AG HELLO' WHERE user_name = ?";
$sql = "UPDATE persons SET biography='I was born at a very young age' WHERE primary_id = ?";


$stmt = $conn->prepare($sql);
$stmt->bind_param('s', $userName);
$stmt->execute();


?>