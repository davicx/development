<?php
if(isset($_POST['name'], $_POST['email'], $_POST['message'])) {
	//print_r($_POST);
	//response
	echo "Your name is " . $_POST['name'];
	echo "<br />";
	echo "Your email is " . $_POST['email'];
	echo "<br />";
	echo "Your message is " . $_POST['message'];
	echo "<br />";
	

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