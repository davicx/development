<?php
require_once('../includes/session_timeout.inc.php');
require_once('../includes/connection.inc.php');	

	//SQL query to get users
	$conn = dbConnect('read');
	$logged_in_user = $_SESSION['varname'];
	
	//Get logged in user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $logged_in_user);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $logged_in_user_id = $result_user_id;
      $stmt_user_id -> close();
    }	
	
	//Get username of user who the logged in user is looking at 
	$id_value = $_GET['varname'];

	if ($stmt_one = mysqli_prepare($conn, "SELECT user_name FROM user_profile WHERE user_id=?")) {
		  $stmt_one -> bind_param("i", $id_value);
		  $stmt_one -> execute();
		  $stmt_one -> bind_result($result_one);
		  $stmt_one -> fetch();
		  $user_name = $result_one;
		  $stmt_one -> close();
	   }

	//Get user information for user profile being looked at by logged in user
	$sql = 'SELECT * FROM user_profile WHERE user_id = "'.$id_value.'"';
	$result = $conn->query($sql) or die(mysqli_error());
	
	//Determine if they are friends
	$sql = "SELECT friends.friends_id, user_profile.user_name, user_profile.first_name, user_profile.user_id 
	FROM friends INNER JOIN user_profile ON (user_profile.user_id = friends.friend_id) WHERE (friends.user_id = '$logged_in_user_id')";
	$result_friends = $conn->query($sql) or die(mysqli_error());
	
	$friends = false;
	while($row_friends = $result_friends->fetch_assoc()) {
		if($row_friends['user_id'] == $id_value) {
			$friends = true;
		} else {
		//	echo "not friends";
		}			
	};
?>
<!doctype html>
<html>
<head>
	<title>ShareShare</title>

	<!-- Meta Tags -->
	<meta charset="utf-8">
	<meta name="description" content=".">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width">

	<!-- CSS -->
	<link href="../../css/style.css" rel="stylesheet">
	<link href="../../css/user.css" rel="stylesheet"> 	

</head>
	<body>
		<div class="site-wrapper">
		
		
			<?php echo "Logged in as: " . ($logged_in_user) . "<br />" ?>	
			<?php echo "and you are looking at" . ($id_value); ?>
				
		<div class="content">		
			<?php while($row = $result->fetch_assoc()) { ?>  
				<!--User Name and Default Image-->
				<p>User Name: <?php echo $row['user_name']; ?></p> 
				<div class="user-image">
					<img class = "shadow" border="0" src="../../images/profile_image/<?php echo $row['image_name'] ?>" alt="<?php echo $row['image_name'] ?>" width="180">
				</div>			
				
				<!--User Profile-->
				<div class="profile">
					<h3><b>Profile </b></h3>
					<p><b>First Name: </b><?php echo $row['first_name']; ?></p>
					<p><b>Last Name: </b><?php echo $row['last_name']; ?></p>
					<p><b>University: </b><?php echo $row['university']; ?></p>
					<p><b>Services: </b><?php echo $row['services']; ?></p>
				</div>	
				<!--User Images-->
				<?php
				$result_nine = mysqli_query($conn,"SELECT * FROM user_image WHERE user_name = '$user_name'");
				while($row_nine = mysqli_fetch_array($result_nine)) {

				   echo "<img src='../../images/user_images/" . $row_nine['filename'] . "' alt='error'>";	  
				   }		
				?>	
				<!--User Bio-->
				<div class="biography">
					<h3>Biography</h3>			
					<p>Bio: <?php echo $row['bio']; ?></p>
				</div>		
				
			<?php } ?>

			<!--Friends-->
			
				<?php if($friends == "true") { ?>
				
					<button type="button" id="<?php echo $row['user_id']; ?>" class = "friend_button" >Unfriend</button>
					<input type="hidden" id="user_id" value="<?php echo $row['user_id']; ?>" />
						
					<?php } else { ?> 
					<button type="button" id="<?php echo $row['user_id']; ?>" class = "friend_button" >Be Friends!</button>
					<input type="hidden" id="user_id" value="<?php echo $row['user_id']; ?>" />

				<?php } ?>
			</div>	
		</div>	   

	<!-- Bootstrap core JavaScript-->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="js.js"></script>

	</body>	
</html>