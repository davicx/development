$(document).ready(function() {
	//Function 1: Submit and process 
	$("form.ajax").submit(function(e){
		//Current object 
		var that = $(this), //that is referring to the form we are procesing
		url = that.attr('action'),
		type = that.attr('method'),
		data = {};
		
		//loop through elements in the form that have a name
		that.find('[name]').each(function(index, value) {
		//Get each element with name value from the form 
		//	console.log(value);
			var that = $(this),
				name = that.attr('name'),
				value = that.val();
				
			//Create JSON object with all data
			data[name] = value;

		});
		
		$.ajax({
			//These are relating to the variables in the above function and correlate to the HTML form
			url: url, 
			type: type,
			data: data,
			success: function(response) {
				//alert(response);
				$("#form-output").html("<p>" + response + "</p>");
				
			}
		});
		
		//console.log(data); 
		e.preventDefault(e);	
	});
});
