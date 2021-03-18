var fruits = ["Banana", "Orange", "Apple", "Mango"];

var text = "<ul>";
fruits.forEach(myFunction);
text += "</ul>";
document.getElementById("demo").innerHTML = text;

function myFunction(value) {
	text += "<li>" + value + "</li>";
} 