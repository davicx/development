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

//SORT 2D ARray
var ab = [[12, 'AAA'], [58, 'BBB'], [28, 'CCC'],[18, 'DDD']];

ab.sort(sortFunction);

function sortFunction(a, b) {
    if (a[0] === b[0]) {
        return 0;
    }
    else {
        return (a[0] < b[0]) ? -1 : 1;
    }
}

ab.sort(compareSecondColumn);

function compareSecondColumn(a, b) {
    if (a[1] === b[1]) {
        return 0;
    }
    else {
        return (a[1] < b[1]) ? -1 : 1;
    }
}

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


//APPENDIX
/*
//ARRAYS
//Normal Array 
var animals = ['Beaver', 'Deer ','Chipmunk','Badger'] 

//Set
const mySet1 = new Set()
mySet1.add(1)            
mySet1.add(2)           

//Associative Array
var myArray = new Array();
myArray["name"] = "davey";
myArray["location"] = "corvallis";
myArray["tree"] = "apples";

for (var key in myArray) {
    if (myArray.hasOwnProperty(key)) {
        //console.log(key + " " + myArray[key]);
    }
} 

var myObject = {
    "name": "davey",
    "location": "corvallis",
    "tree": "apples"
};

//Print Key and Values in an Object 
for (var key in myObject) {
    if (myObject.hasOwnProperty(key)) {
        //console.log(key + " " + myObject[key]);
    }
} 

//DATA STRUCTURES
//Loop Over Array
for (let i = 0; i < animals.length; i++) {
    //console.log(animals[i]);
}

//Loop Over String
let s = "hi";
for (let i = 0; i < s.length; i++) {
    currentChar = s.charAt(i);
}

//While Loop
let a = 1;
while (a < 10) {
    a++;
}

//Stack
var stack = [];
stack.push(2);       // stack is now [2]
stack.push(5);       // stack is now [2, 5]
var current_item = stack.pop(); // stack is now [2]
//console.log(current_item);            // displays 5

//Queue
var queue = [];
queue.push(2);         // queue is now [2]
queue.push(5);         // queue is now [2, 5]
var current_item = queue.shift(); // queue is now [5]
//console.log(current_item);        // displays 2

//FUNCTIONS
function addTwo(a, b) {
    return a + b;
}

//Function Expression
const subtractNumbers = function(x, y) {
    return x - y;
};

//console.log(subtractNumbers(7, 4));
  
//Named function expression: Using the ECMAScript 2015 arrow notation
const hello = (val) => "Hello " + val;
//console.log(hello("Universe!"));

//const myArrowFunction = (a, b) => {a + b};
//console.log(myArrowFunction(2,2));

//CLASS
//Classes
class Rectangle {
    constructor(height, width) {
      this.height = height;
      this.width = width;
    }
    
    //Getter
    get area() {
      return this.calcArea();
    }
  
    //Method
    calcArea() {
      return this.height * this.width;
    }
}


//Create an Object 
const user = { first: 'david', last: 'v', city: 'corvallis'}

//Type 1: Loop over the object 
for (const key in user) {
    if (user.hasOwnProperty(key)) {
        //console.log(user[key]);
    }
}

//Type 2: Unwrap the the Values (keep the order of the keys)
for (const val of Object.values(user)) {
    //console.log(val);
}

//Object in an Object 
const post_one = {post_id: 1, post_type: "photo"}
const post_two = {post_id: 2, post_type: "video"}
var post_array = [post_one, post_two] 
const user_two = { user: 'davey', posts: post_one}

for (const val of Object.values(user_two)) {
    //console.log(val);
}

//console.log(user_two.posts.post_id)

//Associative Array of Objects
var objectsArray = new Array();
objectsArray["post_one"] = post_one;
objectsArray["post_two"] = post_two;

for (post in objectsArray) {
    if (objectsArray.hasOwnProperty(post)) {
        //console.log("POST " + objectsArray[post].post_id + " " + objectsArray[post].post_type);
    }
}



//Array of Values
var hobbiton = ["frodo", "sam"];
var bree = ["merry", "pippin"];
var minas_tirith = ["aragon", "faramir"];
var dol_amroth = ["elendil"];

//Associative Array with a list as value
var shire = {
    "hobbiton": hobbiton,
    "bree": bree
};

var gondor = {
    "minas_tirith": minas_tirith,
    "dol_amroth": dol_amroth
};

//Loop over Associative Array
for (var key in shire) {
    if (shire.hasOwnProperty(key)) {
        //console.log("PLACE: " + key);
        let shirePeople = shire[key];
        //console.log(key + " " + shire[key]);
        for(let i = 0; i < shirePeople.length; i++) {
            //console.log(shirePeople[i]);
        }
        //console.log("");
    }
} 

//World Map
var middle_earth = {
    "shire": shire,
    "gondor": gondor,
}

for (var key in middle_earth) {

    //Out Loop: All the Places in the World
    if (middle_earth.hasOwnProperty(key)) {  
        let place = middle_earth[key];
        
        //Inner Loop
        for (var place_key in place) {
            if (place.hasOwnProperty(place_key)) {
                //console.log("PLACE: " + place_key);
                let peopleList = place[place_key];

                //Loop Over the List
                for(let i = 0; i < peopleList.length; i++) {
                    //console.log(peopleList[i]);
                }
            }
            //console.log("");
        }
    }
} 


//JSON
//JSON.parse(text)
//JSON.stringify(object)







//LOOPS
//var animals = ['Badger', 'Beaver', 'Chipmunk',]
//Loop 1
for (let i = 0; i < animals.length; i++) { 
  //console.log(animals[i]);
} 


//Loop 2 (iterate over array)
for (const animal of animals ) { 
  //console.log(animal);
} 


//Loop 3: For Each Loop (Pass a callback function for every item in the array)
animals.forEach(makeLowercase);

function makeLowercase(animal) {
  //console.log(animal.toLowerCase());
  return animal.toLowerCase();
}

//Loop 4: Use Map array and make changes to it 
let animalLengths = animals.map(function(animal, index, array) {
  let len = animal.length
  return len;
});

//console.log(animalLengths);



//Type 3: Create a Map

const userMap = new Map(
  Object.entries(user)
);


for (const v of userMap.values()) {
  console.log(v)
}

//JSON
//Text
var usersAsText = '{ "users" : [' +
'{ "firstName":"david" , "lastName":"v" },' +
'{ "firstName":"bilbo" , "lastName":"baggins" },' +
'{ "firstName":"Frodo" , "lastName":"baggins" } ]}';

var users = JSON.parse(usersAsText);

//console.log(users);




//CONSOLE
//console.time()
//console.timeEnd()


*/