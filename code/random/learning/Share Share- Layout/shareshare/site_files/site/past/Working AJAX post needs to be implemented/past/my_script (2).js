$(document).ready(function(){
  $("p").click(function(){
    $(this).hide();
  });
}); 


$(document).ready(function(){
  $("button").click(function(){
    $("#test").hide();
  });
}); 

$("#submit").click( function() {
			$.post( $("#myForm").attr("action"), data = $("#myForm :input").serializeArray(), function(info){ $("#result").html(info);} );	
			clearInput();
	}
);

$("#myForm").submit( 
	function() {
		return false;
	}
); 

function clearInput() {
	$("#myForm :input").each( function() {
		$(this).val('');
	});

};

