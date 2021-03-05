<?php 
		
		$filename = 'C:/wamp/www/ShareSpace/site_files/user_files/user_uploads/vasquezd/word.doc';
		

		$ext = pathinfo($filename, PATHINFO_EXTENSION);
		
$var1 = "hello";
$var2 = "hello";

$var1 = strtolower($var1);
$var2 = strtolower($var2);

//echo $var1;
//echo $var2;
echo $ext;
if (strcmp($var1, $var2) == 0) {
//    echo '$var1 is not equal to $var2 in a case sensitive string comparison';
}


?>