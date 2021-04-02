"use strict";
let s = "AABAAB"


var totalChanges = longestSubstringOptimized(s);   
console.log("ANSWER " + totalChanges);


function longestSubstringOptimized(s) {
    var totalChanges = 0;
    var currentChar;
    var nextChar;

    for (let i = 0; i < s.length; i++) {
        
        if(i + 1 != s.length) {
            currentChar = s.charAt(i);
            nextChar = s.charAt(i + 1);
            if(nextChar === currentChar) {
                totalChanges = totalChanges + 1;
            }     
        } 
    }

    return totalChanges;

}



function longestSubstring(s) {
    var totalChanges = 0;
    var currentChar;
    var nextChar;

    for (let i = 0; i < s.length; i++) {
        currentChar = s.charAt(i);
        if(i + 1 == s.length) {
            nextChar = "break"
        } else {
            nextChar = s.charAt(i + 1);
        }

        console.log("Current " + currentChar + " Next " + nextChar);

        //Perform Calc
        if (nextChar != "break") {

            if(nextChar === currentChar) {
                totalChanges = totalChanges + 1;

            }     

        //Your Done     
        } else {
            console.log("Done");
        }
    }
    return totalChanges;

}

function removeCharacter(str, char_pos) {
  part1 = str.substring(0, char_pos);
  part2 = str.substring(char_pos + 1, str.length);
  return (part1 + part2);
 }

