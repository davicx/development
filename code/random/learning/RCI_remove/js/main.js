//Function 
$(document).ready(function(){
	
	/*
	context.init({
    fadeSpeed: 100,
    filter: function ($obj){},
    above: 'auto',
    preventDoubleContext: true,
    compress: false
});
	*/
	
	context.init({
		/*above: 'auto',*/
		preventDoubleContext: false
	});
	
	context.attach('#download', [
		{header: 'File Menu'},
		{divider: true},
		{text: 'Download', href: '#'},
		{text: 'Rename', href: '#'},
		
		{text: 'Delete', action: function(e){
			e.preventDefault();
			$.post("function.php", { name:"Donald Duck", city:"Duckburg"},
			function(data){
			  alert("Data: " + data);
			});
			
		}}

		
	]);
});