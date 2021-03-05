const axios = require('axios');
const crypto = require("crypto")

//var SHA256 = require("crypto-js/sha256");
//console.log(SHA256("Message"));
//var hash = SHA256("Message");
//hash.toString(CryptoJS.enc.Hex)
//console.log(typeof hash);

// Make a request for a user with a given ID
async function getAuth() {
    try {
      //GET AUTH KEY
      const response = await axios.get('http://0.0.0.0:8888/auth');
      var response_headers = response.headers;
      var returned_auth_token = response_headers["badsec-authentication-token"];
      //console.log(response_headers);

      //CREATE CHECKSUM 
      var security_key = (returned_auth_token + "/users");
      const auth_token = crypto.createHash('sha256').update(security_key).digest('hex');
      console.log(auth_token);

      //GET USERS
      const options = {
          headers: {'X-Request-Checksum': auth_token}
      };      
     
      const getUsers = await axios.get('http://0.0.0.0:8888/users', options);
      console.log(getUsers.data);
      console.log(getUsers.status);


    } catch (error) {
        console.log(error);

    }
}

getAuth();

async function getUsers() {
  try {
      const response = await axios.get('http://0.0.0.0:8888/users');
      //console.log(response.data);
      const auth_token = crypto.createHash("sha256").update(security_key).digest("hex"); 
      var returned_auth_token = "91C664EA-26C0-1127-9FAF-42BB5334A6D7";


      
      
      //console.log(response.status);
      //console.log(data);
    } catch (error) {
      console.error(error.response);      
    }
}



//getUsers();


const options = {
  headers: {'X-Request-Checksum': 'checksum'}
};

/*
async function getUsers() {
  try {
      const response = await axios.get('http://0.0.0.0:8888/users', options);
      console.log(response.data);
      console.log(response.status);
      //console.log(data);
    } catch (error) {
      console.error(error);      
    }
}

*/



/*
     //Send 
      var returned_auth_token = response.data;
      var security_key = (returned_auth_token + "///users");
      
      //const auth_token = crypto.createHash('sha256').update(security_key).digest('base64');
      const auth_token = crypto.createHash('sha256').update(security_key).digest('hex');
      console.log(auth_token);
      const options = {
          headers: {'X-Request-Checksum': auth_token}
      };

      try {
        const response = await axios.get('http://0.0.0.0:8888/users', options);
        console.log(response.data);
        console.log(response.status);
        //console.log(data);
      } catch (error) {
        console.error(error);      
      }
*/

//var returned_auth_token = "8173642D81CB31B3A1A3D253F12A83D0";
//var security_key = (returned_auth_token + "/users");

//onst hash = crypto.createHash('sha256').update(security_key).digest('base64');
/*
const options = {
    headers: {'X-Request-Checksum': hash}
  };
  */
//axios.post('/save', { a: 10 }, options);


  //var headers = JSON.stringify(response.headers);
      //console.log("Header");  
    
      //console.log(headers.badsec-authentication-token);
      //for (item in headers) {
      //  console.log(item);
      //}
      //console.log(response.get('date'));
      /*  
      
      try {
        var obj = JSON.parse(headers); // this is how you parse a string into JSON 
        console.log(obj)

        //document.body.innerHTML += obj.hello;
      } catch (ex) {
        console.error(ex);
      }

      //console.log(response.headers.Badsec-Authentication-Token);
      console.log(response.headers);



      //var output = JSON.parse(response.headers)
      //var badsec = "\'badsec-authentication-token\'";
      //console.log(badsec)
      //console.log(response.headers);
      var object = response.headers;
      for (const property in object) {
        //console.log(`${property}: ${object[property]}`);
      }
      //console.log(object.badsec-authentication-token);
      //console.log(output.content-length);
      //console.log(response.get(Badsec-Authentication-Token));
      //auth_token = 

      //var returned_auth_token = response.data;

      //var security_key = (returned_auth_token + "/users");
      //console.log(security_key)
      //const auth_token = crypto.createHash('sha256').update(security_key).digest('hex');
      //const auth_token = crypto.createHash("sha256").update(security_key).digest("hex");    
      //const auth_token = crypto.createHash("sha256").update(security_key).digest("hex");    
      
      //console.log("TOKEN " + auth_token);
      */



/*
axios.get('http://0.0.0.0:8888/users')
  .then(function (response) {
    // handle success
    console.log(response);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .then(function () {
    // always executed
  });
*/