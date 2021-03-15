<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}
</style>
</head>
<body>  

<?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $websiteErr = "";
$email = $gender = $comment = $website = "";
$name = "empty";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if (empty($_POST["name"])) {
			$nameErr = "Name is required";
		} else {
			$name = test_input($_POST["name"]);
			if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
			  $nameErr = "Only letters and white space allowed";
		}
	} 
	
		$servername = "localhost";
		$username = "root";
		$password = "";
		$dbname = "shareshare";

		// Create connection
		$conn = new mysqli($servername, $username, $password, $dbname);
 
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		}

		$insert = $conn->prepare("INSERT INTO temp (first_name) VALUES (?) ");
		$insert->bind_param('s', $name);
		if ($insert->execute()) {
			echo "worked";
		} else {
			echo "Can not be processed";
		}
		$conn->close();
		
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>

 
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
  Name: <input type="text" name="name" value="<?php echo $name;?>">
  <span class="error">* <?php echo $nameErr;?></span>
  <br><br>
 
  <input type="submit" name="submit" value="Submit">  
</form>

<?php
echo "<h2>Your Input:</h2>";
echo $name;
echo "<br>";

?>

</body>
</html>