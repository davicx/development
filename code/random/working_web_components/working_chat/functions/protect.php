<?php

function protect($v) {
	$v = trim($v);
	$v = stripslashes($v);
	$v = htmlentities($v, ENT_QUOTES);
	//$v = mysqli_real_escape_string($v);
	
	return $v;
	
} 

?>