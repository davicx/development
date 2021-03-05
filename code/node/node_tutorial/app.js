var stuff = require('./stuff');
var events = require('events');
var util = require('util');
var fs = require('fs');


//LESSON 10: Clients






console.log("hi");











//LESSON 9: File Work
//Synchronous
//fs.rmdirSync('user_uploads')
//fs.unlink('readMe.txt');

//Asynchronous
/*
fs.mkdir('user_uploads', function() {
    fs.readFile('readMe.txt', 'utf8', function(err, data){
        fs.writeFile('./user_uploads/writeMe.txt', data);
    });
});
*/
//fs.unlink('readMe.txt');




/*
//This is blocking code will readfull file before moving on!
var sample = fs.readFileSync('readMe.txt','utf8');

//This is not blocking now!
var sample = fs.readFileSync('readMe.txt','utf8', function(err, data) {
    fs.writeFileSync('writeMe.txt', data);

    console.log(data);
});

console.log(sample);

//fs.writeFileSync('output.txt', sample);

*/




//EVENT EMITTER
/*
//Making a person inherit the event emitter 
var Person = function(name) {
    this.name = name;
}

//(object, what it is inheriting)
util.inherits(Person, events.EventEmitter);

var david = new Person("david");
var bilbo = new Person("frodo");
var frodo = new Person("bilbo");

var people = [david, bilbo, frodo];

//Attach Events
people.forEach(function(person) {
    person.on('speak', function(message){
        console.log(person.name + " said " + message)
    });
});

david.emit('speak', 'hiya!')
*/



//On Click Custom Events
/*
var myEmitter = new events.EventEmitter();

myEmitter.on('someEvent', function(message){
    console.log(message);
});

myEmitter.emit('someEvent', 'hiya david!');
*/








//LESSON: 7
/*
function callFunction(fun) {
    fun();
}

var sayBye = function() {
	console.log("bye");	
};

function sayHi(){
	console.log("hi");
	
}

userArray = ['david', 'frodo', 'bilbo'];

console.log(stuff.counter(userArray));
console.log(stuff.adder(4,3));
console.log(stuff.bi);
*/

//LESSON: 5
//callFunction(sayBye);
//sayHi();
//sayBye();


/*
console.log("hi");

var time = 0;
console.log(__dirname);
console.log(__filename);

setTimeout(function(){
    time +=2;

    console.log(time + " 3 seconds");
}, 3000);

*/