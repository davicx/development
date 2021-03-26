//VARIABLES (number, string, object)
var a = 1;
let b = 2;
const c = 3;
typeof "" //String 

//ARRAYS
var cars = ["Saab", "Volvo", "BMW"];
var x = cars.length;   // The length property returns the number of elements
var y = cars.sort();   // The sort() method sorts arrays

var carsLength = cars.length;
for (var i = 0; i < carsLength; i++) {
    console.log(cars[i]);
}

//FUNCTIONS
function myFunction(p1, p2) {
  return p1 * p2;   
}

myFunction(4, 3);

//OBJECTS 
var car = {type:"Fiat", model:"500", color:"white"};







//PAGE 2
//Primitives 
string
number
boolean
undefined

//Null and Undefined 
var person = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue"};
person = null;    // Now value is null, but type is still an object

var person = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue"};
person = undefined;   // Now both value and type is undefined

//STRINGS
//As Objects 
Strings Can be Objects
Normally, JavaScript strings are primitive values, created from literals:

var firstName = "John";

But strings can also be defined as objects with the keyword new:

var firstName = new String("John");

//Methods 
var str = "Apple, Banana, Kiwi";
var res = str.slice(7, 13);
slice() extracts a part of a string and returns the extracted part in a new string.

substring() is similar to slice() The difference is that substring() cannot accept negative indexes.

var str = "Apple, Banana, Kiwi";
var res = str.substring(7, 13);

str = "Please visit Microsoft!";
var n = str.replace("Microsoft", "W3Schools");

//NUMBERS
var x = 123;
x.toString();            // returns 123 from variable x
(123).toString();        // returns 123 from literal 123


//ARRAY LOOPING
const array = ["one", "two", "three"]
array.forEach(function (item, index) {
  console.log(item, index);
});