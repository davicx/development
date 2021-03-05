<!DOCTYPE html>
<html>
<head>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		
<script>
function validateForm() {
//This works just need to combine the functions 
    var x = document.forms["myForm"]["fname"].value;
    if (x==null || x=="") {
        //alert("First name must be filled out");
		$("#form-output").html("<p> Name must be filled out </p>");
        
		return false;
    
	} else {
		$("#form-output").html("<p> Success </p>");
	}
	
	
	var y = document.forms["myForm"]["email"].value;
    var atpos = y.indexOf("@");
    var dotpos = y.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }

	
}


/*
<script type="text/javascript">
<!--
// Form validation code will come here.
function validate()
{
 
   if( document.myForm.Name.value == "" )
   {
     alert( "Please provide your name!" );
     document.myForm.Name.focus() ;
     return false;
   }
   if( document.myForm.EMail.value == "" )
   {
     alert( "Please provide your Email!" );
     document.myForm.EMail.focus() ;
     return false;
   }
   if( document.myForm.Zip.value == "" ||
           isNaN( document.myForm.Zip.value ) ||
           document.myForm.Zip.value.length != 5 )
   {
     alert( "Please provide a zip in the format #####." );
     document.myForm.Zip.focus() ;
     return false;
   }
   if( document.myForm.Country.value == "-1" )
   {
     alert( "Please provide your country!" );
     return false;
   }
   return( true );
}
//-->
</script>

*/

</script>
</head>

<body>
	
	
	<form name="myForm" action="" onsubmit="return validateForm()" method="post">
		First name: <input type="text" name="fname">
		Email: <input type="text" name="email">
		<input type="submit" value="Submit">
		
		
		
	</form>

		<p id="form-output"></p>

</body>

</html>
