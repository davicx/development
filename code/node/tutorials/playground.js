
function makeRequest(location) {
    return new Promise((resolve, reject) => {
        console.log(location);
        if(location === "osu") {

            
            resolve('Hiya!')
        } else {
            reject('Wrong!')
        }
    })
}

function addSomething(something) {
    return new Promise((resolve, reject) => {
        resolve("Extra Information " + something)
    })
}

//All our Async Code
async function doWork() {
    const response = await makeRequest('osu');
    console.log('response received')
    const finalResponse = await addSomething(response);
    console.log(finalResponse);

}

doWork();

//Returns a promise
/*
const fetch = require("node-fetch");

const getUser = async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts');
    const data = await response.json();
    //console.log(data[0])

    //This will make the promise be rejected
    if(response.status !== 200) {
        throw new Error('cannot fetch the data');
    }
    
    return data[0];
}

//err.message

getUser()
    .then(data => console.log('RESOLVED ', data))
    .catch(err => console.log('ERROR ', err));
*/