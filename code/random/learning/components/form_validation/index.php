<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>


function validateForm() {
    var x = document.forms["myForm"]["fname"].value;
	var lastName = document.forms["myForm"]["lname"].value;
	var emailValue = document.forms["myForm"]["email"].value;
	var date = document.forms["myForm"]["year"].value;
	var yearVerification = validateDate(date);
	
	var atpos = emailValue.indexOf("@");
    var dotpos = emailValue.lastIndexOf(".");
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
	
    if (x==null || x=="") {
       $("p.first-name").text("First name must be filled out");
	   return false;
       
    } 
	if (lastName==null || lastName=="") {
       $("p.last-name").text("Lastname must be filled out");
	    return false;
    } 
	
	if(yearVerification == false) {
	    $("p.year").text("Date must be in the format 01/30/2014");
	    return false;
	
	}

	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=emailValue.length) {
        $("p.email").text("Not a valid email");
         return false;
    }
}

function validateDate(testdate) {
    var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
    return date_regex.test(testdate);
}

</script>
</head>



<p id="demo"></p>



	<body>
		<form name="myForm" action="" onsubmit="return validateForm()" method="post">
			First name: <input type="text" name="fname">
			<span><p class = "first-name"></p></span>
			Last name: <input type="text" name="lname">
			<span><p class = "last-name"></p></span>
			Year: <input type="text" name="year">
			<span><p class = "year"></p></span>
			
			Email: <input type="text" name="email">
			<span><p class = "email"></p></span>
			
			<input type="submit" value="Submit">
		
		</form>
	</body>

</html>
