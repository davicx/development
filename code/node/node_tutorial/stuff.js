var counter = function(arr){
    return "Array is " + arr.length;
};


var adder = function(a,b){
    return 'On adding the two number it gives ' + (a+b);
}

var pi = 3.1535;

module.exports = {
    counter: counter,
    adder: adder,
    bi: pi
}

/*
module.exports.counter = counter ;
module.exports.adder = adder;
module.exports.bi = pi;
*/