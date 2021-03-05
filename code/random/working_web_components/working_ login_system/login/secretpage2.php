<?php
	require_once('includes/session_timeout.inc.php');
	
?>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Secret page</title>
</head>

<body>
<h1>Restricted area PART 1</h1>
		<a href="http://localhost/login/secretpage.php" target="">Secret</a> 

<?php include('includes/logout.inc.php'); ?>
</body>
</html>
