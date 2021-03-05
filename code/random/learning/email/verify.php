
<!DOCTYPE html>
<html>
    <head>
        <title>ShareSpace</title>
        <link rel="stylesheet" href="css/uikit.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Karla%7CMontserrat">
		<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">		
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="js/main.js"></script>
    </head>
    <body>

	<?php
	/*		
		if( $_GET["name"] ) {
			$name = $_GET['name'];
	
			echo "Welcome ". $name . "<br />";
		}
*/
	
		if( $_GET["name"] || $_GET["age"] ) {
			$name = $_GET['name'];
			$age = $_GET['age'];
			$squareID = $_GET['squareid'];
			echo "Welcome ". $name . "<br />";
			echo "You are ". $age . " years old.";
			echo "<br /> Square ID ";
			echo $squareID;
			
		}

	?> 
		
    </body>
</html>