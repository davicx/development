<?php
include 'functions/classes/File.php';
include 'functions/includes/connect.php';
//include 'functions/function.php';
	$file_root = "square_1";
	if (isset($_GET['varname']) && (!empty($_GET['varname']))) {
		$file_root = $_GET['varname'];
		echo $file_root;
	}

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
			//Get all Folders
			
			$square_id = 1;
			
			//so this is displaying all the files then if you click vasquezd $file_root becomes vasquezd or whatever the file name is
			
			$result = mysqli_query($conn,"SELECT * FROM folders WHERE square_id = '$square_id' AND file_root = '$file_root'");
			while($row = mysqli_fetch_array($result)) { 
				$path = $row['file_location'];
				$file_name = $row['file_name'];
				$folder_name = $row['folder_name'];
			?>
			

					<div class = "file"> 
						<div class = "file-image float" >
							<a href="#"><img src="files/<?php echo $row['image_name']; ?>" alt="file" style="height:46px"></a> 
						</div>	
						<p class = "file-name float"><?php echo $row['file_name'] ?></p>
					
						<p class = "folder-link"><a href="index.php?varname=<?php echo $folder_name; ?>"><img src="files/<?php echo $row['image_name']; ?>" style="height:46px" border="0"></a></p>
					</div>

			<?php } ?>

			<ul id="sortable1" class="connectedSortable">
			<?php
			
			//Get all Files
			$result = mysqli_query($conn,"SELECT * FROM files WHERE square_id = '$square_id' AND file_root = '$file_root'");
 		
			while($row = mysqli_fetch_array($result)) { 
				$file_id = ($row['file_id']);					
				$individual_file = new File($file_id);
				$individual_file->getFileInfo($file_id);
			
				$path = $individual_file->fileLocation;
				$file_name = $individual_file->fileName;
			?>

					<div class = "file"> 
						 <div class = "file-image float" >
							 <a href="#"><img src="files/<?php echo ($individual_file->imageName); ?>" alt="file" style="height:46px"></a> 
						 </div>	
						 <p class = "file-name float"><?php echo $file_name; ?></p>		 
						<p class = "download-button"><?php	echo '<td><a href="download.php?file='.urlencode($path).'&file_name='.$file_name.'">Download</a></td>'; ?></p>
					</div>
			
			<?php } ?>
	
		</div>	
		
	</div>
<!--	
	<ul id="sortable1" class="connectedSortable">
		<li class="ui-state-default">Item 1</li>
		<li class="ui-state-default">Item 2</li>
		<li class="ui-state-default">Item 3</li>
		<li class="ui-state-default">Item 4</li>
		<li class="ui-state-default">Item 5</li>
	</ul>
	<ul id="sortable2" class="connectedSortable">
		<li class="ui-state-highlight" >Item 1</li>
		<li class="ui-state-highlight" >Item 2</li>
		<li class="ui-state-highlight" >Item 3</li>
		<li class="ui-state-highlight" >Item 4</li>
		<li class="ui-state-highlight" >Item 5</li>
	</ul>	
-->
    </body>
</html>