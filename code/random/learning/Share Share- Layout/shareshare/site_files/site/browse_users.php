<?php 
require_once('../includes/session_timeout.inc.php');
require_once('../includes/connection.inc.php');
	
	//SQL query to get users
	$conn = dbConnect('read');
	$result_records = mysqli_query($conn,"SELECT * FROM user_profile");
	$result = mysqli_query($conn,"SELECT * FROM user_profile");		
	
	
	$logged_in_user = $_SESSION['varname'];
	
	//Get Logged in user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $logged_in_user);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $logged_in_user_id = $result_user_id;
      $stmt_user_id -> close();
    }	

	//Create Query for a list of logged in users friends	
	$sql = "SELECT friends.friends_id, user_profile.user_id, friends.friend_id 
	FROM friends INNER JOIN user_profile ON (user_profile.user_id = friends.friend_id) WHERE (friends.user_id = '$logged_in_user_id')";
	$result_friends = $conn->query($sql) or die(mysqli_error());

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Share Share</title>

    <!-- CSS -->
	<link href="../../style/style.css" rel="stylesheet" type="text/css" media="screen" />	
    <link href="../../style/browse_users.css" rel="stylesheet"> 


</head>

	<body>
		<div class="site-wrapper">		
			<!--Header -->
			<nav id = "navigation">
					<a href="#home">ShareShare</a>
			</nav>
			<div id="name_feedback"></div>
		
		
			<!-- Like-->
			<?php
			//Create an array of all logged in users friends and initialize loop and friend check to 0
	
			$loop_count = 0;
			while($row_friends = $result_friends->fetch_assoc()) {
				$user_friend_array[$loop_count]= $row_friends['friend_id'];
				$loop_count = $loop_count + 1;
			}
			//This loop will be checked against the loop down below
			//If you are not friends with yourself this generates an error!!
			$arrlength=count($user_friend_array);
				
			while($row = mysqli_fetch_array($result)) {
				$friends = false;
			?>
				<div class = "browse-users"> 
					<div class = "image-size">					
						<a href="default_user_display.php?varname=<?php echo $row['user_id'] ?>">
						<img class="shadow" border="1" src="../../images/profile_image/<?php echo $row['image_name']; ?> " alt="<?php echo $row['first_name']; ?>" width="180" ></a>
					</div>	
					
					<h3> <?php echo $row["first_name"] . " " . $row['last_name'] . "<br /> " . $row['user_id']; ?> </h3> <br />
				
					<!-- Friend Button -->
					<?php  			
						for($x=0;$x<$arrlength;$x++) {
							if($row['user_id']==$user_friend_array[$x]) {
								//echo "<br / > true <br />";
								$friends = true;
							}
						}				
						if($friends == "true") { ?>
						
						<button type="button" id="<?php echo $row['user_id']; ?>" >Unfriend</button>
						<input type="hidden" id="user_id" value="<?php echo $row['user_id']; ?>" />
							
						<?php } else { ?> 
						<button type="button" id="<?php echo $row['user_id']; ?>" >Be Friends!</button>
						<input type="hidden" id="user_id" value="<?php echo $row['user_id']; ?>" />
	
					<?php } ?>
							
				</div>
					
			<?php }; ?>
		</div>	

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="jscript/add_friend.js"></script>

	</body>
</html>