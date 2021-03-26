"use strict";
 
var s = "abcb";

function lengthOfLongestSubstring(s) {
    let leftPointer = 0;
    let rightPointer = 0;
    let currentChar;
    var charQueue = [];
    var charSet = new Set()

    for (let i = 0; i < s.length; i++) {
        currentChar = s.charAt(i);
        rightPointer +=  1;

        while(charSet.has(currentChar)) {
            console.log(s.charAt(leftPointer));
            charSet.delete(s.charAt(leftPointer))
            leftPointer +=  1;
            
        }
        charSet.add(currentChar);
        console.log("rightPointer: " + rightPointer + " leftPointer:  " + leftPointer + " Char " + currentChar);
    }
 
 
    console.log(charSet);

    return s;
}
 
lengthOfLongestSubstring(s);


/*
if(charSet.has(currentChar)) {
    console.log(currentChar + " already there");
} else {
    console.log(currentChar);
    charSet.add(currentChar);
}
*/
/*
leftPointer = leftPointer + 1;
queue.push(2);         // queue is now [2]
queue.push(5);         // queue is now [2, 5]
var current_item = queue.shift(); // queue is now [5]
console.log(current_item);        // displays 2

*/
 

