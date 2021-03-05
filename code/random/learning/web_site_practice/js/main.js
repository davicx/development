//REPORTING
//Function 14: Year Event Handler 
$(document).ready(function(){
	$( ".year-event-handler" ).change(function() {
		var yearSelected = $(".year-event-handler").val();
		alert(yearSelected);
	});	
});

//Function 15: Year Event Handler 
$(document).ready(function(){
	$( ".college-event-handler" ).change(function() {
		var yearSelected = $(".college-event-handler").val();
		alert(yearSelected);
	});	
});

//Function 16: Year Event Handler 
$(document).ready(function(){
	$( ".staff-event-handler" ).change(function() {
		var yearSelected = $(".staff-event-handler").val();
		alert(yearSelected);
	});	
});


//USER PROFILE 
//Function 11: Edit User Profile
$(document).ready(function(){
	$(".individual-connection-edit-text").hide();
	$("#save-edit-profile").hide();
	$("#cancel-edit-profile").hide();
	$("#edit-profile").click(function(){
	var classID = $(this).attr('class');
	var splitParts;
	splitParts = classID.split("_");
	var userID = splitParts[1];
	
	//Hide all solid name details to allow for showing 
	$(".individual-connection-text").hide();
	$("#edit-profile").hide();
	$(".individual-connection-edit-text").show();
	
	//Show Save and Cancel Buttons
	$("#save-edit-profile").show();
	$("#cancel-edit-profile").show();
		
	});
});

//Function 12: Cancel Edit Profile
$(document).ready(function() {
    $("#cancel-edit-profile").click(function(){
		$(".individual-connection-text").show();
		$("#edit-profile").show();
		$(".individual-connection-edit-text").hide();
		$("#save-edit-profile").hide();
		$("#cancel-edit-profile").hide();

    }); 
});

//Function 13: Save Edit Profile
$(document).ready(function() {
    $("#save-edit-profile").click(function(){
		//Get all edited values to send to functions.php to place in database
		var firstName = $("#first-name-value").val();
		var lastName = $("#last-name-value").val();
		var title = $("#title-value").val();
		var biography = $("#biography-value").val();

		$(".individual-connection-text").show();
		$("#edit-profile").show();
		$(".individual-connection-edit-text").hide();
		$("#save-edit-profile").hide();
		$("#cancel-edit-profile").hide();

		//{ to php from js } 
		$.post('../functions/update_profile.php', { firstName: firstName, lastName: lastName, title: title, biography: biography }, 
		function(data) {
			//var obj = JSON.parse(data);
			//alert(obj.firstName);
			//$("#profile-updated-first").text(userInfo.firstName);
				//userInfo.lastName
				//userInfo.title
				//userInfo.biography
					
		//alert(obj.lastName);
		//obj.name + "<br>" +
		//obj.street + "<br>" +
	
		})		
    }); 
});


//Function 1: Submit information to database 
$(document).ready(function(){
	$("#submit-form").click(function(){
		var college = $( "#college" ).val();
		var contact = $( "#contact" ).val();
		var title = $( "#title" ).val();
		var datepicker = $( "#datepicker" ).val();
		var purpose = $( "#purpose" ).val();
	});
});

//Function 2: Get user information from database
$(document).ready(function(){
		$("a#connection-link-id").click(function(){
		$("#individual-connection").show();
		var $button = $(this);		
		var user_id = $(this).attr('class');

		$.post('../functions/process.php', { post_id: user_id }, 
		function(data) {		
			var json = JSON.parse(data);
			//$('#name_feedback').html(json.contact_name);
			$('#connection-staff-image').html("<img border=\"0\" id = \"connection-user-image\" src=\"../images/" + json.image_name + "\" alt=\"\" width=\"100\">");
			$('#staff-name').html("<strong>" + json.first_name +" "  + json.last_name + "</strong>" );
			$('#contact-name').html(json.contact_name);
			$('#contact-title').html(json.contact_title);
			$('#contact-college').html(json.contact_college);
			$('#date').html(json.date);
			$('#purpose').html(json.purpose);
			$('#created').html(json.created);		
		})		
	});
});

//Function 3: Toggle Display of User Interface 
$(".connection").click(function(){
 
});

/* EDIT PROFILE */
//Function 4: Profile Page- Show form area to enable edit 
$(document).ready(function(){
	$(".connection-edit-form-area").hide();
	$("button.edit-button").click(function(){
		var button = $(this).attr('id');
		var splitParts;
		splitParts = button.split("_");
		var current_post_id = splitParts[1];
		var formID = "update_form_" + current_post_id;
		$("button#delete_" + current_post_id).hide();		
		$("button#edit_" + current_post_id).hide();
		$("#" + formID ).show();
	});
}); 

//Function 5: Profile Page- Cancel edit post 
$(document).ready(function() {
    $(".cancel").click(function(){
		var button = $(this).attr('id');
		var splitParts;
		splitParts = button.split("_");
		var current_post_id = splitParts[1];
		$("button#edit_" + current_post_id).show();
		$("button#delete_" + current_post_id).show();
    }); 
});
//FINISH !! 
$(document).ready(function() {
    $(".delete-button").click(function(){
		var button = $(this).attr('id');
		var splitParts;
		splitParts = button.split("_");
		var current_post_id = splitParts[1];
		$("button#delete_" + current_post_id).show();
		var result = confirm("Want to delete?");
		if (result==true) {
		//	alert(current_post_id);
		}	
    }); 
});

//Function 6: Profile Page- Save post and update database
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
			var that = $(this),
				name = that.attr('name'),
				value = that.val();
				
			//Create JSON object with all data
			data[name] = value;
			console.log(data); 
		});
		console.log(data);
		$.ajax({
			//These are relating to the variables in the above function and correlate to the HTML form
			url: url, 
			type: type,
			data: data,
			success: function(response) {
				//alert(response);
				$(".form-output").html("<p>" + response + "</p>");
				$(".connection-edit-form-area").hide();
				$(".edit-button").show();
				$(".delete-button").show();
			}
		});
		
		//console.log(data); 
		e.preventDefault(e);	
	});
});

//Function 7: Datepicker 
$(function() {
	$( "#datepicker_id" ).datepicker();
});

//Function 8: Validate Form
function validateForm() {
	var x = document.forms["input"]["contact"].value;
	var date = document.forms["input"]["date"].value;
	var yearVerification = validateDate(date);
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
	
	if (x==null || x=="") {
	   $("p.contact-error").text("*Contact name must be filled out");
	   return false;
	} 

	if(yearVerification == false) {
		$("p.year-error").text("*Date must be in the format 01/30/2014");
		return false;
	}

}
//Function 9: Validate Date Format (Called by Function 8) 
function validateDate(testdate) {
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
	return date_regex.test(testdate);
}

/*Function 10: Get textarea value*/
$(document).ready(function(){
  $("textarea").click(function(){
     $('textarea').val('');
  });
});
