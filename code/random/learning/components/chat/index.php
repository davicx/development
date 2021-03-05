<?php
	require_once('functions/connection.inc.php');		

?>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat</title>
		<link rel="stylesheet" href="css/style.css">	
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

	</head>
	
    <body>
		<h1>Chat Tutorial </h1>
		<div class = "chat-box">
			<div class = "user">
				<form name = "signIn" action = "" onsubmit="return false">
				
					<span class = "error"> Invalid Username </span>
					<input type = "text"  name = "username" id ="username" value "Enter Username" onclick = 'document.signIn.username.value=""' />
					<input type = "submit" id = "signIn" value = "Sign In" />
				</form>	
			</div>
			
			<div class = "main">
				
			</div>

			<div class = "message-box">
				<form name ="messageBoxSignInForm" id = "messageBoxSignInForm" onsubmit="return false">
					<input type = "submit" id = "messageBoxSignIn" value = "Sign In to Enter Chat" />
				</form>
				
				<form name ="newMessage" class = "newMessage" action = "" onsubmit = "return false">
					<div class = "left">
						<textarea name = "newMessageContent" id = "newMessageContent"> Enter Message </textarea> 
					</div>
					
					<div class = "right">
						<input type = "submit" id = "newMessageSend" value = "send" />

					</div>
				</form>
				
			</div>
			

			

		
			
		</div>
    	<script src="js/main.js" type="text/javascript"></script>
		<script src="js/send_message.js" type="text/javascript"></script>
		<script src="js/refresh_message_log.js" type="text/javascript"></script>
	

    </body>
</html>