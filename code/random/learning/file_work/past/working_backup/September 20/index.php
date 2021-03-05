<?php
//include 'functions/includes/classes/file.php';
include 'functions/includes/connect.php';
//include 'functions/function.php';
?>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<!-- JS -->
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/main.js"></script>

    <body>
	<div id = "site-wrapper">

	<p> Files </p>
	<!--<a href="files/mayday.docx">Mayday</a>-->

		<!-- Files Header -->
		<div class = "file-header"> 
			 <h4 class = "file-image-header float" >Image</h4>
			 <h4 class = "file-name-header float">File Name</h4>
			 <h4 class = "file-modified-header float">Modified </h4>	
			 <h4 class = "file-download-header float">Download</h4>	 
		</div>
		<div class = "clear"></div>
		
		<!-- All User Files -->
		<div id = "user-files">
			<?php
			$result = mysqli_query($conn,"SELECT * FROM files WHERE user_id = '1'");

			while($row = mysqli_fetch_array($result)) { 
			?>
				<div class = "file"> 
					 <div class = "file-image float" >
						 <a href="#"><img src="files/<?php echo $row['image_name']; ?>" alt="file" style="height:46px"></a> 
					 </div>	
					 <p class = "file-name float"><?php echo $row['file_name'] ?></p>
				</div>
			<?php 
			
					$local_file = 'C:/wamp/www/file_work/files/mayday.docx';
					$download_file = 'May Test Day.docx';
					$name = "submit";
						
			?>
			<!-- Send download information to php function -->
			<form class = "download-button" action="" method="post">
				<input type="submit" name="<?php echo $name;?>" value="Download <?php echo $row['file_id'];;?>">
				<input type="hidden" name="local-file" value="<?php echo $local_file;?>" />
				<input type="hidden" name="download-file" value="<?php echo $download_file;?>" />
			</form>
			
			
			<?php } ?>
			<!-- Set Local file and download name -->
	

			<?php 
			//instead of submit use file id then query server for local-file and download-file
			//$nameTest = "submit";
			if (isset($_POST[$nameTest])) {
				$local_file = $_POST["local-file"];
				$download_file = $_POST["download-file"];
				
				downloadFile($local_file, $download_file);
			}
				
				function downloadFile($local_file, $download_file) {
				// set the download rate limit (=> 20,5 kb/s)
				$download_rate = 20.5;
				if(file_exists($local_file) && is_file($local_file)) {
					header('Cache-control: private');
					header('Content-Type: application/octet-stream');
					header('Content-Length: '.filesize($local_file));
					//header('Content-Disposition: filename='.$download_file);
					header('Content-Disposition: attachment; filename="' . str_replace('"', '\\"', ($mask ? $mask : basename($download_file))) . '"');
					flush();
					$file = fopen($local_file, "r");
					while(!feof($file))
					{
						// send the current file part to the browser
						print fread($file, round($download_rate * 1024));
						// flush the content to the browser
						flush();
						// sleep one second
						sleep(.1);
					}
					fclose($file);}
				else {
					die('Error: The file '.$local_file.' does not exist!');
				}
			}
			?>
		
			
		</div>	
	</div>
    </body>
</html>