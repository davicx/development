<?php
include 'includes/connect.php';


class IndividualPost{
	var $from = "";
	var $to = "";
	
	public function __construct() {
	//	$this->post_id = $post_id;
	//	$this->from = $from;
	//	$this->to = $to;
	//	$this->comment = $comment;
	//	$this->created = $created;
	//	$this->updated = $updated;		
	}	
	
	public function getFrom() {
		echo "Post is from ";
		echo $this->from;
	} 
}
	$postone = new IndividualPost();
	$posttwo = new IndividualPost();
	
	$postone->from = "vasquezd";
	$postone->to= "james";	
	
	$postone->getFrom();

?>

<?php 

	$person = new Person("David");
	$person->name = "David";
	
	//$person->SayHello();
	/*
	$sql = "INSERT INTO `posts` (`post_from`, `post_to`, `post_comment`, `created`, `updated`) VALUES ('vasquezdavid', 'james', 'hello again', CURRENT_TIMESTAMP, CURRENT_TIME())";
	
	if (!mysqli_query($conn,$sql)) {
	  die('Error: ' . mysqli_error($conn));
	}
	echo "1 record added";
	*/
/*
	$result = mysqli_query($conn,"SELECT * FROM posts WHERE post_from='$post_from'");


	while($row = mysqli_fetch_array($result)) {

	  echo $row['post_from'] . "<br />";
	  echo $row['post_to'] . "<br />";
	  echo $row['post_comment'] . "<br />";
	  echo $row['created'] . "<br />";
	  echo "<br />";

	}

*/
			
?>

