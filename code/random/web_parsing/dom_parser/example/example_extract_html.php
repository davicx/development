<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"><!-- Your HTML file can still use UTF-8-->
<title>Untitled Document</title>
</head>
<body>

<?php
header('Content-Type: text/html; charset=ISO-8859-1');
include_once('../simple_html_dom.php');

//echo file_get_html('http://www.google.com/')->plaintext;

echo "<br />";



$html = new simple_html_dom();
 
// Load from a string
//http://code.tutsplus.com/tutorials/html-parsing-and-screen-scraping-with-the-simple-html-dom-library--net-11856
 
// Load a file
//$html->load_file('https://www.yahoo.com/makers/this-park-morphs-into-a-spectacular-underwater-124690513095.html');
//$html->load_file('https://www.yahoo.com/travel/10-best-secret-us-road-trips-124620635737.html');
$html->load_file('http://www.grindtv.com/travel/awesome-stops-and-detours-between-socal-and-mammoth/');


# get an element representing the second paragraph
$element = $html->find("p");
 
foreach ($element as $value) {
    echo $value;
	echo "<br />";
	echo "<br />";
}
 
# output it!
//echo $html->save();

?>









</body>
</html>
