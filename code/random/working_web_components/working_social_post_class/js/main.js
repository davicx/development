

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
		
		$.post('../functions/add_user_to_square.php', { user_name: user_name, request_type: request_type, logged_in_user: logged_in_user, square_id: square_id }, 
	
		function(data) {
			$("button#" + request_id).hide();
			$("button#accept_square_" + request_id).show();	
			
		})

	});
});

//Function 6: Edit and Save user Profile 
$(document).ready(function() {
    $("#update-user-save").click(function(){

		//Get all edited values to send to functions.php to place in database
		var firstName = $("#update-first-name").val();
		var lastName = $("#update-last-name").val();
		var email = $("#update-email").val();
		var biography = $("#update-user-biography").val();
		var userID = $("#update-user-hidden-id").val();
	
		//{ to php from js } 
		$.post('../functions/edit_user_profile.php', { firstName: firstName, lastName: lastName, email: email, biography: biography, userID: userID }, 
		function(data) {		
			//alert(data);
			$("p#update-profile-status").text("Changes Saved");
		})	 
    }); 
});


//Function 7: Process File 
$(document).ready(function(){
	$("button.update-file").click(function(){
		var newFileName = $("#file_1").val();		
		var fileID = $('.file1').val();
		
		$.post('../functions/file_process.php', {post_to_process: newFileName, file_id: fileID}, function(php_result) {
			$("div.current-file-name").html(php_result);
		
		});
	});
});

//Function 8: Add user name into user box (know PHP script)
$(document).ready(function(){
	$("button").click(function(){
		var $button = $(this);
		var clickedUserName = $(this).attr('id');
		$('#clicked-user-name').val(clickedUserName);
		//alert(clickedUserName);
	
	});
});

//Function 9: Add a Friend
$(document).ready(function(){
	$("button.add-friend-button").click(function(){
		var $button = $(this);
		var friend_button_id = $(this).attr('id');
		var splitParts;
		splitParts = friend_button_id.split("_");
		var add_friend_id = splitParts[1];
		var logged_in_user = $(this).data('selector');

		$.post('../functions/add_remove_friend.php', { add_friend_id: add_friend_id,  logged_in_user: logged_in_user}, 
		
		function(data) {

			$("button#add_" + add_friend_id).hide();
			$("button#remove_" + add_friend_id).show();
		})

	});
});


//Function 10: Remove a Friend


$(document).ready(function(){
	$( "button.remove-friend-button" ).click(function() {
		
		var $button = $(this);
		var friend_button_id = $(this).attr('id');
		var splitParts;
		splitParts = friend_button_id.split("_");
		var friend_id = splitParts[1];
		//alert(friend_button_id);

		var logged_in_user = $(this).data('selector');
		//alert(friend_id);
		
		$.post('../functions/add_remove_friend.php', { friend_id: friend_id,  logged_in_user: logged_in_user}, 
		
		function(data) {
			//alert(data);
			$("button#" + friend_button_id).hide();
			$("button#add_" + friend_id).show();

		})

	});
});

































