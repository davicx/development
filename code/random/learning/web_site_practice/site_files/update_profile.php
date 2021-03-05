<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
include '../functions/function.php';
require_once('../functions/includes/session_timeout.inc.php');


//Initialize flags
$OK = false;
$done = false;

//Create local variable with user name 
$user_name = $_SESSION['varname'];
$user_id = 1;


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


	
?>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>Dashboard</title>
	<meta name="description" content=".">
	<meta name="author" content="">

	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="../images/favicon.ico" />
	
	<!-- CSS -->
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" href="../css/report.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">

	<!-- JS -->
	<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
    <script src="../js/main.js"></script>
   
	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="/resources/demos/style.css">
	
</head>

<body>

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


	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
</div>

</body>
</html>