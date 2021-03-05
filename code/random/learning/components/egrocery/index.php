<?php 
require_once('functions/connection.inc.php');	
$conn = dbConnect('read');

	//Posts- Get posts, comments and friends
	$sql = "SELECT * FROM products WHERE item = 'Coffee - Canned' ORDER BY name DESC";
	$result = $conn->query($sql) or die(mysqli_error());

?>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> Market </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/main.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
    <body>
	
	
	<div id = "fixed-header-background">

	</div>

	<div id = "site-wrapper">
		<!-- Header -->
		<header>
			<nav>
			</nav>	
		</header>
		
		<!-- Main Body  -->	
		
		<?php 
		//mysqli_query($conn,"DELETE FROM products WHERE name='null'");
		
		$count =0;
		while($row = $result->fetch_assoc()) { ?>  
					<p><b>Product: </b><?php echo $row['name']; ?></p>
					<p><b>Price: </b><?php echo $row['price']; ?></p>
					<p><b>Image URL: </b><?php echo $row['image_name']; ?></p>
		<?php
			echo ($count);
			echo "<br /><br />";
			$count = $count +1;
		} ?>	

		

	</div>
	
		<!-- Footer -->
		<footer>
		
		</footer>

    </body>
</html>
