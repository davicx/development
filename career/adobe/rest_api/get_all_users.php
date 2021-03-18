<?php
header('Content-Type: application/json');

$user = new stdClass();
$user->name = "David";
$user->last_name = "Vasquez";
$user->city = "Victoria";

$myJSON = json_encode($user);

echo $myJSON;


/*

require_once('../../../../functions/rest_header.php');
require_once('../../../../functions/classes/User.php');

//http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user/get_user.php?user_key=david&user_name=vasquezd
//http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user/get_user.php?user_key=kristen&user_name=kristen
//http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user/get_user.php?user_key=matt&user_name=matt


//USER REQUEST 
$result = mysqli_query($conn,"SELECT * FROM user_profile WHERE user_id = '$user_id'");
$user_id_array = array();
$users = array();

while($row = mysqli_fetch_array($result)) {		
	$temp_user_array = array();
	$user_id = $row['user_id'];
	$user_name = $row['user_name'];
	$image_name = $row['image_name'];
	
	$temp_user_array['id'] = $user_id; 
	$temp_user_array['name'] = $user_name;
	$temp_user_array['user_image'] = $image_name;
	
	array_push($users, $temp_user_array);
	array_push($user_id_array, $user_id);
}


$users_array['users'] = $users;
$users_array = json_encode($users_array);

echo $users_array;
 
*/
























?>