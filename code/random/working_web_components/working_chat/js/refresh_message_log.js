$.ajaxSetup ({
	cache: false
}); 


$(setInterval(function() {
	$('.main').load('functions/display_messages.php');
	//$('.main').attr({ scrollTop: $('.main').attr('scrollHeight') });
	$('.main').scrollTop($('.main')[0].scrollHeight);
  
}, 500));

