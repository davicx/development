//var nums1 = [1,2]
//var nums2 = [3,4]
var nums1 = [1,3,4] 
//var nums1 = [1,3] 
var nums2 = [2,5,6] 
 
const nums3 = nums1.concat(nums2);

console.log(nums3);

function findMedian(nums1, nums2) {

    var newArray = [];
    let firstArrayElement = nums1[0];
    let secondArrayElement = nums2[0];
    

    while(nums1.length > 0 || nums2.length > 0) {
        numOne = nums1[0];
        numTwo = nums2[0];

        if(numOne < numTwo) {
            newArray.push(numOne);
            nums1.shift();
        } else {
            newArray.push(numTwo);
            nums2.shift();
        }

        console.log(numOne + " " + numTwo);
    }

    console.log(newArray);

}



/*
while(nums1.length != 0 && nums2 !=0 ) {
    
    if(nums1.length < 1 || nums1 == undefined) {

    } else {
        item = nums1.shift()
        console.log(item);
    }
    
    if(nums2.length < 1 || nums2 == undefined) {

    } else {
        itemTwo = nums1.shift()
        console.log(itemTwo);
    }
 
}
*/


/*
var fruits = ["Banana", "Orange", "Apple", "Mango"];
 
var item = fruits.shift();
fruits.shift();
fruits.shift();
console.log(item)
 */
/*
nums1.shift()
console.log(nums1)
nums1.shift()
console.log(nums1)
nums1.shift()
console.log(nums1)
*/
/*

*/
//console.log(nums1);

/*
console.log(firstArrayElement);
console.log(secondArrayElement);

nums2.shift();
console.log(nums2);
*/
/*
function findMedianSortedArrays(nums1, nums2) {
    nums1Length = nums1.length();
    nums2Length = nums2.length();

    return nums1Length + nums2Length;

}


//console.log(findMedianSortedArrays(nums1, nums2));
 

function getMiddlePosition(number) {
    return Math.ceil(number / 2);
}



//sortArrays(nums1, nums2) 
function sortArrays(nums1, nums2) {
    let mergedArray = [];
    let arrayOneIndex = 0;
    let arrayTwoIndex = 0;

    while(nums1.length != 0 || nums2.length != 0) {
        //console.log(nums1.pop());
        //console.log(nums1.pop());
        nums2.pop();
        nums1.pop();
        console.log(nums1);
        console.log(nums2);
    }
    console.log("LENGTH 1 " + nums1.length);
    console.log("LENGTH 2 " + nums2.length);
 
}


//sortArrays(nums1, nums2)
*/