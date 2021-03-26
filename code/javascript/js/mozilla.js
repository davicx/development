//Control flow and error handling
let x = 5;
while (x < 10) {
    x++;
}

/*
//Throws
function UserException(message) {
    this.message = message;
    this.name = 'UserException';
  }

// Make the exception convert to a pretty string when used as a string
// (e.g., by the error console)
UserException.prototype.toString = function() {
return `${this.name}: "${this.message}"`;
}

// Create an instance of the object type and throw it
throw new UserException('Value too high');
*/

//Try and Catch 
function getMonthName(mo) {
    mo = mo - 1; // Adjust month number for array index (1 = Jan, 12 = Dec)
    let months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
                  'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    if (months[mo]) {
      return months[mo];
    } else {
      throw 'InvalidMonthNo';
    }
}

function logMyErrors(e) {
    console.log(e);
}

try { 
    monthName = getMonthName(1); 
    console.log(monthName)
} catch (e) {
    monthName = 'unknown';
    logMyErrors(e);  
} finally {
    console.log("done!");

}

getMonthName(5)