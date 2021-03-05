<?php 
	if (isset($_POST["nameToPHP"]) && !empty($_POST["nameToPHP"])) {

		// Create connection
		$conn=mysqli_connect("localhost","root","","person");
		// Check connection
		if (mysqli_connect_errno()) {
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
			$result = mysqli_query($conn,"SELECT * FROM persons");

			while($row = mysqli_fetch_array($result)) {
			  echo $row['name'];

			}
			
		}else{  
			echo "Not set";
		}
	

		if (isset($_POST["testname"]) && !empty($_POST["testname"])) {
			echo "hello world";
		} else{  
			echo "Not set";
		}
?>