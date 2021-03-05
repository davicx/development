$(function(){ //DOM Ready
 
		$(".gridster ul").gridster({
		widget_margins: [10, 10],
		widget_base_dimensions: [70, 70]
		});
		 
});

//- Using a function pointer:
/*
document.getElementById("clickMe").onclick = alert();

function alert() {
    alert("Hi");
}
*/

function doFunction() {
    alert("Hi");
}


//- Using and anonymous function:
document.getElementById("clickMe").onclick = function () { alert('hello!'); };