$(document).ready(function(){
		$(".download-button").click(function(){

		var $button = $(this);		
		var user_id = $(this).attr('id');
		//alert(user_id);

		
		$.post('functions/function.php', { user_id: user_id }, 
		function(data) {		
			//alert(data);
		})	
	});
});