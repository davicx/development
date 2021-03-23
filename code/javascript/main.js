/**
 * Example 1
 */
console.log(x === undefined); // true
var x = 3;

/**
 * Example 2
 */
// will return a value of undefined
var myvar = 'my value';

(function() {
  console.log(myvar); // undefined
  var myvar = 'local value';
})();

foo(); // "bar"

function foo() {
  console.log('bar');
}

/* Function expression */

baz(); // TypeError: baz is not a function

var baz = function() {
  console.log('bar2');
};