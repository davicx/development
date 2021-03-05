<!DOCTYPE html>
<html>
	<head>
	<title> Links </title>

	</head>
<body>
	<?php
function getMetaData($url){
	// get meta tags
	$meta=get_meta_tags($url);
	// store page
	$page=file_get_contents($url);
	// find where the title CONTENT begins
	$titleStart=strpos($page,'<title>')+7;
	// find how long the title is
	$titleLength=strpos($page,'</title>')-$titleStart;
	// extract title from $page
	$meta['title']=substr($page,$titleStart,$titleLength);
	// return array of data
	return $meta;
}

$tags=getMetaData('http://stackoverflow.com/questions/14436235/mobile-app-vs-web-app-apple-no-longer-accepting-web-apps');

if (!empty($tags['title'])) {
	echo 'Title: '.$tags['title'];
	echo '<br />';
} else { 

}

if (!empty($tags['description'])) {
	echo 'Description: '.$tags['description'];
	echo '<br />';
} else { 

}

if (!empty($tags['keywords'])) {
	echo 'Keywords: '.$tags['keywords'];
} else { 

}

//$baseFavicon = 'http://www.google.com/s2/favicons?domain=URL';
$filepath = 'http://www.google.com/s2/favicons?domain=http://oregonstate.edu/';


$image = imageCreateFromAny($filepath);

echo ($image);

//Store in the filesystem.
function imageCreateFromAny($filepath) {
    $type = exif_imagetype($filepath); // [] if you don't have exif you could use getImageSize()
    $allowedTypes = array(
        1,  // [] gif
        2,  // [] jpg
        3,  // [] png
        6   // [] bmp
    );
    if (!in_array($type, $allowedTypes)) {
        return false;
    }
    switch ($type) {
        case 1 :
            $im = imageCreateFromGif($filepath);
        break;
        case 2 :
            $im = imageCreateFromJpeg($filepath);
        break;
        case 3 :
            $im = imageCreateFromPng($filepath);
        break;
        case 6 :
            $im = imageCreateFromBmp($filepath);
        break;
    }   
    return $im; 
}











?>


</body>
</html> 
