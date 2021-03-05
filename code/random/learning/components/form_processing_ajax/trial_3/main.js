$(document).ready(function(){
  $("#hide").click(function(){
    $("p").hide();
  });
  $("#show").click(function(){
    $("p").show();
  });
});

// this is the id of the form
$("#note_add").submit(function() {

    var url = "note_process.php"; // the script where you handle the form input.

    $.ajax({
           type: "POST",
           url: url,
           data: $("#note_add").serialize(), // serializes the form's elements.
           success: function(data)
           {
               alert(data); // show response from the php script.
           }
         });

    return false; // avoid to execute the actual submit of the form.
});

/*
   $('#submit_note').click(function () {
        $.ajax ({
            type: "POST",
            url: "note_process.php",
            data: $('#note_add').serialize(), 
            success: function(text){
                  $('#entries').html(text); 
            }
        });    
    });
	
	*/