<?php
require_once('includes/connection.inc.php');
$conn = dbConnect('read');

?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>

	<body>
	
	<?php	
	$result = mysqli_query($conn,"SELECT * FROM posts");

	while($row = mysqli_fetch_array($result)) {
		echo $row['url'];
	}
	//echo $row['url'];
	//	$url = $row['url'];
	//	echo "<br>";
	//	echo ($url);
	//	echo "<br>";
	//		echo "From time to \"time\"" . "<br />";
			echo "<iframe width=\"560\"  height=\"315\" src=\"/$url\" frameborder=\"0\" allowfullscreen></iframe>";
	//		echo "<br />";	
	//}
		?>
		
	<iframe width="560" height="315" src="//www.youtube.com/embed/BCCypss2HDc" frameborder="0" allowfullscreen></iframe>


	</body>
</html>
