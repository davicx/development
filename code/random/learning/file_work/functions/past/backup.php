<?php
include 'includes/connect.php';

header("Content-Type: application/octet-stream");

$file = $_GET["file"];
header("Content-Disposition: attachment; filename=" . urlencode($file));   
//header('Content-Disposition: attachment; filename="' . str_replace('"', '\\"', ($mask ? $mask : basename($download_file))) . '"');
header("Content-Type: application/octet-stream");
header("Content-Type: application/download");
header("Content-Description: File Transfer");            
header("Content-Length: " . filesize($file));

flush(); // this doesn't really matter.
$fp = fopen($file, "r");
while (!feof($fp))
{
    echo fread($fp, 65536);
    flush(); // this is essential for large downloads
} 
fclose($fp); 


/*


	
			$local_file = 'C:/wamp/www/file_work/files/mayday.docx';
			$download_file = 'May Day';
			
			$download_rate = 20.5;
			if(file_exists($local_file) && is_file($local_file)) {
				header('Cache-control: private');
				header('Content-Type: application/octet-stream');
				header('Content-Length: '.filesize($local_file));
				//header('Content-Disposition: filename='.$download_file);
				header('Content-Disposition: attachment; filename="' . str_replace('"', '\\"', ($mask ? $mask : basename($download_file))) . '"');
				flush();
				$file = fopen($local_file, "r");
				while(!feof($file))
				{
					// send the current file part to the browser
					print fread($file, round($download_rate * 1024));
					// flush the content to the browser
					flush();
					// sleep one second
					sleep(.1);
				}
				fclose($file);}
			else {
				die('Error: The file '.$local_file.' does not exist!');
			}

		
	}
		
*/
?>
