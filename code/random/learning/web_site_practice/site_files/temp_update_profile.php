<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
include '../functions/function.php';
require_once('../functions/includes/session_timeout.inc.php');


//Initialize flags
$OK = false;
$done = false;

//Create local variable with user name 
$user_name = "vasquezd";
$user_id = 1;

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
		header("Location: update_profile.php"); 
		exit();	
	}
		
	header('Location: update_profile.php');
  } catch (Exception $e) {
	echo $e->getMessage();
  }


} else {
	echo "false";
	
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



	
</head>

<body>


	
	<!-- User Image -->
	<form action="" method="post" enctype="multipart/form-data" id="uploadImage">
		<div id = "upload-image">
			<p>
				<label for="image">Change User Image:</label>
				<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
				<input type="file" name="image" id="image">
			</p>
			<p>
				<input type="submit" name="upload" id="upload" value="Upload">
			</p>
		</div>	
	</form>


</body>
</html>