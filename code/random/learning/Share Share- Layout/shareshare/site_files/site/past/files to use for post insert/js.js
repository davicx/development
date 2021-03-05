$(document).ready(function(){
	$("button").click(function(){
		//Works
		//var user_id = $('#user_id').val();
	
		var user_id = $(this).attr('id');
	
		$.post('jquery.php', { 
			name: user_id
		}, function(data) {
			$('#name_feedback').html(data);
		})		
	
	});
});

/*
$(document).ready(function(){
	//Need to change this to get new submit which is dynamically generated
	//so first generate var submit = submit + (#).val();
	
	$("#submit").click(function(){
		//Works
		var user_id = $('#user_id').val();
		//Works
		
		//var user_id  = $(#this).val();

		//var test = $(this).attr('id');
		//alert(test);
		
		$.post('jquery.php', { 
			name: user_id
		}, function(data) {
			$('#name_feedback').html(data);
		})		
	
	});
});
*/