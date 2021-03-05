const crypto = require("crypto")
const axios = require('axios');

//David 
mainApp();

async function mainApp() {
  var finalUserObject = await getUsers();

  //Success: We have succesfully retrieved this users and will print them and exit
  if(finalUserObject.success === 1) {
    var finalUserList = finalUserObject.userList;
    var usersReturnedCount = Object.keys(finalUserList).length;
    //console.log(usersReturnedCount);
    process.stdout.write(finalUserList);
    //process.exit();
  
  //Failure: We were unable to get the list of users
  } else {
    //console.log("sad, no worky!");
    process.stdout.write("We were unable to retrieve the List of VIP Users \r\n");
    //process.exit(1);
  }

}

/*
//Main App: Retrieve a list of VIP users 
(async () => {
  var finalUserObject = await getUsers();

  //Success: We have succesfully retrieved this users and will print them and exit
  if(finalUserObject.success === 1) {
    var finalUserList = finalUserObject.userList;
    var usersReturnedCount = Object.keys(finalUserList).length;
    //console.log(usersReturnedCount);
    process.stdout.write(finalUserList);
    //process.exit();
  
  //Failure: We were unable to get the list of users
  } else {
    //console.log("sad, no worky!");
    process.stdout.write("We were unable to retrieve the List of VIP Users \r\n");
    //process.exit(1);
  }

})()
*/

//Function A.1: Retrieve the Authentication Token from the BADSEC API
async function getAuth() { 
  var totalConnectAttempts = 3;
  var currentToken = "";
  var currentFails = 0;
  var currentErrorMessages = [];

  //Step 1: Create an object to contain the outcome of our attempt at getting the Authentication Token
  var authOutcome = {
    success: 0,
    authToken: "",
    totalFails: 0,
    errorMessages: []
  };

  for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {

    try {
      //Create our call with Axios and set a timeout in case the server is taking to long
      const response = await axios({
        baseURL: 'http://0.0.0.0:8888/auth',
        method: 'get',
        timeout: 8000
      });
      
      if(response.status == 200){
          //console.log("STATUS " + response.status);
          //console.log(response.data);
          var response_headers = response.headers;

          //Get the Authentication Token from the response header 
          currentToken = response_headers["badsec-authentication-token"];
          authOutcome.success = 1;
          //console.log(currentToken);
          break;
      } 
    } catch (error) {
        currentFails = currentFails + 1;
        
        //console.log("CATCH "); 
        if(error.code === 'ECONNABORTED') { 
            //console.log("Timeout");
            currentErrorMessages.push("The connection timed out");
            //process.stderr.write('Auth Attempt: ' + currentFails + ' The connection timed out \r\n');
        } else {
            //console.log(error.response.status);
            //console.log(error.response.statusText);   
            currentErrorMessages.push(error.response.status + " " + error.response.statusText); 
            process.stderr.write('Auth Attempt: ' + currentFails + ' ' + error.message + '\r\n');
            //process.stderr.write(error.message  + '\r\n');
  
        }
    }
  }

    //Step 3: Set the token in our Object and return the response  
    authOutcome.authToken = currentToken;
    authOutcome.totalFails = currentFails;
    authOutcome.errorMessages = currentErrorMessages;

    return authOutcome;

}


//Function A.2: Get a list of VIP users from the BADSEC API
async function getUsers() {
  var totalConnectAttempts = 3;
  var currentFails = 0;
  var currentErrorMessages = [];

  //Make a call to Function A.1 to get the Authentication Token 
  var authOutcome = await getAuth();

  //Create an Object to handle the outcomes of getting the users 
  var userOutcome = {
    success: 0,
    userList: [],
    totalFails: 0,
    errrorMessages: []
  };

  //Call Function B.1 to get the checksum
  const currentAuthToken = authOutcome.authToken;
  currentChecksum = createChecksum(currentAuthToken)
  //console.log(currentChecksum);

  //STEP 2: Fetch Users 
  if(authOutcome.success === 1) {

    //LOOP 3 TIMES
    for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {
      try {
        const response = await axios({
          baseURL: 'http://0.0.0.0:8888/users',
          headers: {'X-Request-Checksum': currentChecksum},
          method: 'get',
          timeout: 8000
        });

        var usersList = response.data;
        var usersListArray = usersList.split(/\r?\n/);
        var usersListJSON = JSON.stringify(usersListArray);
        userOutcome.success = 1;
        userOutcome.userList = usersListJSON;
        //console.log(userOutcome.userList);
        break;   
  
      } catch (error) {      
        currentFails = currentFails + 1;
          
        if(error.code === 'ECONNABORTED') { 
            //console.log("Timeout");
            currentErrorMessages.push("The connection timed out");
            process.stderr.write('Get Users Attempt: ' + currentFails + ' The connection timed out \r\n');
            

        } else {
            //console.log(error.response.status);
            //console.log(error.response.statusText);   
            currentErrorMessages.push(error.response.status + " " + error.response.statusText); 
            process.stderr.write('Get Users Attempt: ' + currentFails + ' ' + error.message + '\r\n')
        }
      }
    }
    //END LOOP

  } else {
    userOutcome.errrorMessages.push("Was unable to get the Authorization Token");
    process.stderr.write('We were unable to get the Authorization Token \r\n')
    //console.log(authOutcome);  
    //console.log("Was unable to get the Authorization Token");
  }


  userOutcome.totalFails = currentFails;
  userOutcome.errrorMessages = currentErrorMessages;

  return userOutcome;


}
 
//Function B.1: Create a Checksum 
function createChecksum(currentAuthToken) {
    const securityKey = (currentAuthToken + "/users");
    const checksum = crypto.createHash('sha256').update(securityKey).digest('hex');
    return checksum;
}