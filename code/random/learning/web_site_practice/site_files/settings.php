<?php
include '../functions/includes/classes/Posts.php';
include '../functions/includes/connect.php';
include '../functions/function.php';

require_once('../functions/includes/session_timeout.inc.php');

?>

<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title> OSU Dashboard </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- CSS -->
	<link rel="stylesheet" href="../css/normalize.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" href="../css/report.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	<!-- JS -->
	<script src="../js/vendor/modernizr-2.6.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/main.js"></script>
	<!-- Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Gudea' rel='stylesheet' type='text/css'>
	
</head>
    <body>
	<div id = "fixed-header-background"> </div>

	<div id = "site-wrapper">
		<div id = "site-border-wrapper">
			<?php require_once('../functions/includes/header.php');	?>

			<?php require_once('../functions/includes/logout.inc.php'); ?>
		</div>
	</div>
	
    </body>
</html>
