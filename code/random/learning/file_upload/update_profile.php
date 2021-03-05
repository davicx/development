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
  $destination = 'C:/wamp/www/file_upload/uploads/';
  
  require_once('class/Upload.php');
  try {
	$upload = new Upload($destination);
	$upload->setMaxSize($max);

	$upload->move();
	$result_four = $upload->getMessages();
	$uploadResult = $upload->getUploadOutcome();
	$initialImageName = $result_four[0]; 
	
	$imageTimeStamp = time();
	echo $imageTimeStamp;
	echo "<br />";
	echo $initialImageName;
	echo "<br />";
	
	$nameArray = $upload->_filenames;
	echo $nameArray[0];
	echo "<br />";
	echo $nameArray[1];
	
	
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


</head>
	<body>
		<br /> <br />
		<!-- User Image -->
		<form action="" method="post" enctype="multipart/form-data" id="uploadImage">
			<div id = "upload-image">
				<label for="image">Upload Portfolio Image:</label>
				<input type="hidden" name="MAX_FILE_SIZE" value="<?php echo $max; ?>">
				<input type="file" name="image" id="image">
				
				<input type="submit" name="upload" id="upload" value="Upload">

			</div>	
		</form>
		
		
		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>


	</body>
</html>