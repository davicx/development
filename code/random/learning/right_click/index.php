<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/right_click.css">
		
	<!-- JS -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/main.js"></script>
	<script src="js/right_click.js"></script>
	
	<!--Sortable -->	
	<!--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">-->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	
	<script>
	$(document).ready(function(){
	  $("button").click(function(){
		$.post("function.php", { name:"Donald Duck", city:"Duckburg"},
			function(data){
			  alert("Data: " + data);
			});
	  });
	});
	</script>
			

	
</head>	
	
 <body>


<div id="download">Right Click to Demo <span class="amp">&amp;</span> Download</div>

<h2>Features</h2>
			
			<ul>
				<li>Linted: Valid JS</li>
				<li>Can be used with or without Twitters Bootstrap.css</li>
				<li>Event Based Links</li>
				<li>Anchor Links</li>
				<li>Headers</li>
				<li>Dividers</li>
				<li>Recursive Menus (infinite depth)</li>
				<li>Vertical Space Detection (turns into a "dropup")</li>
				<li>Horizontal Space Detection (Drops to the left instead of right)</li>
				<li>Add/Delete menus Dynamically</li>
				<li>Even works on <a href="http://google.com" class="inline-menu">Inline Links</a></li>
			</ul>
			
			<h2>Public API</h2>
			
			<h3>Initializing</h3>
			<pre>context.init({
    fadeSpeed: 100,
    filter: function ($obj){},
    above: 'auto',
    preventDoubleContext: true,
    compress: false
});</pre>

    </body>
</html>