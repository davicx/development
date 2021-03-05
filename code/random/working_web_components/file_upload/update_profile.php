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

if (isset($_POST['upload'])) {
	$destination = 'C:/wamp/www/development/file_upload/uploads/';

	require_once('class/Upload.php');
	try {
		$upload = new Upload($destination);
		$upload->setMaxSize($max);
		$originalFileName = $upload->getName();
		$upload->move();
		$upload_result = $upload->getMessages();
		$uploadResult = $upload->getUploadOutcome(); 
		$finalImageName = $upload_result[0]; 
		$imageTimeStamp = time();
		
		echo "<br />";
		echo $originalFileName;
		echo "<br />";
		echo $finalImageName;
		echo "<br />";
		echo $imageTimeStamp;
	} catch (Exception $e) {
		echo $e->getMessage();
	}
}


?>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>Shareshare</title>
	<meta name="description" content=".">
	<meta name="author" content="">
</head>
	<body>

					
		<!-- User Image -->
		<form action="" method="post" enctype="multipart/form-data" id="uploadImage">
			<p>Upload Portfolio Image:</p>
			<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
			<input type="file" name="image" id="image">
			<input type="submit" name="upload" id="upload" value="Upload">
		</form>
		
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	</body>
</html>