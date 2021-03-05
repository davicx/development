const crypto = require("crypto")
const axios = require('axios');


//Call the Main App to try to get a list of VIP Users from the BADSEC API 
mainApp();


//Function A.1: Retrieve the List of Users
async function mainApp() {

  //Get the Authorization Token Object 
  var authOutcome = await getAuthorizationToken();
 
  //Get the User List Object 
  var finalUserObject = await getUsers(authOutcome);

  //Success: We have succesfully retrieved the users 
  if(finalUserObject.success === 1) {
    var finalUserList = finalUserObject.userList;
    process.stdout.write(finalUserList);
    process.exit();
  
  //Failure: We were unable to get the list of users
  } else {
    process.stdout.write("We were unable to retrieve the List of VIP Users \r\n");
    process.exit(1);
  }

}

//Function A.2: Retrieve the Authentication Token from the BADSEC API
async function getAuthorizationToken() { 
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

  //Step 2: Call the API up to three times to try to get the Authentication Token 
  for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {

    //Try to call the API using Axios and set a timeout in case the server is taking to long to respond 
    try {
      const response = await axios({
        baseURL: 'http://0.0.0.0:8888/auth',
        method: 'get',
        timeout: 8000
      });
      
      //We sucesfully contacted the API to get the token 
      if(response.status == 200){
          var response_headers = response.headers;
          currentToken = response_headers["badsec-authentication-token"];
          authOutcome.success = 1;
          break;
      } 

    //Handle some simple errors that may arise   
    } catch (error) {
        currentFails = currentFails + 1;

        if(error.code === 'ECONNABORTED') { 
            currentErrorMessages.push("The connection timed out");
        } else {
            currentErrorMessages.push(error.response.status + " " + error.response.statusText); 
            process.stderr.write('Auth Attempt: ' + currentFails + ' ' + error.message + '\r\n');
        }
    }

  }

    //Step 3: Create our Auth Object (will still return an object with error details even if we did not succeed) 
    authOutcome.authToken = currentToken;
    authOutcome.totalFails = currentFails;
    authOutcome.errorMessages = currentErrorMessages;

    return authOutcome;

}


//Function A.3: Get a list of VIP users from the BADSEC API
async function getUsers(authOutcome) {
  var totalConnectAttempts = 3;
  var currentFails = 0;
  var currentErrorMessages = [];

  //Step 1: Create an Object to handle the outcomes of getting the users 
  var userOutcome = {
    success: 0,
    userList: [],
    totalFails: 0,
    errrorMessages: []
  };

  //Step 2: Create a checksum by calling Function B.1 
  const currentAuthToken = authOutcome.authToken;
  currentChecksum = createChecksum(currentAuthToken)

  //Step 3: Try to retrieve the users if we were able to create a checksum 
  if(authOutcome.success === 1) {

    //Step 4: Call the API up to three times to try to get the Users 
    for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {
      try {
        const response = await axios({
          baseURL: 'http://0.0.0.0:8888/users',
          headers: {'X-Request-Checksum': currentChecksum},
          method: 'get',
          timeout: 8000
        });
         
        //Create the list of JSON Users and break out of the loop on success 
        var usersList = response.data;
        var usersListArray = usersList.split(/\r?\n/);
        var usersListJSON = JSON.stringify(usersListArray);
        userOutcome.success = 1;
        userOutcome.userList = usersListJSON;
        break;   

      //Handle some simple errors that may arise 
      } catch (error) {      
        currentFails = currentFails + 1;
          
        if(error.code === 'ECONNABORTED') { 
            currentErrorMessages.push("The connection timed out");
            process.stderr.write('Get Users Attempt: ' + currentFails + ' The connection timed out \r\n');
        } else {  
            currentErrorMessages.push(error.response.status + " " + error.response.statusText); 
            process.stderr.write('Get Users Attempt: ' + currentFails + ' ' + error.message + '\r\n')
        }
      }
    }
  
  //Handle failure to get the Authorization Token 
  } else {
    userOutcome.errrorMessages.push("Was unable to get the Authorization Token");
    process.stderr.write('We were unable to get the Authorization Token \r\n')
  }

  //Step 5: Create our User Object (will still return an object with error details even if we did not succeed) 
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