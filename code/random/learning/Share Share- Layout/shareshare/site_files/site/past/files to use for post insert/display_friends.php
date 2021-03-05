<?php 
require_once('../includes/session_timeout.inc.php');
require_once('../includes/connection.inc.php');
	
	//SQL query to get users
	$conn = dbConnect('read');
	
	//Create local variable with user name 
	$user_name = $_SESSION['varname'];
	
	//Get user id from database
	if ($stmt_user_id = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_user_id -> bind_param("s", $user_name);
      $stmt_user_id -> execute();
      $stmt_user_id -> bind_result($result_user_id);
      $stmt_user_id -> fetch();
	  $user_id = $result_user_id;
      $stmt_user_id -> close();
    }	
		
//	$result_records = mysqli_query($conn,"SELECT * FROM user_profile ");
//	$result = mysqli_query($conn,"SELECT * FROM user_profile ");		
	
	//	$sql = "SELECT friends.friends_id, user_profile.user_name, user_profile.first_name, user_profile.user_id 
	//FROM friends INNER JOIN user_profile ON (user_profile.user_id = friends.friend_id) WHERE (friends.user_id = '$user_id')";


$result = mysqli_query($conn,"SELECT friends.friends_id, user_profile.user_name, user_profile.first_name, user_profile.last_name, user_profile.user_id, user_profile.image_name  
FROM friends INNER JOIN user_profile ON (user_profile.user_id = friends.friend_id) WHERE (friends.user_id = '$user_id')");		

//WORKING JUST NEED TO PREVENT REFRIENDING
	
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
    <link href="../../style/browse_users.css" rel="stylesheet"> 
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="js.js"></script>
	<!-- 
    <!-- Just for debugging purposes. -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>

	<body>
		<div class="site-wrapper">
		<div id="name_feedback"></div>
		
		<!-- Like-->
			<?php
			while($row = mysqli_fetch_array($result)) {
			?>
				<div class = "browse-users"> 
					<div class = "image-size">					
						<a href="default_user_display.php?varname=<?php echo $row['user_id'] ?>">
						<img class="shadow" border="1" src="../../images/profile_image/<?php echo $row['image_name']; ?> " alt="<?php echo $row['first_name']; ?>" width="180" ></a>
				
					</div>	
					<h3> <?php echo $row["first_name"] . " " . $row['last_name'] . "<br /> " . $row['user_id']; ?> </h3>			
					<br />
						
						<!-- Friend Button -->
						<button type="button" id="<?php echo $row['user_id']; ?>" >Friends!</button>
						<input type="hidden" id="user_id" value="<?php echo $row['user_id']; ?>" />
						
				</div>
					
			<?php }; ?>
		</div>	
	</body>
</html>