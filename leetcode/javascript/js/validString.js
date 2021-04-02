//"use strict";

function isValid(s) {

    var charMap = new Object();
    //var wildCardCount = 0;
    
    for (let i = 0; i < s.length; i++) {
        let currentChar = s.charAt(i);
    
        if (charMap.hasOwnProperty(currentChar) ) {
            //console.log("Has " + currentChar);
            charMap[currentChar] = charMap[currentChar] + 1;
            //wildCardCount++;
          
        } else {
            //console.log("Does not have " + currentChar);
            charMap[currentChar] = 1;
        }
        
    }
    
    //console.log(wildCardCount);

    return charMap
    
}


let s = "aabbccdd";
var charMapOutcome = isValid(s);
let firstLetter = s.charAt(0)
var divisor = charMapOutcome[firstLetter];


for (const [key, value] of Object.entries(charMapOutcome)) {
    console.log(`${key}: ${value}`);

    if(divisor / value == 1) {
        console.log("OK " + divisor + " " + value);

    } else {
        console.log("NO " + divisor + " " + value);

    }
    

}

console.log(charMapOutcome);














/*
charMap {
    character: count,
    'a': 2
}
*/


/*

let firstChar = 'a';
let secondChar = 'b';
let thirdChar = 'c';
charCount[firstChar] = 1;
charCount[secondChar] = 1;
charCount[thirdChar] = 2;

testChar = 'd'

//Value is in String
if (charCount.hasOwnProperty(testChar) ) {
    console.log("Has " + testChar);
    charCount[testChar] = map[testChar]++;
  
} else {
    console.log("Does not have " + testChar);
    charCount[testChar] = 1;
}

*/

/*
obj.hasOwnProperty("key") 

var stringCount = new Array();
myArray["name"] = "davey";
myArray["location"] = "corvallis";
myArray["tree"] = "apples";

//
if (map[key] == null) map[key] = 0;
map[key] = map[key]++;

map[key] = (map[key]+1) || 1 ;

*/