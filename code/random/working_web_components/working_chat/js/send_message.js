//when you click message box this makes it go blank so you can type message
$(function() {
	$("#newMessageContent").click(function() {
		document.newMessage.newMessageContent.value = "";
	});

	$("#newMessageSend").click(function() {
		var username = "david";//$('loggedUser').html();
		var message = $('#newMessageContent').val();
		
		if(message == "") {
			return false;
		}
		var dataString = 'username=' + username + ' message = ' + message;
		
		$.post('functions/send_message.php', {message: message}, function(output) {
			document.newMessage.newMessageContent.value = "";
	
		});	
		
	});	

});

