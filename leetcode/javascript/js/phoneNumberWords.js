n = 3662
words = ["foo", "bar"]

var charMap = new Array();

var numberMap = {

};

var numberMap = {
    one: [],
    two: [],
    three: [],
    four: [],
    five: [],
    six: [],
    seven: [],
    eight: [],
    nine: [],
};

let number = "three";  
let index = 0;
numberMap[number].push(index);

number = "six";  
index = 1;
numberMap[number].push(index);

number = "six";  
index = 2;
numberMap[number].push(index);

number = "two"; 
index = 3;
numberMap[number].push(index);

 
 
console.log("One: " + numberMap['one']);
console.log("two: " + numberMap['two']);
console.log("three: " + numberMap['three']);
console.log("four: " + numberMap['four']);
console.log("five: " + numberMap['five']);
console.log("six: " + numberMap['six']);
console.log("seven: " + numberMap['seven']);
console.log("eight: " + numberMap['eight']);
console.log("nine: " + numberMap['nine']);

for (let i = 0; i < numberMap['six'].length; i++) {
    console.log(numberMap['six'][i]);

}

/*
var numberMap = {
    one: [],
    two: [3],
    three: [0],
    four: [],
    five: [],
    six: [1,2],
    seven: [],
    eight: [],
    nine: [],
};
*/
 



//console.log(numberMap.one); 
//console.log(numberMap.one.push(5)); 
//console.log(numberMap.one); 

/*
var foo = {
  bar: ['foo', 'bar', 'baz']
};

// access
foo.bar[2]; // will give you 'baz' */
/*
numberMap[4] = [0];
numberMap[3] = [0,1];

console.log(numberMap[3]);
let index = numberMap[3].length;
//numberMap[3]= 77;
console.log(index)
console.log(numberMap[3].push(77));
console.log(numberMap[3]);
 */
//person.lastName;

/*

// define
var foo = {
  bar: ['foo', 'bar', 'baz']
};

// access
foo.bar[2]; // will give you 'baz'

var data = {
  name: "Ankit",
  age: 24,
  workingDay: ["Mon", "Tue", "Wed", "Thu", "Fri"]
};

for (const key in data) {
  if (data.hasOwnProperty(key)) {
    const element = data[key];
      console.log(key+": ", element);
  }
}

//var myObj = {a: 200, b: 300};
var numberMap = new Array();

numberMap[4] = [0];
numberMap[3] = [0,1];

//createNumberMap(n) 
numberMap[3] = [0];
numberMap[6] = [1,2];
numberMap[2] = [3];
console.log(numberMap[6]);
let tempArray = numberMap[6];

console.log(numberMap);
*/
/*
 
numberMap[3] = [0];
numberMap[6] = [1,2];
numberMap[2] = [3];
word = words[0];
if(typeof numberMap[1] != 'undefined') {
    console.log("Has ");
} else {
    console.log("This value is not there!");
}
 
*/


function createNumberMap(n) {
    stringNumber = String(n);
    let currentDigit = 100;
    let index = 0;

    //Loop Over the Number and Create a Map of the Digit and the Index where it is found 
    while(n > 0) { 
        currentDigit = n % 10;
        n = Math.floor( n / 10);
        console.log(n + " " + currentDigit);

        if(typeof numberMap[currentDigit] != 'undefined') {
            console.log("Has ");

        } else {
            console.log("This value is not there!");
        }

        index = index + 1;

    }
}




/*

//console.log(wordToNumber("foo"));
*/

//Function 1.A: Convert a Word to a Phone Number Representation 
function wordToNumber(word) { 
    let numberWord = "";
    charMap['a'] = 2;
    charMap['b'] = 2;
    charMap['c'] = 2;
    charMap['d'] = 3;
    charMap['e'] = 3;
    charMap['f'] = 3;
    charMap['g'] = 4;
    charMap['h'] = 4;
    charMap['i'] = 4;
    charMap['j'] = 5;
    charMap['k'] = 5;
    charMap['l'] = 5;
    charMap['m'] = 6;
    charMap['n'] = 6;
    charMap['o'] = 6;
    charMap['p'] = 7;
    charMap['q'] = 7;
    charMap['r'] = 7;
    charMap['s'] = 7;
    charMap['t'] = 8;
    charMap['u'] = 8;
    charMap['v'] = 9;
    charMap['w'] = 9;
    charMap['x'] = 9;
    charMap['y'] = 9;
    charMap['z'] = 9;

    for (let i = 0; i < word.length; i++) {
        currentChar = word.charAt(i);
        currentNum = String(charMap[currentChar]);
        numberWord = numberWord + currentNum;
    }

    return numberWord;
}