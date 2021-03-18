<?php
//header('Content-Type: application/json');

//USER ARRAY 
if (isset($_GET["users_array"]) && (!empty($_GET["users_array"]))) {
	
	
	//Return Array 
	$users = array("Frodo"=>25, "Bilbo"=>27, "David"=>23);

	$myJSON = json_encode($users);

	echo $myJSON;
	
 

}

//USER OBJECT  
if (isset($_GET["users_object"]) && (!empty($_GET["users_object"]))) {
	
	//Return Array 
	$user_one = new stdClass();
	$user_one->name = "David";
	$user_one->last_name = "Vasquez";
	$user_one->city = "Victoria";

	$user_two = new stdClass();
	$user_two->name = "Frodo";
	$user_two->last_name = "Baggins";
	$user_two->city = "Shire";
	
	//$users_array = ($user_one, $user_two);
	$users_array = array();
	array_push($users_array, $user_one);
	array_push($users_array, $user_two);
	 

	$usersJSON = json_encode($users_array);

	echo $usersJSON;


}



//GET Request 
if (isset($_GET['name'])) {
	//$name = $_GET['name'];
	$name = htmlspecialchars($_GET['name'], ENT_QUOTES, 'UTF-8');
	
    echo $name;
	
}

//POST Request
if (isset($_POST["name"]) && (!empty($_POST["name"]))) {
	$name 		= htmlspecialchars($_POST['name'], ENT_QUOTES, 'UTF-8');
	$location 	= htmlspecialchars($_POST['location'], ENT_QUOTES, 'UTF-8');
	
	echo $name;

}

	
?>