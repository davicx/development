"use strict";

//Two Pointer Array
var animals = ['Beaver', 'Deer ','Chipmunk','Badger', 'Cougar'];
let leftPointer = 0;
let rightPointer = animals.length - 1;

for (let i = 0; i < animals.length; i++) {
  leftPointer = i;
  console.log(animals[i] + " " + leftPointer + " " + rightPointer);
  if(leftPointer >= rightPointer ) {
    console.log("Break!");
    break;
  } 
  rightPointer = rightPointer - 1;
}



//Priority Q

//Map
var numbers = [1, 2, 3, 4];
var numbersSquared = numbers.map(squareNumber)

function squareNumber(num) {
  return num * num;
}

//console.log(numbers);
//console.log(numbersSquared);

//Filter
/*
var numbers = [1, 3, 6, 8, 11];

var lucky = numbers.filter(function(number) {
  return number > 7;
});
*/
//ARRAYS
/*
//concat() joins two or more arrays and returns a new array.
let myArray = new Array('1', '2', '3')
myArray = myArray.concat('a', 'b', 'c')
//myArray is now ["1", "2", "3", "a", "b", "c"]

//join(delimiter = ',') joins all elements of an array into a string.
let myArray = new Array('Wind', 'Rain', 'Fire')
let list = myArray.join(' - ') // list is "Wind - Rain - Fire"

//push() adds one or more elements to the end of an array and returns the resulting length of the array.
let myArray = new Array('1', '2')
myArray.push('3')  // myArray is now ["1", "2", "3"]

//pop() removes the last element from an array and returns that element.
let myArray = new Array('1', '2', '3')
let last = myArray.pop()
//myArray is now ["1", "2"], last = "3"

//shift() removes the first element from an array and returns that element.
let myArray = new Array('1', '2', '3')
let first = myArray.shift()
//myArray is now ["2", "3"], first is "1"

//unshift() adds one or more elements to the front of an array and returns the new length of the array.
let myArray = new Array('1', '2', '3')
myArray.unshift('4', '5')
// myArray becomes ["4", "5", "1", "2", "3"]

//slice(start_index, upto_index) extracts a section of an array and returns a new array.
let myArray = new Array('a', 'b', 'c', 'd', 'e')
myArray = myArray.slice(1, 4)  
// starts at index 1 and extracts all elements until index 3, returning [ "b", "c", "d"]

//splice(index, count_to_remove, addElement1, addElement2, ...) removes elements from an array and (optionally) replaces them. It returns the items which were removed from the array.
let myArray = new Array('1', '2', '3', '4', '5')
myArray.splice(1, 3, 'a', 'b', 'c', 'd')
// myArray is now ["1", "a", "b", "c", "d", "5"]

//reverse() transposes the elements of an array, in place: the first array element becomes the last and the last becomes the first. It returns a reference to the array.
let myArray = new Array('1', '2', '3')
myArray.reverse()
//transposes the array so that myArray = ["3", "2", "1"]

//sort() sorts the elements of an array in place, and returns a reference to the array.
let myArray = new Array('Wind', 'Rain', 'Fire')
myArray.sort()
 
//indexOf(searchElement[, fromIndex]) searches the array for searchElement and returns the index of the first match.
let a = ['a', 'b', 'a', 'b', 'a']
//console.log(a.indexOf('b'))     // logs 1
// Now try again, starting from after the last match
//console.log(a.indexOf('b', 2))  // logs 3
//console.log(a.indexOf('z'))     // logs -1, because 'z' was not found

//lastIndexOf(searchElement[, fromIndex]) works like indexOf, but starts at the end and searches backwards.
let a = ['a', 'b', 'c', 'd', 'a', 'b']
//console.log(a.lastIndexOf('b'))     // logs 5

//Now try again, starting from before the last match
//console.log(a.lastIndexOf('b', 4))  // logs 1
//console.log(a.lastIndexOf('z'))     // logs -1

*/
//forEach(callback[, thisObject]) executes callback on every array item and returns undefined.
//let a = ['a', 'b', 'c']
//a.forEach(function(element) { console.log(element) })
//logs each item in turn

/*
//map(callback[, thisObject]) returns a new array of the return value from executing callback on every array item.
let a1 = ['a', 'b', 'c']
let a2 = a1.map(function(item) { return item.toUpperCase() })
//console.log(a2) // logs ['A', 'B', 'C']

//filter(callback[, thisObject]) returns a new array containing the items for which callback returned true.
let a1 = ['a', 10, 'b', 20, 'c', 30]
let a2 = a1.filter(function(item) { return typeof item === 'number'; })
//console.log(a2)  // logs [10, 20, 30]

//every(callback[, thisObject]) returns true if callback returns true for every item in the array.
function isNumber(value) {
  return typeof value === 'number'
}
let a1 = [1, 2, 3]
//console.log(a1.every(isNumber))  // logs true

let a2 = [1, '2', 3]
//console.log(a2.every(isNumber))  // logs false

//some(callback[, thisObject]) returns true if callback returns true for at least one item in the array.
function isNumber(value) {
  return typeof value === 'number'
}
let a1 = [1, 2, 3]
//console.log(a1.some(isNumber))  // logs true
let a2 = [1, '2', 3]
//console.log(a2.some(isNumber))  // logs true
let a3 = ['1', '2', '3']
//console.log(a3.some(isNumber))  // logs false
*/


//ITERATE OVER ARRAY
let colors = ['red', 'green', 'blue']
colors.forEach(function(color) {
  //console.log(color)
})

//colors.forEach(color => console.log(color))

//NUMBERS
var biggestNum = Number.MAX_VALUE;
var smallestNum = Number.MIN_VALUE;
var infiniteNum = Number.POSITIVE_INFINITY;
var negInfiniteNum = Number.NEGATIVE_INFINITY;
var notANum = Number.NaN;

//DESTRUCTURING
var foo = ['one', 'two', 'three'];

// without destructuring
var one   = foo[0];
var two   = foo[1];
var three = foo[2];

// with destructuring
var [one, two, three] = foo;

//CLOSURES
//Closures
function addSquares(a, b) {
  function square(x) {
    return x * x;
  }
  return square(a) + square(b);
}

//Works
//console.log(addSquares(2, 3)); 

//Does not Work
//console.log(square(2)); 

//Name Conflicts- the Inner Scope takes precedence 


/*
Since a nested function is a closure, 
this means that a nested function can "inherit" the arguments and variables of its containing function. 
In other words, the inner function contains the scope of the outer function.

To summarize:
The inner function can be accessed only from statements in the outer function.
The inner function forms a closure: the inner function can use the arguments and variables of the outer function, 
while the outer function cannot use the arguments and variables of the inner function.
*/


//LABELS
/*
markLoop:
while (theMark === true) {
   doSomething();
}
 
let i = 0;
let j = 4;
checkiandj:
  while (i < 4) {
    console.log(i);
    i += 1;
    checkj:
      while (j > 4) {
        console.log(j);
        j -= 1;
        if ((j % 2) === 0) {
          continue checkj;
        }
        console.log(j + ' is odd.');
      }
      console.log('i = ' + i);
      console.log('j = ' + j);
  }
*/
//ERRORS
 
//Parsing
//parseInt()
//parseFloat()

/*
//Not Ok
let letAnswer = "hi";
let letAnswer = "hiya";
 
console.log(letAnswer);

//OK
var answer = 42;
var answer = 2;

console.log(answer);
*/

/* HOISTING */
/*
//Function declaration 
foo(); 

function foo() {
  console.log('bar');
}

// Function expression 
baz(); // TypeError: baz is not a function
var baz = function() {
  console.log('bar2');
};
*/