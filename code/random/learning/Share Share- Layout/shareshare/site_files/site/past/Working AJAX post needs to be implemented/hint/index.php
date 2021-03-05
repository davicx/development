<html>
<head><title>Insert Data Into MySQL: jQuery + AJAX + PHP</title></head>
	<body>
	 
		<form id="myForm" action="userInfo.php" method="post">
		Age : <input type="text" name="name" /><br />
		Name: <input type="text" name="age" /><br />
		<button id="sub">Save</button>
		</form>
		 
		<span id="result"></span>
		<p> hide </p>
		 
			
			
		<h3>Type Name:</h3>
			<form action=""> 
			First name: <input type="text" id="txt1" onkeyup="showHint(this.value)" />
			</form>
			<p>Suggestions: <span id="txtHint"></span></p> 

			
			

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

		<script src="my_script.js" type="text/javascript"></script>
	</body>
</html>