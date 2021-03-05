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
			<a href="http://people.oregonstate.edu/~vasquezd/sites/index.php">Home</a><hr />
			<h4> Stories </h4>
		<?php 
		
		$result = mysqli_query($conn,"SELECT * FROM story");

		while($row = mysqli_fetch_array($result)) {		
			$title 		= $row['title']; 	
			//echo $title;
			$name  		= $row['name']; 	
			//echo $name;
			$story 		= $row['story']; 	
			$created 	= $row['created']; 	
			$word_count = $row['word_count'];
		?>
			<a href="http://people.oregonstate.edu/~vasquezd/sites/individual_story.php?story_id=<?php echo $story_id; ?>"><?php echo $title; ?></a><br />
		<?php }	?>
		



		<!-- Include all JS Files -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="../js/mobile.js"></script>
	</body>
</html>














