var stuff = require('./count');
var events = require('events')
var util = require('util')
var fs = require('fs');
var http = require('http')
const { myMultiply } = require('./count');



//Video 19: Routing
var server = http.createServer(function(req, res) {
    console.log('request was made ' + req.url);
   
    if(req.url === '/home' || req.url === '/') {
        res.writeHead(200, {'Content-Type' : 'text/html'});
        fs.createReadStream(__dirname + '/index.html').pipe(res);
    } else if (req.url === '/contact') {
        res.writeHead(200, {'Content-Type' : 'text/html'});
        fs.createReadStream(__dirname + '/contact.html').pipe(res);        
    } else if (req.url === '/api/people') {
        var myUser = {
            name: 'david',
            last: 'v',
            city: 'corvallis',
        }

        var myUserTwo = {
            name: 'david',
            last: 'v',
            city: 'corvallis',
        }
        var users = [myUser, myUserTwo]
        res.writeHead(200, {'Content-Type' : 'application/json'})
        res.end(JSON.stringify(users))

    } else {
        res.writeHead(404, {'Content-Type' : 'text/html'});
        fs.createReadStream(__dirname + '/404.html').pipe(res);             
    }

});

server.listen(3000, '127.0.0.1');



//Video 18: JSON
/*
var server = http.createServer(function(req, res) {
    console.log('request was made ' + req.url);
    res.writeHead(200, {'Content-Type' : 'application/json'});
    var myUser = {
        name: 'david',
        last: 'v',
        city: 'corvallis',
    }

    res.end(JSON.stringify(myUser));

});

server.listen(3000, '127.0.0.1');
*/

//Video 16: HTML
/*
var server = http.createServer(function(req, res) {
    console.log('request was made ' + req.url);
    res.writeHead(200, {'Content-Type' : 'text/html'});
    var myReadStream = fs.createReadStream(__dirname + '/index.html', 'utf8');
    myReadStream.pipe(res)
    

});

server.listen(3000, '127.0.0.1');

*/



//Video 14 and 15: Readable Stream
/*
var myWriteStream = fs.createWriteStream(__dirname + '/writeMe.txt')


var myReadStream = fs.createReadStream(__dirname + '/readMe.txt', 'utf8');

myReadStream.on('data', function(chunk) {
    console.log('data recieved');
    myWriteStream.write(chunk);
})

*/


//VIDEO 11: Clients and Servers
/*
var server = http.createServer(function(req, res) {
    console.log('request was made ' + req.url);
    res.writeHead(200, {'Content-Type' : 'text/plain'});
    res.end('hiya!');

});

server.listen(3000, '127.0.0.1');

console.log('Listening 3000');
*/
//VIDEO 10: Create and Remove Directory
//Sync
//Create
//fs.mkdirSync('stuff')
//Remove
//fs.rmdirSync('stuff')

//Async
/*
fs.mkdir('stuff', function(){
    fs.readFile('readme.txt', 'utf8', function(err, data) {
        fs.writeFileSync('./stuff/writeMe.txt', data);
    })
})
*/


//VIDEO 9: Reading and Writing Files (Reading a File is Binary Data)
//Sync
//var myText = fs.readFileSync('readMe.txt', 'utf8')
//fs.writeFileSync('writeMe.txt', myText)

//Async
//Need a Callback function when complete (now this is non-blocking code)
/*
fs.readFile('readMe.txt', 'utf8', function(err, data){
    console.log(data);
    fs.writeFileSync('writeMe.txt', data)

});

console.log('test')
*/
//Delete
//fs.unlink('writeMe.txt');


















//VIDEO 8: Events
//Type 2:
var Person =function(name){
    this.name = name;
}

//(Inherit, the event emmiter)
util.inherits(Person, events.EventEmitter);

var david = new Person('david')
var frodo = new Person('frodo')
var bilbo = new Person('bilbo')

var people = [david, frodo, bilbo]

//Loop over people
people.forEach(function(person) {
    person.on('speak', function(message) {
        console.log(person.name + ' said ' + message);
    })
});

//david.emit('speak', 'hiya!')

//Type 1: Events
/*
var myEmmitter = new events.EventEmitter();

myEmmitter.on('someEvent', function(message){
    console.log(message);
});

myEmmitter.emit('someEvent', 'my own message!')
*/



//VIDEO 6: Modules and Require 
//console.log(stuff.counter(['david', 'bilbo', 'frodo', 'sam']));
//console.log(stuff.myAdd(5,6));
//console.log(stuff.myAdd(stuff.pi, 6));
//console.log(stuff.mySubtract(8, 6));
//console.log(stuff.myMultiply(3, 5));



//VIDEO 5: Function Expressions
//Normal
function sayHi() {
    console.log("hi");
}

//sayHi();

//Function Expressions
var sayBye = function(){
    console.log("bye");
};

//sayBye();

//Passing Functions
function callFunction(fun) {
    fun();
}

//callFunction(sayHi);

//VIDEO 4: Global Object 
var time = 0;
/*
//Directory
console.log(__dirname);
console.log(__filename);

//Timer
var timer = setInterval(function() {
    time += 1;
    //console.log(time + " Seconds ");

    if(time > 5) {
        clearInterval(timer)
    }
    
}, 1000)
*/
 
