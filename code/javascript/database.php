<!DOCTYPE html>
<html>
	<head>
		<link rel="shortcut icon" href="#">
		<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
		<meta content="utf-8" http-equiv="encoding">
		<script type="text/javascript" src="js/validString.js"></script> 
 
	<body>
	<body>
		 
	<?php 
		$host		= "localhost";
		$user_name	= "root";
		$password 	= "";
		$dbname 	= "test";
		$conn = mysqli_connect($host, $user_name, $password , $dbname);
		
		$result = mysqli_query($conn,"
		 
		SELECT 
			p.product_name,
			(COALESCE (SUM(CASE WHEN i.time_paid is null and i.time_canceled is null and i.time_refunded is null IS NOT NULL THEN it.quantity * it.price ELSE 0 END ),0)) as due,
			(COALESCE (SUM(CASE WHEN i.time_paid IS NOT NULL THEN it.quantity * it.price ELSE 0 END ),0)) as paid,
			(COALESCE (SUM(CASE WHEN i.time_canceled IS NOT NULL THEN it.quantity * it.price ELSE 0 END ),0)) as canceled,
			(COALESCE (SUM(CASE WHEN i.time_refunded IS NOT NULL THEN it.quantity * it.price ELSE 0 END ),0)) as refunded
		FROM
			PRODUCT p
		LEFT OUTER JOIN invoice_item it ON p.id = it.product_id
		LEFT OUTER JOIN invoice i ON it.invoice_id = i.id
		GROUP BY 
			product_name
		ORDER BY 
			p.id ASC
		");
		
		while($row = mysqli_fetch_array($result)) {		
			$product_name = $row['product_name'];	
			$due = $row['due'];	
			$canceled = $row['canceled'];	
			$refunded = $row['refunded'];	
	 
			echo "<p>" . $product_name . " " . $due . " " . $canceled . " " . $refunded . "</p>";
			//echo "<p>" . $last_name . "</p>";
		}	
		//EXAMPLE 1: Inner Join
		/*

		 
			

		//EXAMPLE 1: Inner Join
		$result = mysqli_query($conn,"
			SELECT * FROM user_profile 
			INNER JOIN user_login ON user_profile.user_id = user_login.user_id");

		while($row = mysqli_fetch_array($result)) {		
			$first_name = $row['first_name'];	
			$email = $row['email'];	
			echo "<p>" . $first_name . " " . $email . "</p>";
			//echo "<p>" . $last_name . "</p>";
		}
		 
			*/


 
 
		/*
		$result = mysqli_query($conn,"SELECT * FROM user_profile WHERE NOT location = 'shire'");

		GROUP BY Country.Continent;
		//Select Distinct Last Name
		//$result = mysqli_query($conn,"SELECT DISTINCT last_name FROM user_profile");

		*/
		
		
 
		?>
			

	</body>
</html> 


<?php
/*


$sql = mysql_query("SELECT * FROM your_table WHERE key = 'value'");
$assoc = mysql_fetch_assoc($sql);
var_dump($assoc);

$result = mysqli_query($conn,"SELECT friends.user_name, friends.friend_user_name, friends.friend_id, friends.request_pending, user_login.user_name, 
	user_login.user_id, user_login.account_deleted
	FROM user_login INNER JOIN friends
	ON user_login.user_name = friends.friend_user_name
	WHERE friends.user_name = '$userName'
	AND friends.request_pending = 0
	AND user_login.account_deleted = 0");

while($row = mysqli_fetch_array($result)) {		
	$friend_user_name_array[$friend_count] = $row_friends['friend_user_name'];	
	$friend_user_id_array[$friend_count] = $row_friends['friend_id'];			
}
*/
?>
	