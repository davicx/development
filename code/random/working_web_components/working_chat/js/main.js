//Hide the message area 
$(function() {
	$('.newMessage').hide();
	//On click this will put focus on username box
	$("#messageBoxSignIn").click(function() {
		$('#username').focus();	
	
	})
});

//Hide errors message insert username 
$(function() {
	$('.error').hide();
	$('#signIn').click(function() {
		var username = $('#username').val();
		
		if(username == "" || username == "Enter Username") {
			$('.error').show();
			return false;
		}
		
		$('#messageBoxSignInForm').hide();
		$('.newMessage').show();
		
		var dataString = "username" + username;
		
	$.post('functions/signinout.php', {username: username}, function() {
		$('.user').html('<span> Welcome <span id = "loggedUser">'  +  username +  ' </span>!</span><a id="signOut" onclick="window.location.reload()">SIGN OUT </a>');
				
		
	});	
		
	
	});
});
