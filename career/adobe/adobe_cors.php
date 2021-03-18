<?php
//header('Content-Type: application/json');

//GET Request 
if (isset($_GET['name'])) {
	//$name = $_GET['name'];
	$name = htmlspecialchars($_GET['name'], ENT_QUOTES, 'UTF-8');
	
    echo $name;
	
}

//POST Request
//CORS
if (isset($_SERVER["HTTP_ORIGIN"]) === true && isset($_POST["name"]) && (!empty($_POST["name"]))) {
	$origin = $_SERVER["HTTP_ORIGIN"];
	$allowed_origins = array(
		"http://localhost/development/career/adobe/adobe_cors.html",
		"http://localhost/development/career/adobe/"
	);
	if (in_array($origin, $allowed_origins, true) === true) {
		header('Access-Control-Allow-Origin: ' . $origin);
		header('Access-Control-Allow-Credentials: true');
		header('Access-Control-Allow-Methods: POST');
		header('Access-Control-Allow-Headers: Content-Type');
	}
	if ($_SERVER["REQUEST_METHOD"] === "OPTIONS") {
		exit; 
	}
	
	$name 		= htmlspecialchars($_POST['name'], ENT_QUOTES, 'UTF-8');
	$location 	= htmlspecialchars($_POST['location'], ENT_QUOTES, 'UTF-8');
	
	echo $name;
}

/*
if () {
	$name 		= htmlspecialchars($_POST['name'], ENT_QUOTES, 'UTF-8');
	$location 	= htmlspecialchars($_POST['location'], ENT_QUOTES, 'UTF-8');
	
	echo $name;

}

*/
	
?>