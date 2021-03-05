const axios = require('axios');
const fs = require('fs');



process.on('uncaughtException', function (err) {
    console.log("ohya");
    
});
  
  setTimeout(function () {
    console.log('This will still run.');
  }, 500);
  
  // Intentionally cause an exception, but don't catch it.
  nonexistentFunc();
  console.log('This will not run.');

/*

process.on('uncaughtException', (err, origin) => {
    fs.writeSync(process.stderr.fd, `Caught exception: ${err}\n` + `Exception origin: ${origin}`);
    //process.exit(1)
});

//process.stderr.write("I will goto the STDERR")
  
  setTimeout(() => {
    console.log('This will still run.');
  }, 500);
  
  // Intentionally cause an exception, but don't catch it.
  console.log('This will not run.');
  nonexistentFunc();

*/
//getONID();

/*
async function getONID() {

    try {
        const response = await axios({
            baseURL: 'http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user.php',
            method: 'get',
            timeout: 5000
          });
       
        //const response = await axios.get('http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user.php');     
        console.log(response.status);
 

      } catch (error) {

        console.log(error.message);
 
      }   
  }
  
async function getData() {
    try {
       let res = await axios({
            url: 'http://people.ore',
            method: 'get',
            timeout: 8000,
            headers: {
                'Content-Type': 'application/json',
            }
        })
        if(res.status == 200){
            // test for status you want, etc
            console.log(res.status)
        }    
        // Don't forget to return something   
        return res.data
    }
    catch (err) {
        console.error(err);
    }
}

//getData().then(res => console.log(res))
*/