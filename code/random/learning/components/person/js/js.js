$(document).ready(function(){
	$("#edit-user-profile").submit(function() {
		
		$.post('includes/function.php', $("#edit-user-profile").serialize(),  function(data) {
			$("#content").html(data);
		});
		
		return false;
		
	});
	
});