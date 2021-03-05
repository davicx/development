$("#sub").click( function() {
 $.post( $("#myForm").attr("action"), 
         $("#myForm :input").serializeArray(), 
         function(info){ $("#result").html(info); 
   });
 clearInput();
});
 
$("#myForm").submit( function() {
  return false;	
});
 
function clearInput() {
	$("#myForm :input").each( function() {
	   $(this).val('');
	});
}

/**/
function showHint(str) {
if (str.length==0) {
  document.getElementById("txtHint").innerHTML="";
  return;
  }
var xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","gethint.php?q="+str,true);
xmlhttp.send();
}

$(document).ready(function(){
  $("p").click(function(){
    $(this).hide();
  });
}); 

function myFunction() {
	document.getElementById("demo").innerHTML = Date();
}