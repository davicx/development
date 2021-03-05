<?php
include 'functions/classes/File.php';
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
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/main.js"></script>

	<!--Sortable -->	
	<!--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">-->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

	
</head>	
	
 <body>


	<div id = "site-wrapper">

	<p> Files </p>

	
	
			<?php
			
				$file_id = 43;		
				$new_path = "square_1";
				$individual_file = new File($file_id);
				$individual_file->getFileInfo($file_id);
			
				$path = $individual_file->fileLocation;
				$file_name = $individual_file->fileName;
				$individual_file->copyFile($file_id, $new_path);
		
		
			?>
	


    </body>
</html>





