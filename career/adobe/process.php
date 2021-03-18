<?php

//GET Request 
if (isset($_GET['name'])) {
	//$name = $_GET['name'];
	$name = htmlspecialchars($_GET['name'], ENT_QUOTES, 'UTF-8');
	echo $name;
	


}

//echo htmlspecialchars($string, ENT_QUOTES, 'UTF-8');

//POST Request
if (isset($_POST["name"]) && (!empty($_POST["name"]))) {
	$name 		= htmlspecialchars($_GET['name'], ENT_QUOTES, 'UTF-8');
	$location 	= htmlspecialchars($_GET['location'], ENT_QUOTES, 'UTF-8');
	
	echo $name;

 
}

	
?>