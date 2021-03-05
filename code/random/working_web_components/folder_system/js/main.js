$(document).ready(function(){
	//Set clone: the clone is what allows the mini version to be dragged (revert: true, helper: clone)
	$(".draggable").draggable({ revert: true, helper: "clone",
		//Start function and add a class to clone, this will revert if action is stopped
		 start: function(e, ui) {
			$(ui.helper).addClass("dragged-file");
		 }
	});
	
	//Set the droppable actions 
	$( ".droppable" ).droppable({
	
		accept: ".draggable",
		activeClass: "ui-state-hover",
		hoverClass: "ui-state-active",
		drop: function( event, ui ) {

		var drag = $(ui.draggable).attr("id")
		//Use AJAX to handle database actions 
		$(this)
			var id = $(this).attr('id');
			alert("File: " + drag + " Folder: "  + id);
			//Hide the file and clone (basically this looks like the file was "dropped" into the folder)
			$("div#" + drag).hide();
			$(".dragged-file").hide();
			

		}
	});
});
		