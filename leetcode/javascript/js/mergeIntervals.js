/*
let intervals = [
    [1,3],
    [2,6],
    [8,10],
    [15,18]
]
*/

let intervals = [
    [1,3],
    [2,4],
    [7,8]
]

var masterIntervals = createSingleArray(intervals)
var masterArrays = new Array();

//Loop Over Single Interval
let currentValue;
for (let i = 0; i < masterIntervals.length; i++) {
    if(typeof masterIntervals[i] == 'undefined') {
        console.log("[" + i + "] F");
        currentValue = "F";
    } else {
        console.log("[" + i + "] " + masterIntervals[i]);
        currentValue = "T";
    }
}




function createSingleArray(intervals) { 
    let singleArray = new Array();
    for (let i = 0; i < intervals.length; i++) {
        let intervalStart = intervals[i][0] 
        let intervalEnd = intervals[i][1] 
        //console.log("Array Index: [" + i + "] " + intervalStart + " " + intervalEnd);
        for (let j = intervalStart; j <= intervalEnd; j++) {
            singleArray[j] = "T";
            //intervalSize = Math.max(j, intervalSize);
        }        
        //console.log("______");
    }     
    return singleArray;

}


//OLD 
var babyArray = new Array();
let insideInterval = false;


//console.log("LENGTH " + masterArrays.length);
for (let i = 0; i < masterIntervals.length; i++) {
    if(typeof masterIntervals[i] == 'undefined') {
        //console.log("[" + i + "] F");
        currentValue = "F";
    } else {
        //console.log("[" + i + "] " + masterIntervals[i]);
        currentValue = "T";
    }
    babyArray = [1 + i, 4 + i];

    //Case 1: Not in Subarray
    if(currentValue == "F" && insideInterval == false) {
        insideInterval = false;
        //console.log("[" + i + "] " + currentValue + " insideInterval " + insideInterval);


    //Case 2: Start Subarray
    } else if(currentValue == "T" && insideInterval == false) {
        insideInterval = true; 
        //console.log("[" + i + "] " + currentValue + " insideInterval " + insideInterval);    
   
    //Case 3: Inside Subarray
    } else if(currentValue == "T" && insideInterval == true) {
        insideInterval = true;
        //console.log("[" + i + "] " + currentValue + " insideInterval " + insideInterval);    

    //Case 4: Close Subarray
    } else if(currentValue == "F" && insideInterval == true || i == masterIntervals.length - 1) {
        insideInterval = false;
        //console.log("[" + i + "] "+ currentValue + " insideInterval " + insideInterval);  

    //Case 5: All Else
    } else {

    } 
    //masterArrays.push(babyArray);
    //babyArray = [];
    
    /*
    //Not Needed


    if(typeof masterIntervals[i] == 'undefined') {
        currentValue = "F";
        //insideInterval = false;
        //console.log("[" + i + "] F");
    } else {
        currentValue = "T";
        //insideInterval = true;
        //console.log("[" + i + "] " + masterIntervals[i]);
    }

    //Case 1: Not in Subarray
    if(currentValue == "F" && insideInterval == false) {
        console.log("Case 1");
        insideInterval = false;

    //Case 2: Start Subarray
    } else if(currentValue == "T" && insideInterval == false) {
        //console.log("Case 2");
        insideInterval = true;
        babyArray[0] = i;

    //Case 3: Inside Subarray
    } else if(currentValue == "T" && insideInterval == true) {
        //console.log("Case 3");
        insideInterval = true;

    //Case 4: Close Subarray
    } else if(currentValue == "F" && insideInterval == true || i == masterIntervals.length - 1) {
        //console.log("Case 4");
        insideInterval = false;
        babyArray[1] = i;
        //console.log(babyArray);
        masterArrays.push(babyArray);
        

    //Case 5: All Else
    } else {

    } 
  


    //Final Case: Last Element in Array 
    if(i == masterIntervals.length - 1) {
        //console.log("End of Array " + i + " " + masterIntervals[i]);
        //babyArray[1] = i;
        
    }

console.log("LENGTH " + masterArrays.length);
console.log("ARRAY "  + masterArrays[0]);
 
    */
 
 
}  
 

/*
var testmasterArrays = new Array();

let arr1 = [2,3];
let arr2 = [4,7];
let arr3 = [7,9];
let arr4 = [9,12];

testmasterArrays.push(arr1);
testmasterArrays.push(arr2);
testmasterArrays.push(arr3);
testmasterArrays.push(arr4);

for (let k = 0; k < testmasterArrays.length; k++) {
    console.log(testmasterArrays[k][0] + " " + testmasterArrays[k][1]);
}
*/


//merge(intervals);

function merge(intervals) {
    var masterIntervals = new Array();
    var intervalSize = 0;

    for (let i = 0; i < intervals.length; i++) {
        let intervalStart = intervals[i][0] 
        let intervalEnd = intervals[i][1] 
        //console.log(i + " " + intervalStart + " " + intervalEnd);

        for (let j = intervalStart; j <= intervalEnd; j++) {
            masterIntervals[j] = "T";
            intervalSize = Math.max(j, intervalSize);
        }        
        //console.log("______");
    }     


    //Create the Answer
    const intervalFound = "T";
    for (let i = 0; i <= intervalSize; i++) {
        let insideInterval = false;
        let startInterval;
        let endInterval;

        if(intervalFound.localeCompare(masterIntervals[i]) == 0) {
            insideInterval = true;
            startInterval = i;
            //console.log("FOUND  " + i + " " + masterIntervals[i] + " " + insideInterval);
            
        } else {
            insideInterval = false;
            endInterval = i - 1;
            //console.log("NOPE "  + i + " " + masterIntervals[i] + " " + insideInterval);
        }
    }

    //Solve the Problem
    var masterAnswer = new Array();
    let previous = "F";

    for (let i = 0; i <= masterIntervals.length; i++) {
        let intervalCheck = "T";
        
        //Create the SubArray
        if(intervalCheck.localeCompare(masterIntervals[i]) == 0) {
            console.log(i + " " + masterIntervals[i] + " Found");
        } else {
            console.log(i + " " + masterIntervals[i] + " Nope");
        }

        //Add this to the master answer Array 
    
    }


}


//Nested Objects
/*
var myArray = new Array();
let shire = ["david", "frodo", "sam"];
let rohan = ["aragon", "gimli"];
let rivendel = ["elendil", "galadriel"];

myArray[0] = shire;
myArray[1] = rohan;
myArray.push(rivendel);

for (let i = 0; i < myArray.length; i++) {
 
    for (let j = 0; j < myArray[i].length; j++) {
        console.log(myArray[i][j])
    }
    console.log(" ")
}
 
*/