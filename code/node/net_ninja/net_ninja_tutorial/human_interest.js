var fs = require('fs');

const myAnswerSet = new Set()
let first_url = 'first_url.gif';
let second_url = 'second_url.gif';
myAnswerSet.add(first_url)            
myAnswerSet.add(second_url)      

myAnswerSet.forEach(writeSetToFile);

//Could Add in Error Handling
function writeSetToFile(current_url, set) {
    console.log(current_url);
    fs.appendFileSync("human_interest.txt", current_url + "\r\n" ); 

}
