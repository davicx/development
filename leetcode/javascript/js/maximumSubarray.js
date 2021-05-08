//Two Pointer Array
//let nums = [-2,2,5,-11,6];
//let nums = [1,2,3,4];
let nums = [-1];

let maxSum = maxSubArray(nums);
console.log("ANSWER " + maxSum);


function maxSubArray(nums) {
    var maxSum = -Number.MAX_VALUE;
    let currentSum = 0;

    for (let leftPointer = 0; leftPointer < nums.length; leftPointer++) {
        console.log("Loop Start " + maxSum);
        for (let rightPointer = leftPointer; rightPointer < nums.length; rightPointer++) {
            currentSum = currentSum + nums[rightPointer];
            //console.log(nums[leftPointer] + " " + nums[rightPointer]);
            
            maxSum = Math.max(maxSum, currentSum);
            console.log("Max " + maxSum + " Current " + currentSum);
        }
        //console.log("");
        currentSum = 0;
        
    }
    return maxSum;
}

//console.log(Math.max(Number.MIN_VALUE + 1000, -1));
