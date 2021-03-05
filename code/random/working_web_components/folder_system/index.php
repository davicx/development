

<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>jQuery UI Droppable - Accept</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		<link rel="stylesheet" href="/resources/demos/style.css">
		<script src="js/main.js"></script>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>

		<section id = "file-system">	
			<!-- Boxes to Drop -->
			<div id = "file_1" class="draggable file">
				<p>File 1</p>
			</div>

			<div id = "file_2" class="draggable file">
				<p>File 2</p>
			</div>

			
			<!-- Drop Areas -->
			<div id="folder_1" class="draggable droppable folder">
				<p>Folder 1</p>
			</div>
		 
			<div id="folder_2" class="draggable droppable folder">
				<p>Folder 2</p>
			</div>	
		</section>
	
	</body>
</html>