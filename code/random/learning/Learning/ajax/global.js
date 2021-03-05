$('input#name-submit').on('click', function() {
	var nameFromHTML = $('input#input-name').val();
	if ($.trim(nameFromHTML) !="") {
		$.post('function.php', {nameToPHP:nameFromHTML}, function(dataFromPHPScript) {
			$('div#name-data').text(dataFromPHPScript);
		});
	}	
}); 

//funtion(data) -this is what is returned from php
//

/*
$(document).ready(function(){
	$("button").click(function(){
		var helloWorld = "helloWorld";
		$.post("name.php",{ testname:helloWorld},
		
		function(data){
			//alert("Data: " + data + "\nStatus: " + status);
			alert(data);
			
		});
	});
});
*/
$(document).ready(function(){
	$("button").click(function(){
	
	}
}