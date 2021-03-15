<?php 
	if(isset($_GET["group_id"])) {
		$group_id = $_GET['group_id'];	
	} else {
		 
	} 
			
	if(isset($_GET["not"])) {
		$name = $_GET['not'];	
	} else {
		 
	} 
?>
 

<!DOCTYPE html>
<html>
    <head>
		
		<!-- Meta Tags -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">		
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="" />
		<title> My Files </title>

    </head>
	
	<body> 
		<?php 
		echo $group_id . " " ;
		echo $name;
		var_dump($group_id);
		var_dump($name);
	 
		
		
		?>
 
	</body>
</html>





 



