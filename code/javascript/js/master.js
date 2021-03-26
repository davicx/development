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


//DATA STRUCTURES 
//Stack
var stack = [];
stack.push(2);       // stack is now [2]
stack.push(5);       // stack is now [2, 5]
var current_item = stack.pop(); // stack is now [2]
console.log(current_item);            // displays 5

//Queue
var queue = [];
queue.push(2);         // queue is now [2]
queue.push(5);         // queue is now [2, 5]
var current_item = queue.shift(); // queue is now [5]
console.log(current_item);        // displays 2

//FUNCTIONS





/* SORT */





//LOOPS
//Loop Over String
for (let i = 0; i < s.length; i++) {
    currentChar = s.charAt(i);
}

//While Loop
while (a < 10) {
    a++;
}

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
 
//OBJECT LOOPS 
const user = { first: 'david', last: 'v', city: 'corvallis'}
console.log(user);

//Type 1
for (const key in user) {
    if (user.hasOwnProperty(key)) {
        console.log(user[key]);
    }
}


//Type 2: Unwrap the the Values (keep the order of the keys)
for (const val of Object.values(user)) {
    console.log(val);
}


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

console.log(users);

//FUNCTIONS
function addTwo(a, b) {
    return a + b;
}

//OBJECTS


//CONSOLE
//console.time()
//console.timeEnd()


