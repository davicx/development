let intervals = [
    [1,3],
    [2,6],
    [8,10],
    [15,18]
]


merge(intervals);

var myArray = new Array();

function merge(intervals) {
    var masterIntervals = new Array();
    var intervalSize = 0;
    console.log(masterIntervals);

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
            console.log("FOUND  " + i + " " + masterIntervals[i] + " " + insideInterval);
            
        } else {
            insideInterval = false;
            endInterval = i - 1;
            console.log("NOPE " + insideInterval);
        }
       
    }

 

}

 


/*
console.log(intervals[0][1]);
console.log(intervals[1][1]);
console.log(intervals[2][1]);
console.log(intervals[3][1]);

console.log(intervals[2]);
console.log(intervals[3]);
*/