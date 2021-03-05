
$(document).ready(function(){
	$("#submit-form").click(function(){
		var college = $( "#college_id" ).val();
		var contact = $( "#contact_id" ).val();
		var title = $( "#title_id" ).val();
		var date = $( "#datepicker_id" ).val();
		var purpose = $( "#purpose_id" ).val();
		
		$.post("function.php", {}, function(data)) {
			alert();
		}
	});
	
});






$(document).ready(function(){
  $("textarea").click(function(){
     $('textarea').val('');
  });
});

/*

	$.post('../functions/function.php', { college: college}, 

	//$.post('../functions/function.php', { post_college: college, post_contact: contact, post_title: title, post_datepicker: datepicker, post_purpose: purpose }, 

		function(data) {
			alert(data);

		});	

*/