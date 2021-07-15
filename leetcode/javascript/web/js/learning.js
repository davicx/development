//ASSOCIATIVE ARRAYS
var myArray = new Array();

myArray["name"] = "davey";
myArray["location"] = "corvallis";
myArray["tree"] = "apples";

//console.log(myArray);
//console.log(myArray["name"]);


//ARROW FUNCTIONS
//
function sum(a,b) {
    return a + b;
}

let sumTwo = (a,b) => {
    return a + b;
}

let sumThree = (a,b) => a + b

//
function isPositive(number) {
    return number >= 0;
}

isPositiveTwo = number => number >= 0

//
function randomNumber() {
    return Math.random;
}

let randomNumberTwo = () => Math.random

//Event Listener
/*
document.addEventListener('click', function() {
    console.log("click");
})

document.addEventListener('click', () => console.log("click"))
*/
class Person {
    constructor(name) {
        this.name = name;
    }

    printNameArrow() {
        setTimeout(() => {
            console.log('Arrow ' + this.name);
        }, 100)
    }
    
    printName() {
        setTimeout(function()  {
            console.log('Normal ' + this.name);
        }, 100)
    }

}

 
//CLASS
//Main
class User {
    location;

    constructor(name) {
        this.name = name;
    }

    day() {
        return "tuesday";
    }
}

let user = new User('david');
let userTwo = new User('Frodo');
user.location = "shire";
userTwo.location = "shire";


let myName = "davey"
const another = 
`hi ${ myName }
message`;

console.log(another);

/*
console.log(user.name)
console.log(user.location) 
console.log(user.location) 
console.log('%c Users', 'color: blue;') 
console.log( {user} ) 
console.table( [user, userTwo] ) 
*/

/*
//Timing
console.time('looper')

let i = 0;
while (i < 1000000) {
    i++;
}
console.timeEnd('looper')
*/

/*
//Type 1
var myCar = new Object();
myCar.make = 'Ford';
myCar.model = 'Mustang';
myCar.year = 1969;

//Type 2
var myCar = {
    make: 'Ford',
    model: 'Mustang',
    year: 1969
};

//List All Object Properties
function listAllProperties(o) {
	var objectToInspect;
	var result = [];

	for(objectToInspect = o; objectToInspect !== null;
           objectToInspect = Object.getPrototypeOf(objectToInspect)) {
        result = result.concat(
            Object.getOwnPropertyNames(objectToInspect)
        );
    }

	return result;
}

console.log(listAllProperties(myCar));
*/