$(document).ready(function(){
		$("a").click(function(){
		var $button = $(this);
		
		var user_id = $(this).attr('class');
		//alert(user_id);
		
		$.post('process.php', { post_id: user_id }, 
		function(data) {
			var json = JSON.parse(data);
			//$('#name_feedback').html(json.contact_name);
			$('#staff-name').html(json.staff_name);
			$('#contact-name').html(json.contact_name);
			$('#contact-title').html(json.contact_title);
			$('#contact-college').html(json.contact_college);
			$('#date').html(json.date);
			$('#purpose').html(json.purpose);
			$('#created').html(json.created);			
			
		})		

	});
});
