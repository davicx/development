<?php
function dbConnect($usertype, $connectionType = 'mysqli') {
  $host = 'localhost';
  $db = 'shareshare';
 
  if ($usertype  == 'read') {
	$user = 'root';
	$pwd = '';
  } elseif ($usertype == 'write') {
	$user = 'root';
	$pwd = '';
  } else {
	exit('Unrecognized connection type');
  }
if ($connectionType == 'mysqli') {
	return new mysqli($host, $user, $pwd, $db);
  } elseif ($mysqli->connect_error) {
	die('Connect Error: ' . $mysqli->connect_error);
}
}