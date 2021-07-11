//VARIABLES
var variableVar = "Global"
let variableLet = "Block Scope, Declared before use"
const variableConst = "Constant, Block Scope, Cannot be Reassigned"
 
//ARRAYS
var animals = ['Beaver', 'Deer ','Chipmunk','Badger'] 

const mySet = new Set()
mySet1.add(1)            
mySet1.add(2)           

var myArray = new Array();
myArray["name"] = "davey";
myArray["location"] = "corvallis";
myArray["tree"] = "apples";

for (var key in myArray) {
    if (myArray.hasOwnProperty(key)) {
        console.log(key + " " + myArray[key]);
    }
} 

var myObject = {
    "name": "davey",
    "location": "corvallis",
    "tree": "apples"
};

for (var key in myObject) {
    if (myObject.hasOwnProperty(key)) {
        console.log(key + " " + myObject[key]);
    }
} 

//DATA STRUCTURES
for (let i = 0; i < animals.length; i++) {
    console.log(animals[i]);
}

let s = "hi";
for (let i = 0; i < s.length; i++) {
    currentChar = s.charAt(i);
}

let a = 1;
while (a < 10) {
    a++;
}

for (const animal of animals ) { 
    console.log(animal);
} 

var stack = [];
stack.push(2);       // stack is now [2]
stack.push(5);       // stack is now [2, 5]
var current_item = stack.pop(); // stack is now [2]
//console.log(current_item);            // displays 5

var queue = [];
queue.push(2);         // queue is now [2]
queue.push(5);         // queue is now [2, 5]
var current_item = queue.shift(); // queue is now [5]
console.log(current_item);        // displays 2

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

//FUNCTIONS
function addTwo(a, b) {
    return a + b;
}

const subtractNumbers = function(x, y) {
    return x - y;
};
console.log(subtractNumbers(7, 4));
  
//Arrow Functions
const hello = (val) => "Hello " + val;
console.log(hello("Universe!"));

const myArrowFunction = (a, b) => {a + b};
console.log(myArrowFunction(2,2));

//For Each 
animals.forEach(makeLowercase);
function makeLowercase(animal) {
    console.log(animal.toLowerCase());
    return animal.toLowerCase();
}

//Filter
var numbers = [1, 3, 6, 8, 11];

var lucky = numbers.filter(function(number) {
  return number > 7;
});

//CLASS
//Classes
class Post {
    constructor(postID) {
        this.postID = postID;
        this.postFrom = "";
        this.postTo = "";
        this.postCaption = "";
    }
  
    //Getter
    get postCaption() {
      return this._postCaption;
    } 
  
    //Setter
    set postCaption(newCaption) {
      this._postCaption = newCaption;
    }
  
    getPostInfo() {
        console.log("Post " + this.postID + " " + postFrom + " " + postTo);  
    }
  
    //Method A2: Get User Info 
    static postText(caption)  {
        console.log("You made a post! " + caption);
    }
  }
  
  let currentPost = new Post(1);
  console.log(currentPost.postID);
  console.log(currentPost.postID);
  currentPost.postCaption = "hiya!"
  console.log(currentPost.postCaption)
  
//Create an Object 
const user = { first: 'david', last: 'v', city: 'corvallis'}

//Type 1: Loop over the object 
for (const key in user) {
    if (user.hasOwnProperty(key)) {
        console.log(user[key]);
    }
}

//Type 2: Unwrap the the Values (keep the order of the keys)
for (const val of Object.values(user)) {
    console.log(val);
}

//Object in an Object 
const post_one = {post_id: 1, post_type: "photo"}
const post_two = {post_id: 2, post_type: "video"}
var post_array = [post_one, post_two] 
const user_two = { user: 'davey', posts: post_one}

for (const val of Object.values(user_two)) {
    console.log(val);
}

console.log(user_two.posts.post_id)

//Associative Array of Objects
var objectsArray = new Array();
objectsArray["post_one"] = post_one;
objectsArray["post_two"] = post_two;

for (post in objectsArray) {
    if (objectsArray.hasOwnProperty(post)) {
        console.log("POST " + objectsArray[post].post_id + " " + objectsArray[post].post_type);
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
        console.log("PLACE: " + key);
        let shirePeople = shire[key];
        console.log(shirePeople);
        
        for(let i = 0; i < shirePeople.length; i++) {
            console.log(shirePeople[i]);
        }
    }
} 


//JSON
JSON.parse(text)
JSON.stringify(object)

//LOOPS 

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
