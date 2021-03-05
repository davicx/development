<?php 

//CONNECTION
$host		= "oniddb.cws.oregonstate.edu";
$user_name	= "vasquezd-db";
$password 	= "gCtLRbXMWWS2SwNg";
$dbname 	= "vasquezd-db";

$conn = mysqli_connect($host, $user_name, $password , $dbname);

//Check connection
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?>
<!DOCTYPE html>
<html>
    <head>
		<!-- Meta Tags -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="" />
		<title> Template </title>
		
		<!-- CSS -->
		<link rel="stylesheet" href="css/external_css/normalize.css">
		<link id="data-uikit-theme" rel="stylesheet" href="css/uikit.gradient.css">	
		<link rel="stylesheet" href="css/style.css">	
		
		<!-- Javascript -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../js/vendor/modernizr-2.8.3.min.js"></script>
		<script src="../js/vendor/uikit.min.js"></script>

    </head>
		
		<body id = "">
		 <?php 
			$title 		= $_POST["title"]; 
			$name  		= $_POST["name"]; 
			$story 		= $_POST["story"]; 
			$word_count = str_word_count($story);
	
			//STEP 1: Insert into posts table 	
			$stmt = $conn->prepare("INSERT INTO story(title, name, story, words, created ) 
				VALUES (?,?,?,?, NOW())");
			$stmt->bind_param("sssi", $title, $name, $story, $word_count);

			if ($stmt->execute()) {
				echo "New record created successfully it was " . str_word_count($story) . " words long";
				
			} else {
				echo "Error: <br>" . mysqli_error($conn);
			}
			$stmt->close();

		 ?>
		<a href="http://people.oregonstate.edu/~vasquezd/sites/story_list.php">Stories</a>

		<?php 
		/*
					<p>Story Name </p> 
			<input type="text" class = "" name="name" value="">
			<p>Title </p> 
			<input type="text" class = "" name="title" value="<?php echo date("Y/m/d"); ?>">
			<p>Story </p> 
			<textarea name="story" id = "js-post-photo-caption" class = "new-post-input-text" placeholder="Share Something!"></textarea><br />
			<input type="submit" value="Submit">
		echo "Today is " . date("Y/m/d") . "<br>";
		*/
		?>
		
		<!-- SECTION: List All Posts -->
			



		<!-- Include all JS Files -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="../js/mobile.js"></script>
	</body>
</html>














