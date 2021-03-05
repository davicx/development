
<!DOCTYPE html>
<html>
    <head>
        <title>ShareSpace</title>
        <link rel="stylesheet" href="css/uikit.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Karla%7CMontserrat">
		<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">		
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="js/main.js"></script>
    </head>
    <body>
	
	
	<?php
		$conn = mysqli_connect("oniddb.cws.oregonstate.edu","vasquezd-db","gCtLRbXMWWS2SwNg","vasquezd-db");

			// Check connection
			if (mysqli_connect_errno()) {
			  echo "Failed to connect to MySQL: " . mysqli_connect_error();
			} else {
				echo "connect";
			
			}
			
	
		function sendEmail() {
			$conn = mysqli_connect("oniddb.cws.oregonstate.edu","vasquezd-db","gCtLRbXMWWS2SwNg","vasquezd-db");

			// Check connection
			if (mysqli_connect_errno()) {
			  echo "Failed to connect to MySQL: " . mysqli_connect_error();
			} 
			
			//Store in database and make sure that this is Unique in database
			$logged_in_user = "vasquezd";
			$hash = sha1(mt_rand(10000,99999).time().$email);
			$square_id = 50;
			
			//$hash = "7hash7";
			$userEmail = "davidv2@hotmail.com";
	
			$link_part_one = "<p><a href=\"http://people.oregonstate.edu/~vasquezd/email/verify.php?name=";
			$link_part_two = $hash;
			$link_part_three = "&age=";
			$link_part_four = $userEmail;
			$link_part_five = "&squareid=";
			$link_part_six = $square_id;
			$link_part_seven = "\">Join Sharespace</a></p>";
			
		
			$link = $link_part_one . $link_part_two . $link_part_three . $link_part_four . $link_part_five . $link_part_six . $link_part_seven;

			$to      = "vasquezd@onid.orst.edu";
			$subject = 'This is a test';
			$message = "hello, there click this link " . $link. " thanks!" ;
				
			$headers = 'From: david.vasquez@oregonstate.edu' . "\r\n" .
				'Reply-To: david.vasquez@oregonstate.edu' . "\r\n" .
				'X-Mailer: PHP/' . phpversion();
			$headers = "Content-Type: text/html; charset=ISO-8859-1\r\n";
			mail($to, $subject, $message, $headers);	
	
			//echo "Email Sent!";
			
		//$insert = $conn->prepare("INSERT INTO pending_email (codehash, request_from, email, square_id) VALUES (?,?,?,?) ");
		//$insert->bind_param('sssi', $hash, $loggedInUser, $userEmail, $square_id);
		
		
			$sql = "INSERT INTO pending_email (codehash, request_from, email, square_id) VALUES ('$hash', '$loggedInUser', '$userEmail', '$square_id')";

			if (mysqli_query($conn, $sql)) {
				echo "New record created successfully";
			} else {
				echo "Error: " . $sql . "<br>" . mysqli_error($conn);
			}
	
		}

		sendEmail(); // call the function
		//$hash = sha1(mt_rand(10000,99999).time().$email);
		//echo $hash;
			

		?> 
		
    </body>
</html>