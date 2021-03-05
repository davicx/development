<?php
require_once('../includes/connection.inc.php');
require_once('../includes/session_timeout.inc.php');

//Create database connection
$conn = dbConnect('write');

//Initialize flags
$OK = false;
$done = false;

//Create local variable with user name 
$user_name = $_SESSION['varname'];

if ($stmt_one = mysqli_prepare($conn, "SELECT user_id FROM users WHERE username=?")) {
      $stmt_one -> bind_param("s", $user_name);
      $stmt_one -> execute();
      $stmt_one -> bind_result($result_one);
      $stmt_one -> fetch();
	  $user_id = $result_one;
      $stmt_one -> close();
   }

// initialize and execute query 
$stmt = $conn->stmt_init();

$result = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_id = '$user_id'");
$row = mysqli_fetch_array($result);

$user_id = $row[0];
//$user_name = $row[1];
$image_name = $row[2]; 
$first_name = $row[3];
$last_name = $row[4];
$university = $row[5];
$services = $row[6];
$bio = $row[7];
$updated = $row[8];  
$created = $row[9];  


//If form has been submitted, update record
if (isset($_POST ['update'])) {
  // prepare update query
  $sql = 'UPDATE user_profile SET first_name = ?, last_name = ?, university = ?, services = ?, bio = ? WHERE user_id = ?';
  if ($stmt->prepare($sql)) {
	$stmt->bind_param('sssssi', $_POST['first_name'], $_POST['last_name'], $_POST['university'], $_POST['services'], $_POST['bio'], $_POST['user_id']);
	$done = $stmt->execute();
	
	//Update variables and query and populate HTML form
	$result = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_id = $user_id");
	$row = mysqli_fetch_array($result);
	$user_id = $row[0];
	//$user_name = $row[1];
	$image_name = $row[2]; 
	$first_name = $row[3];
	$last_name = $row[4];
	$university = $row[5];
	$services = $row[6];
	$bio = $row[7];
	$updated = $row[8];  
	$created = $row[9]; 
  }
}

// redirect if $_GET['article_id'] not defined
if ($done || !isset($_GET['user_id'])) { 
	// header('Location: http://localhost/Hoot/site/user_profile.php');
}

// store error message if query fails
if (isset($stmt) && !$OK && !$done) {
  $error = $stmt->error;
}

//Upload 1 and 2 call Upload class to securely upload images:
//Code checks file for security and returns filename without spaces.
//Finally as the file is successfully uploaded to the server it stores a record
//of it on the database so that it can be called. File name is placed in a prepared statement 
//even though it would be difficult to inject SQL with the file renaming convention. 

//Upload 1: Upload Profile Image
$uploadResult = false;

$max = 10485760;
if (isset($_POST['upload_portfolio'])) {
  $destination = 'C:/wamp/www/ShareShare/images/profile_image/';
  
  require_once('../includes/classes/Upload.php');
  try {
	$upload = new Upload($destination);
	$upload->setMaxSize($max);
	$upload->move();
	$result = $upload->getMessages();
	$uploadResult = $upload->getUploadOutcome();
	$initialImageName = $result[0]; 

		if($uploadResult==true) {
		if (!($stmt = $conn->prepare("UPDATE user_profile SET image_name=? WHERE user_name='$user_name'"))) {
			echo "Prepare failed: (" . $conn->errno . ") " . $conn->error;
		}
				
		if (!$stmt->bind_param('s', $initialImageName)) {
			echo "Binding parameters failed: (" . $stmt->errno . ") " . $stmt->error;
		}
		if (!$stmt->execute()) {
			echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
		}
		//echo "Database Command Excecuted";
		header("Location: update_profile.php"); /* Redirect browser */
		exit();	
	}
		
	header('Location: update_profile.php');
  } catch (Exception $e) {
	echo $e->getMessage();
  }
}

//Upload 2: Upload Portfolio Images
$uploadResult = false;

$max = 10485760;
if (isset($_POST['upload'])) {
  $destination = 'C:/wamp/www/ShareShare/images/user_images/';
  
  require_once('../includes/classes/Upload.php');
  try {
	$upload = new Upload($destination);
	$upload->setMaxSize($max);
	$upload->move();
	$result_four = $upload->getMessages();
	$uploadResult = $upload->getUploadOutcome();
	$initialImageName = $result_four[0]; 
	$imageTimeStamp = time();

			if($uploadResult==true) {
			if (!($stmt = $conn->prepare("INSERT INTO user_image (filename, time_stamp, user_name) VALUES (?, '$imageTimeStamp', '$user_name')"))) {
				echo "Prepare failed: (" . $conn->errno . ") " . $conn->error;
			}
			if (!$stmt->bind_param('s', $initialImageName)) {
				echo "Binding parameters failed: (" . $stmt->errno . ") " . $stmt->error;
			}
			if (!$stmt->execute()) {
				echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
			}
			//echo "Database Command Executed";
			header("Location: update_profile.php"); 
			exit();	
		}
			
		header('Location: update_profile.php');
  } catch (Exception $e) {
	echo $e->getMessage();
  }
}
	
?>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>Hootwork</title>
	<meta name="description" content=".">
	<meta name="author" content="">

	<!-- SlidesJS Required (if responsive): Sets the page width to the device width. -->
	<meta name="viewport" content="width=device-width">
	<!-- End SlidesJS Required -->

	<!-- CSS -->
	<link href="../../style/Xbootstrap.css" rel="stylesheet">
	<link href="../../style/xstyle.css" rel="stylesheet">
	<link href="../../style/Xuser.css" rel="stylesheet"> 	
	<link href="../../style/Xcover.css" rel="stylesheet"> 
  
	<!-- 
	<!-- Just for debugging purposes. -->
	<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->

  <!-- SlidesJS Optional: If you'd like to use this design -->

</head>

<body>
<?php

		if (isset($result_three)) {
			echo ($result_three[0]);		
		} else {
			//echo "File Uploaded TEST <br />";
		}

		if (isset($result_four)) {
			echo ($result_four[0]);		
		} else {
		}
?>

	<div class="site-wrapper">

	<div class="content">
		<div class="container-non-responsive">

				<h2>Update User Profile</h2>
				<p><a href="user_profile.php">User Profile</a></p>
				<?php 

				if($user_id == 0) { ?>
				<p class="warning">Invalid request: record does not exist.</p>
				<?php } else { ?>

					<form id="form1" method="post" action="">
						<div id = "update-user">		
							<p>
								<label for="title">First Name:</label>
								<input name="first_name" type="text" class="widebox" id="first_name" value="<?php echo htmlentities($first_name, ENT_COMPAT, 'utf-8'); ?>">
							</p>

							<p>
								<label for="title">Last Name:</label>
								<input name="last_name" type="text" class="widebox" id="last_name" value="<?php echo htmlentities($last_name, ENT_COMPAT, 'utf-8'); ?>">
							</p>

							<p>
								<label for="article">University:</label>
								<input name="university" class="widebox" id="university" value="<?php echo htmlentities($university, ENT_COMPAT, 'utf-8'); ?>">
							</p>
						</div>	
						
						<div id = "update-services">
							<p>
								<label for="article">Services:</label>
								<textarea name="services" cols="60" rows="8" class="widebox" id="services"><?php echo htmlentities($services, ENT_COMPAT, 'utf-8'); ?></textarea>
							</p>
						</div>	

						<div id = "update-bio">	
							<p>
								<label for="article">Bio:</label>
								<textarea name="bio" cols="60" rows="8" class="widebox" id="bio"><?php echo htmlentities($bio, ENT_COMPAT, 'utf-8'); ?></textarea>
							</p>
						</div>
						
						<div id = "update-save">	
							<p>
								<input type="submit" name="update" value="Save Changes" id="update">
								<input name="user_id" type="hidden" value="<?php echo $user_id; ?>">
							</p>
						</div>
							
					</form>
				<?php } ?>
								
			</div>
		</div>
				
	<!-- User Image -->
	<form action="" method="post" enctype="multipart/form-data" id="uploadImage">
		<div id = "upload-image">
			<p>
				<label for="image">Upload Portfolio Image:</label>
				<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
				<input type="file" name="image" id="image">
			</p>
			<p>
				<input type="submit" name="upload" id="upload" value="Upload">
			</p>
		</div>	
	</form>
		<!-- Portfolio Image Upload -->		
		<form action="" method="post" enctype="multipart/form-data" id="uploadImage">
		<div id = "upload-profile-image">
			<p>
				<label for="image">Upload User Image:</label>
				<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
				<input type="file" name="image" id="image">
			</p>
			<p>
				<input type="submit" name="upload_portfolio" id="upload_portfolio" value="Upload">
			</p>
		</div>	
	</form>

	

	<!-- Bootstrap core JavaScript-->
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/docs.min.js"></script>


</div>

</body>
</html>