//Function 3: Add user to square, this will add a pending request for the invited person 
$(document).ready(function(){
		$("button.add-user").click(function(){
		var $button = $(this);

		//get new user id and get current logged in user
		var user_id = $(this).attr('id');
		var logged_in_user = $(this).data('selector');
		var square_id = $(this).data('square');
		
		$.post('../functions/add_user_to_square.php', { user_id: user_id,  logged_in_user: logged_in_user, square_id: square_id}, 
		
		function(data) {
			//alert(data);
			$("button#" + user_id).hide();
			$("button#output_" + user_id).show();
		})
	});
});

//Function 4: Accept a request to join a square 
$(document).ready(function(){
		$("button.accept-button").click(function(){

		var $button = $(this);
		var request_id = $(this).attr('id');
		var user_name = $(this).data('sent');	
		var request_type = $(this).data('type');			
		var logged_in_user = $(this).data('selector');
		var square_id = $(this).data('square');
		
		//alert(request_type);
		$.post('../functions/add_user_to_square.php', { user_name: user_name, request_type: request_type, logged_in_user: logged_in_user, square_id: square_id }, 
	
		function(data) {
			$("button#" + request_id).hide();
			$("button#accept_square_" + request_id).show();	
			//alert(data);
			
		})

	});
});
