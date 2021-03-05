<?php
//Initialize flags
$OK = false;
$done = false;

// store error message if query fails
if (isset($stmt) && !$OK && !$done) {
  $error = $stmt->error;
}

$uploadResult = false;
$max = 10485760;

echo $uploadResult;
echo "<br />";
echo $max;

if (isset($_POST['upload'])) {
  $destination = 'C:/wamp/www/development/file_upload/uploads/';
  
  require_once('class/Upload.php');
  try {
	$upload = new Upload($destination);
	$upload->setMaxSize($max);
	$upload->move();
	$result_four = $upload->getMessages();
	$uploadResult = $upload->getUploadOutcome();
	$initialImageName = $result_four[0]; 
	$imageTimeStamp = time();

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
	<title>File Upload</title>
	<meta name="description" content=".">
	<meta name="author" content="">


</head>
	<body>
			
		<!-- User Image -->
		<form action="" method="post" enctype="multipart/form-data" id="uploadImage">
				<label for="image">Upload Portfolio Image:</label>
				<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
				<input type="file" name="image" id="image">

				<input type="submit" name="upload" id="upload" value="Upload">
		</form>
		
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>


	</body>
</html>