<?php 
include 'includes/classes/Posts.php';
$conn = mysqli_connect("localhost","root","","dashboard");

// Check connection
if (mysqli_connect_errno()) {
  //echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

		$post1 = new Posts(1);
		$post2 = new Posts(2);
		$post3 = new Posts(3);
		$post4 = new Posts(4);
		$post5 = new Posts(5);
		$post6 = new Posts(6);
		
		$post1->liason_date_month = "August";
		$post2->liason_date_month = "September";
		$post3->liason_date_month = "August";
		$post4->liason_date_month = "May";
		$post5->liason_date_month = "June";
		$post6->liason_date_month = "June";
		
		
		$numberOfObjects = 6;
		
		for ($x=1; $x<=6; $x++) {
			//echo "The number is: $x <br>";	
			echo  "post" . $x->liason_date_month;
		
		}
	
		/*
	
		$postOne = new Posts(1);
		$postTwo = new Posts(2);
		$postThree = new Posts(3);
		$postFour = new Posts(4);
		$postFive = new Posts(5);
		$postSix = new Posts(5);
		
		$postOne->liason_date_month = "August";
		$postTwo->liason_date_month = "September";
		$postThree->liason_date_month = "August";
		$postFour->liason_date_month = "May";
		$postFive->liason_date_month = "June";
		$postSix->liason_date_month = "June";
		
		echo $postOne->liason_date_month;
		echo $postTwo->liason_date_month;
		echo $postThree->liason_date_month;
		echo $postFour->liason_date_month;
		echo $postFive->liason_date_month;
		echo $postSix->liason_date_month;
		echo "<br />";
		*/
		
		function returnUniqueValue() {
		/*
		   	echo $postOne->liason_date_month;
			echo $postTwo->liason_date_month;
			echo $postThree->liason_date_month;
			echo $postFour->liason_date_month;
			echo $postFive->liason_date_month;
			echo $postSix->liason_date_month;
			*/
		}
		
		returnUniqueValue();

/*
	$sql = "SELECT date FROM liason_connection";
	$result = $conn->query($sql) or die(mysqli_error());
	
		while($row=$result->fetch_array()) {
			$date= $row['date'];
			$timestamp = strtotime($date);

			$monthNumber = (date("m",$timestamp));
		//	echo "<br />";
		//	echo $monthNumber;
			//Get current month from timestamp and convert to String month
			$dateObj   = DateTime::createFromFormat('!m', $monthNumber);
			$monthName = $dateObj->format('F'); // March
			
			
			echo "<br />";
			echo $monthName;
			echo "<br />";
			
			//echo date('Y', $timestamp);
			//echo "<br />";
		}

		*/
		
		

?>