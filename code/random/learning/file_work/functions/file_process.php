<?php
include 'classes/connect.php';
include 'classes/File.php';

if (isset($_POST["file_id"])) {	
	$fileID = $_POST["file_id"];
	$folderName = $_POST["new_folder"];
//	$fileID = 44;
//	$folderName = "test";

	//Instantiate object and copy it to new directory
	$individual_file = new File($fileID);
	$individual_file->getFileInfo($fileID);
	$individual_file->moveFile($fileID, $folderName);
	
	echo $individual_file->fileName;

	} else {
	echo "not set";
}

?>