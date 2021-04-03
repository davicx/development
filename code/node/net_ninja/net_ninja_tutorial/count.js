//Type 1
var counter = function(arr) {
    return 'There are ' + arr.length + ' elements '
}

var myAdd = function(a,b) {
    return `the sum is ${a + b}`
}

const pi = 3.142;


//Type 2
/*
module.exports.mySubtract = function(a,b) {
    return `the difference is ${a - b}`
}
*/

//Type 3
var myMultiply = function(a,b) {
    return a * b;
}

var myDivision = function(a,b) {
    return a / b;
}

module.exports = {
    myMultiply: myMultiply,
    myDivision: myDivision

};


module.exports.counter = counter;
module.exports.myAdd = myAdd;
module.exports.pi = pi;
