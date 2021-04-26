"use strict";


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
console.log(addSquares(2, 3)); 

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