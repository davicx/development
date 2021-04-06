//Word Far = 327
//let n = 3662;
let n = 3212327;
let nString = n.toString();
//let words = ["far", "foo", "bar"];
let words = ["far"];
var numberLength = getlength(n);
var charMap = new Array();
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

//Create a Number Map
createNumberMap(n);
printNumberMap();

for (index in words) {
    currentWord = words[index];
    console.log("Word " + words[index]);
    //checkWord(currentWord, n, numberMap);
    //checkWord(currentWord, n);
}

checkWord("far")

function checkWord(word) {

    //Convert the word to a number
    let wordNumber = wordToNumber(word).toString();

    //Get all of its starting indexes
    let startingNumber = getWordRepresentation(wordNumber.charAt(0));
    console.log(startingNumber);
    let startingIndexArray = numberMap[startingNumber]; 
    console.log(startingIndexArray.sort());
    /*

    console.log(wordNumber + " " + nString.length);
    for (let i = 0; i < nString.length; i++) {
        
        for (let j = i; j < nString.length; j++) {
            currentChar = nString.charAt(j);

            //Loop over the Word Here 
            console.log(currentChar);
        }
        
        console.log("_________");
        //console.log(currentChar);
    }
    */
}



//Function 1.B: Convert the Number to a Map of where each Digit is located 
function createNumberMap(n) {
    stringNumber = String(n);
    let currentDigit = 100;
    let currentIndex = numberLength - 1;
    let key = "";
    
    //Loop Over the Number and Create a Map of the Digit and the Index where it is found 
    while(n > 0) { 
        currentDigit = n % 10;
        n = Math.floor( n / 10);
        //console.log(n + " " + currentDigit + " " + getWordRepresentation(currentDigit) + " [" + currentIndex + "]");
        key = getWordRepresentation(currentDigit);
        numberMap[key].push(currentIndex);
    
        currentIndex = currentIndex - 1;
    }
}
 
function getlength(number) {
    return number.toString().length;
}

function getWordRepresentation(number) {
    if(number == 1) {
        return "one";
    } else if (number == 2) {
        return "two";
    } else if (number == 3) {
        return "three";
    } else if (number == 4) {
        return "four";
    } else if (number == 5) {
        return "five";
    } else if (number == 6) {
        return "six";
    } else if (number == 7) {
        return "seven";
    } else if (number == 8) {
        return "eight";
    } else if (number == 9) {
        return "nine";
   } else {
        return "nan"
    }
}


function getNumberRepresentation(word) {
    if(word == "one") {
        return 1;
    } else if (word == "two") {
        return 2;
    } else if (word == "three") {
        return 3;
    } else if (word == "four") {
        return 4;
    } else if (word == "five") {
        return 5;
    } else if (word == "six") {
        return 6;
    } else if (word == "seven") {
        return 7;
    } else if (word == "eight") {
        return 8;
    } else if (word == "nine") {
        return 9;
   } else {
        return "nan"
    }
}

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

 
function printNumberMap() {
    console.log("One: " + numberMap['one']);
    console.log("two: " + numberMap['two']);
    console.log("three: " + numberMap['three']);
    console.log("four: " + numberMap['four']);
    console.log("five: " + numberMap['five']);
    console.log("six: " + numberMap['six']);
    console.log("seven: " + numberMap['seven']);
    console.log("eight: " + numberMap['eight']);
    console.log("nine: " + numberMap['nine']);
}
 
/*


//Convert the Word to a Number and Create the Number Map
let wordNumber = wordToNumber(words[0]);
createNumberMap(n);
//console.log("First Digit " + wordNumber);
//console.log("Wordnumber " + wordNumber.charAt(0));
let mapKey = getWordRepresentation(wordNumber.charAt(0))
//console.log("mapKey " + mapKey);
let indexMap = numberMap[mapKey];
//console.log("indexMap " + indexMap);

//Loop Over Array 
var currentChar;
var match = true; 

checkWord();

function checkWord() {
    indexMap.forEach(function (startingIndex, index) {
        var loopCount = 1;
        var charPosition = 0;
        for (let i = startingIndex; i < nString.length; i++) {
            matchNumber = nString.charAt(i);
            //console.log(matchNumber);
     
            
            currentChar = wordNumber.charAt(charPosition);
            matchNumber = nString.charAt(i);
            
            console.log(currentChar + " " + matchNumber);
            if(currentChar != matchNumber) {
                match = false;
                console.log("false");
            } else {
                console.log("match");
            }
     
            
            //Exit the Loop if you reach max loops
            if(loopCount >= wordNumber.length) {
                console.log("Reached Char max " + wordNumber.length);
                break;
    
            }
    
            charPosition = charPosition + 1;
            loopCount = loopCount + 1;
    
        }
        console.log("___________");
    
    
    });
    
}
*/
/*

for (let i = 0; i < wordNumber.length; i++) {
    currentChar = wordNumber.charAt(i);
    matchNumber = nString.charAt(i);
    
    console.log(currentChar + " " + matchNumber);
    if(currentChar != matchNumber) {
        match = false;
        console.log("false");
    } else {
        console.log("match");
    }
}
 
console.log(match);
*/
 

/*
 
        if(typeof numberMap[currentDigit] != 'undefined') {
            console.log("Has ");

        } else {
            console.log("This value is not there!");
        }

//var numberLength = getlength(n);
//console.log(numberLength);

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

 
 


for (let i = 0; i < numberMap['six'].length; i++) {
    console.log(numberMap['six'][i]);

}
*/
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






/*

//console.log(wordToNumber("foo"));
*/

