//This will remove the post and place a text box
$(document).ready(function(){
  $("#hide").click(function(){
    $(".post-caption").hide();
	$("#hide").hide();
	$("div#edit-post").toggleClass('view-post view-textbox');
	$("p#edit-post").toggleClass('view-post view-textbox');
  });
  
});

//This will remove the text box and bring the quote back
$(document).ready(function(){
  $("#cancel").click(function(){
    $(".post-caption").show();
	$("#hide").show();
	$("div#edit-post").toggleClass('view-textbox view-post');
	$("p#edit-post").toggleClass('view-textbox view-post');
  });
});

//Save and execute Jquery
$(document).ready(function(){
	$("#save").click(function(){	
		$(".post-caption").show();
		$("#hide").show();
		$("div#edit-post").toggleClass('view-textbox view-post');
		$("p#edit-post").toggleClass('view-textbox view-post');
		var updatedMessage =  $('textarea.updated-post').val();
		$('#post-toggle span').text(updatedMessage);
	
	
  });
});


//Function 2: Submit new post to Database
$('form.ajax').on('submit', function() {
	var that = $(this),
		url = that.attr('action'),
		type = that.attr('method'),
		data = {};
	
	that.find('[name]').each(function() {
		var that = $(this), 
		name = that.attr('name'),
		value = that.val();
		data[name] = value;
	});		
		
	$.ajax({
		url: url, 
		type: type,
		data: data,
		success: function(response) {
			console.log(response);
		}
			
	});	
		//console.log(data);
		$("#form")[0].reset();
		return false;
});

