<html>
<body>

<?php 
if(isset($_POST['submit'])){
  display();
	echo $_POST["biography"]; 
	echo $_POST["userName"]; 
	echo $_POST["firstName"];
	echo $_POST["lastName"];
	echo $_POST["id"];
}

function display() {
    echo "DISPLAY";
}

?>	



</body>
</html> 