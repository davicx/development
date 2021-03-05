
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
		<link rel="stylesheet" href="template/css/external_css/normalize.css">
		<link id="data-uikit-theme" rel="stylesheet" href="template/css/uikit.gradient.css">	
		<link rel="stylesheet" href="template/css/style.css">	
		
		<!-- Javascript -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../js/vendor/modernizr-2.8.3.min.js"></script>
		<script src="../js/vendor/uikit.min.js"></script>

    </head>
		
		<body id = "">
		
		<!-- SECTION: Add Post -->
		<form action="http://people.oregonstate.edu/~vasquezd/sites/story.php" method = "post">
			<p class = "story-text">Story Name </p> 
			<input type="text" class = "story-input " name="name" value="Name">
			<p class = "story-text">Title </p> 
			<input type="text" class = "story-input " name="title" value="<?php echo date("Y/m/d"); ?>">
			<p class = "story-text">Story </p> 
			<textarea name="story" id = "js-post-photo-caption"  height="200" class = "story" placeholder="Share Something!"></textarea><br />
			<input type="submit" value="Submit">
		</form> 

		<a href="http://people.oregonstate.edu/~vasquezd/sites/story_list.php">Stories</a>




		<!-- Include all JS Files -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
        <script src="../js/mobile.js"></script>
	</body>
</html>














