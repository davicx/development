$("#sub").click( function() {
	alert("hi");

 $.post( $("#myForm").attr("action"), 
         $("#myForm :input").serializeArray(), 
         function(info){ $("#result").html(info); 
		 	alert("hi");

   });
 clearInput();
});
 
$("#myForm").submit( function() {


  return false;	
});
 
function clearInput() {

	$("#myForm :input").each( function() {
	   $(this).val('');
	});
	
};
