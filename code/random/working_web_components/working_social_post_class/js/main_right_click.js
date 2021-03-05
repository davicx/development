
//Function 11: Right Click Menu Delete File
$(document).ready(function(){
	$('.download').on('contextmenu', function(e) {
		//Get File ID and split
		var file_full_id = $(this).attr('id');
		var href_local = $(this).data('selector');
		//alert(href);
		var splitParts;
		splitParts = file_full_id.split("_");
		var file_id_local = splitParts[1];
		
		//Set variables for php functions to update database
		window.file_id = file_id_local; 
		window.file_id_rename = file_id_local;
		
		//Get local download link and set url to a global variable for the file download link
		var url = href_local;
		window.href_global = url; 
	});
	
	context.init({

		preventDoubleContext: false
	});
	
	context.attach('.download', [
		{header: 'File Menu'},
		{divider: true},
		//Part A: Download File
		{text: 'Download', action: function(e){
			//On function click activate download
			location.href= href_global;
		}},
		
		//Part B: Rename File
		{text: 'Rename', action: function(e){
			
			
			
			//Hide text name, show text edit area and insert value into it
			$("#file_name_" + file_id).hide();
			$("#file_name_edit" + file_id).show();
			
			$(".update-file-name-text").click(function(event) {
				//alert('clicked inside');
				//event.stopPropagation();
			});
			
			//When user clicks outside of file name then execute call to rename file 
			$(document).click(function() {
				//Get new file name from text box
				var new_file_name = $("#file_name_edit" + file_id).val();
				
				$.post("../functions/rename_file.php", { file_id_rename: file_id_rename, new_file_name: new_file_name},
					
				function(data){
					$("#file_name_" + file_id).show();
					$("#file_name_edit" + file_id).hide();
					//Right now I am just reloading the page on file rename but this is poor coding need to fix this and the event propagation. 
										
					location.reload();

					//$("#file_" + file_id).hide();
					
				});	
			});
			
		}},

		
		//Part C: Delete File
		{text: 'Delete', action: function(e){
			e.preventDefault();
			if (confirm('Are you sure you want to delete this file?')) {
				$.post("../functions/right_click.php", { file_id: file_id},
					
				function(data){
					//alert("Are you Sure: " + data);
					$("#file_" + file_id).hide();
				});	
			} else {
				// Do nothing!
			}			
		}}
	]);
});


