<?php
if(isset($_POST['name'], $_POST['email'], $_POST['message'])) {
	//print_r($_POST);
	//response
	echo "Your name is " . $_POST['name'];

} else {
	echo "not set";
}




//$id = $_SESSION['userid'];
//$title = $_POST['title'];
//$summary = $_POST['summary'];
//$details = $_POST['details'];

//$query = mysql_query("INSERT INTO notes (id, title, summary, details) VALUES ('$id', '$title','$summary','$details')");

//echo $title . $summary . $details;



?>