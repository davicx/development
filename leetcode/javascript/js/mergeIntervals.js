let intervals = [
    [1,3],
    [2,6],
    [8,10],
    [15,18]
]


merge(intervals);

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