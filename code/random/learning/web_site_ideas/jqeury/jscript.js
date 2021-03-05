$(document).ready(function() {
    $(".hide").click(hideClicked);
	$(".show").click(showClicked);
});

//$("#pay").click(function(e) {
//$("#pay").unbind('click').click(function(e) 

function hideClicked() {	
	str = $( ".text-p" ).text();
	$(".text-p").hide(); //hide the <p> text
	$(".text-area").show(); //Show the text 
	$(".text-area").append(str);

}

function showClicked() {
	textFromArea = $( ".text-area" ).val();
	$(".text-p").replaceWith(textFromArea); //replace the p div with this
	$(".text-area").hide();
	$(".text-p").show();

}



/*

 $("#show").on( "click", function() {

	textFromArea = $( "#text-area" ).val(); //Get the text from the text area    
	$("#text-p").replaceWith(textFromArea); //replace the p div with this
	$("#text-p").show(); //show the p div
	$("#text-area").hide(); //hide the text area
  });



$(document).ready(function(){

$("#hide").on( "click", function() {
	str = $( "#text-p" ).text(); //Get current value inside of <p> text area
    $("#text-p").hide(); //hide the <p> text
	$("#text-area").show(); //Show the text area
	alert(str);
	$("#text-area").append(str); //Add this value to the text area
  });
  
 $("#show").on( "click", function() {

	textFromArea = $( "#text-area" ).val(); //Get the text from the text area    
	$("#text-p").replaceWith(textFromArea); //replace the p div with this
	$("#text-p").show(); //show the p div
	$("#text-area").hide(); //hide the text area
  });
  
});

//
function divClicked() {
    var divHtml = $(this).html();
    var editableText = $("<textarea />");
    editableText.val(divHtml);
    $(this).replaceWith(editableText);
    editableText.focus();
    // setup the blur event for this new textarea
    editableText.blur(editableTextBlurred);
}

function editableTextBlurred() {
    var html = $(this).val();
    var viewableText = $("<div>");
    viewableText.html(html);
    $(this).replaceWith(viewableText);
    // setup the click event for this new div
    viewableText.click(divClicked);
}

$(document).ready(function() {
    $("div").click(divClicked);
});*/