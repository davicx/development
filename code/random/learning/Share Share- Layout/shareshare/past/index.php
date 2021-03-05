<?php
require_once('includes/connection.inc.php');
$conn = dbConnect('read');

?>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />	
		<title>Shared</title>	

	</head>

	<body>
		<div id = "navigation">
				<h2> Profile </h2>
		</div>	
			
			<div id = "navigation">
				<a href="#home">About Us</a>
				<a href="#news">Clothing</a>
				<a href="#contact">Accessories</a>
				<a href="#about">Images</a>
		</div>

			<div class="background">
				<div class="transbox">
					<?php	
					$result = mysqli_query($conn,"SELECT * FROM posts");

					while($row = mysqli_fetch_array($result)) {
							echo "<iframe width=\"560\"  height=\"315\" src=\"/$url\" frameborder=\"0\" allowfullscreen></iframe>" . "<br />";
						?>
						<iframe width="560" height="315" src="//www.youtube.com/embed/BCCypss2HDc" frameborder="0" allowfullscreen></iframe>
				</div>	
			</div>

	</body>
</html>
