<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<title> OSU Dashboard </title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		
		<script src="main.js"></script>
	</head>	
	
	<body>	


</head>
<body>


		<form action="process.php" method="post" class = "ajax">
			<div>
				<input type="text" name="name" placeholder="Your Name" />
			</div>
			
			<div>
				<input type="text" name="email" placeholder="Your Email" />
			</div>
			
			<div>
				<textarea name="message" ></textarea>
			</div>
			<div>
				<input type="submit" value="Send">
			</div>
		</form>

		<p id="form-output"></p>


    </body>
</html>
