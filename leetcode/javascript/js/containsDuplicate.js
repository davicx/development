//var nums = [1,2,3,1]
var nums = [1,2,3,4]

function containsDuplicate(nums) {
    //const mySet = new Set(nums)
 
    var mySet = new Set();
    
    for (let i = 0; i < nums.length; i++) {
        mySet.add(nums[i]);
        console.log(nums[i]);
        console.log(mySet);
    }
 
    console.log(mySet.size + " " + nums.length);

    if(mySet.length != nums.length) {
        //
        return true;

    } else {
       //console.log("NO Duplicate");
        return false;

    }
 
}
 
console.log(containsDuplicate(nums));


/*
var letterMap = new Object();

charOne = "a";
if (letterMap.hasOwnProperty(charOne) ) {
    letterMap[charOne] = letterMap[charOne] + 1;
} else {
    letterMap[charOne] = 1;
}

charTwo = "b";
if (letterMap.hasOwnProperty(charTwo) ) {
    letterMap[charTwo] = letterMap[charTwo] + 1;
} else {
    letterMap[charTwo] = 1;
}

charThree = "a";
if (letterMap.hasOwnProperty(charThree) ) {
    letterMap[charThree] = letterMap[charThree] + 1;
} else {
    letterMap[charThree] = 1;
} 

console.log(letterMap);
*/

/*

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


*/