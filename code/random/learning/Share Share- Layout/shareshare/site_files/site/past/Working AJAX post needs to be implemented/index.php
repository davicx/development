<?php
include_once('connection.inc.php');
	$conn = dbConnect('write');
?>
<html>
<head><title>Insert Data Into MySQL: jQuery + AJAX + PHP</title></head>
	<body>
	 
		<form id="myForm" action="userInfo.php" method="post">
			Age : <input type="text" name="name" /><br />
			Name: <input type="text" name="age" /><br />
			<!--<input type="submit" name="insert" value="Insert New Entry" id="insert"> -->
			<button id="sub" name="insert">Save</button>
		</form>
		 
		<span id="result"></span>
		
		<?php
		$result = mysqli_query($conn,"SELECT * FROM Posts");

		while($row = mysqli_fetch_array($result))
		  {
		  echo $row['post_to'] . " <br />Caption: " . $row['caption'];
		  echo "<br>";
		  }
		  ?>
					
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

		<script src="my_script.js" type="text/javascript"></script>
	</body>
</html>