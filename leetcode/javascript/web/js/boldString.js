//const dict = ["abc","123"] 
const dict = ["abc"] 

const s = "abczzz123"
boldStrings(s, dict) 
 
function boldStrings(s, dict) {
    let answerString = "";
    

    for (let i = 0; i < dict.length; i++) {
        console.log(dict[i]);
    }
    
    return answerString;
    
}
