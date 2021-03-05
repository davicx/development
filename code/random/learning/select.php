<?php	
global $conn; 
//WAMP Server
$conn = mysqli_connect("localhost","root","","sharespace");




	//Get user id from database
	$username = "vasquezn";
	
	if ($result_id = mysqli_prepare($conn, "SELECT user_id FROM user_login WHERE user_name=?")) {
      $result_id -> bind_param("s", $username);
      $result_id -> execute();
      $result_id -> bind_result($result_user_id);
      $result_id -> fetch();
	  $user_id = $result_user_id;
      $result_id -> close();
	  echo $user_id; 
	  echo "<br />";

	} 





/*

	//Get user id from database
	$user_name = "vasquezd";
	
	if ($result = mysqli_prepare($conn, "SELECT user_name FROM user_profile WHERE user_name=?")) {
      $result -> bind_param("s", $user_name);
      $result -> execute();
      $result -> bind_result($result_user_id);
      $result -> fetch();
	  $user_id = $result_user_id;
      $result -> close();
	  echo $user_id; 
	  echo "<br />";

	  
		if(!empty($user_id)) {
			echo "user name found ";
		} else {
			echo "user name NOT found";			
		}
    
	} else {
		echo "fail";
	}
	
	/*	
	
$results = $mysqli->query("SELECT ANNOUNCE_NUMBER,ANNOUNCEMENTS,ANNOUNCE_TYPE,POST_DATE FROM home WHERE ANNOUNCE_NUMBER NOT LIKE $excludewelcome AND ANNOUNCE_NUMBER NOT LIKE $excludenews ORDER BY ANNOUNCE_NUMBER DESC LIMIT $position, $items_per_group");
if ($results) { 

    if($results->num_rows === 0)
    {
        echo 'No results';
    }
    else
    {
*/
	
?>