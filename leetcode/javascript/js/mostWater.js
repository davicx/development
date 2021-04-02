//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
var height = [1,8,6,2,5,4,8,3,7] 
//var height = [4,3,2,1,4]


function maxArea(height) {
    var maxArea = 0;
    var leftIndex = 0;
    var rightIndex = height.length - 1;
   
    for (i = 0; i < height.length; i++) {
        leftHeight = height[leftIndex]; 
        rightHeight = height[rightIndex];
        currentArea = calculateArea(leftIndex, rightIndex, leftHeight, rightHeight);
        maxArea = Math.max(maxArea, currentArea)

        console.log(leftHeight+ " " + rightHeight + " " + currentArea);

        //Left Pointer and Right Pointer Equal
        if(leftHeight == rightHeight) {
            leftIndex = leftIndex + 1;
        } else if (leftHeight < rightHeight) {
            leftIndex = leftIndex + 1;
        } else {
            rightIndex = rightIndex - 1;            
        }

        if(leftIndex == rightIndex) {
            break;
        }
    }

    return maxArea;
} 

console.log("MAX " + maxArea(height));
 


function calculateArea(leftIndex, rightIndex, leftHeight, rightHeight) {
    let distance = (rightIndex - leftIndex) 
    let minHeight = Math.min(leftHeight, rightHeight);

    let area = distance * minHeight;

    return area;

}

 
