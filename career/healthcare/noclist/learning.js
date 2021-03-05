Saturday 5pm
const crypto = require("crypto")
const axios = require('axios');
//David 3
//Main App: Retrieve a list of VIP users 
(async () => {
  var finalUserObject = await getUsers();

  //Success: We have succesfully retrieved this users and will print them and exit
  if(finalUserObject.success === 1) {
    var finalUserList = finalUserObject.userList;
    console.log(finalUserList)
    //process.stdout.write(finalUserList);
    //process.exit();
    //Failure: We were unable to get the list of users
  } else {
    console.log("sad, no worky!");
    //process.stdout.write("We are exiting the process \r\n");
    //process.exit(1);
  }

})()


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
      
      //console.log("TRY ");

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
        } else {
            //console.log(error.response.status);
            //console.log(error.response.statusText);   
            currentErrorMessages.push(error.response.status + " " + error.response.statusText); 
  
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
        } else {
            //console.log(error.response.status);
            //console.log(error.response.statusText);   
            currentErrorMessages.push(error.response.status + " " + error.response.statusText); 

        }
      }
    }
    //END LOOP

  } else {
    userOutcome.errrorMessages.push("Was unable to get the Authorization Token");
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





/*
//Main App: Retrieve a list of VIP users 
(async () => {
  
  var finalUserObject = await getUsers();
  var finalUserList = finalUserObject.userList;
  //Success: We have succesfully retrieved this users and will print them and exit
  if(finalUserObject.success === 1) {
    process.stdout.write(finalUserList);
    process.exit();
  //Failure: We were unable to get the list of users
  } else {
    process.stdout.write("We are exiting the process \r\n");
    process.exit(1);
  }
  
})()
//Function A.1: Retrieve the Authentication Token from the BADSEC API
async function getAuth() {
  var totalConnectAttempts = 3;
  var currentToken = "";
  var failedAttempts = 0;
  //Step 1: Create an object to contain the outcome of our attempt at getting the Authentication Token
  var authOutcome = {
    success: 0,
    authToken: "",
    totalFails: 0,
  };
  //Step 2: Try to connect three times and if that does not work stop attempting to get a response from the API  
  for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {
    try {
      
      //Create our call with Axios and set a timeout in case the server is taking to long
      const response = await axios({
        baseURL: 'http://0.0.0.0:8888/auth',
        method: 'get',
        timeout: 8000
      });
      
      //Make sure we have recieved a 200 response from the server 
      console.log(response.status)      
      var response_headers = response.headers;
      
      //Get the Authentication Token from the response header 
      currentToken = response_headers["badsec-authentication-token"];
      authOutcome.success = 1;
    
    //Handle a failed attempt to get a response from the API 
    } catch (error) {
      failedAttempts = failedAttempts + 1;   
      currentErrorMessage = error.message;
      authOutcome.success = 0;
      authOutcome.totalFails = failedAttempts;
      process.stderr.write('Auth Attempt: ' + failedAttempts + ' ' + error.message + '\r\n')
    } 
    //If we got the token we do not need to try and can exit the loop
    if(authOutcome.success === 1) {
      break;
    }
  }
  //Step 3: Set the token in our Object and return the response  
  authOutcome.authToken = currentToken;
  return authOutcome;
}
*/


/*
//Function A.2: Get a list of VIP users from the BADSEC API
async function getUsers(modifyMe) {
  //Make a call to Function A.1 to get the Authentication Token 
  var authOutcomeObject = await getAuth();
  var totalConnectAttempts = 3;
  //Create an Object to handle the outcomes of getting the users 
  var userOutcome = {
    success: 0,
    totalFails: 0,
    userList: []
  };
  //Step 1: We were able to get the Authentication Token and can get the Users 
  if(authOutcomeObject.success === 1) {
    //Call Function B.1 to get the checksum
    const currentAuthToken = authOutcomeObject.authToken;
    currentChecksum = createChecksum(currentAuthToken)
    
    for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {
      try {
        const response = await axios({
          baseURL: 'http://0.0.0.0:8888/users',
          headers: {'X-Request-Checksum': currentChecksum},
          method: 'get',
          timeout: 5000
        });
        //HANDLE 
        console.log(response.status)
        //console.log(response.data);
        //Format the list of users into JSON 
  
        var usersList = response.data;
        var usersListArray = usersList.split(/\r?\n/);
        var usersListJSON = JSON.stringify(usersListArray);
        userOutcome.success = 1;
        userOutcome.userList = usersListJSON;
      } catch (error) {
        process.stderr.write('User Attempt: ' + failedAttempts + ' Error Message: ' + error.message  + '\r\n')
        userOutcome.success = 0;
      } 
      
      //Stop trying to contact the server upon success 
      if(userOutcome.success === 1) {
        break;
      }
    } 
           
  } else {
    process.stderr.write("We were unable to get the Authentication Token from the API \r\n")
  }
  return userOutcome;
}
*/


//OLD
const crypto = require("crypto")
const axios = require('axios');


//http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user.php
async function getData() {
    var totalConnectAttempts = 3;
    var currentFails = 0;
    var currentErrorMessages = [];
    var masterOutcome = {
        success: 0,
        userList: [],
        totalFails: 0,
        errorMessages: []
    };

    for (connectAttempt = 0; connectAttempt < totalConnectAttempts; connectAttempt++) {

        try {
        let res = await axios({
                url: 'http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user.php',
                method: 'get',
                timeout: 8000,
                headers: {
                    'Content-Type': 'application/json',
                }
            })
            
            console.log("TRY ");
  
            if(res.status == 200){
                console.log("STATUS " + res.status);
                console.log(res.data);
                masterOutcome.success = 1;
                break;
            } else {
                //console.log("NO 200");
                masterOutcome.message = "uh oh";
            }
        }
        catch (error) {
            currentFails = currentFails + 1;
            console.log("CATCH "); 
            if(error.code === 'ECONNABORTED') { 
                //console.log("Timeout");
                masterOutcome.message = "Timeout";    
                currentErrorMessages.push("The connection timed out");
            } else {
                //console.log(error.response.status);
                //console.log(error.response.statusText);   
                currentErrorMessages.push(error.response.status + " " + error.response.statusText); 
                masterOutcome.message = "catch";    
            }
        }

    }
    masterOutcome.totalFails = currentFails;
    masterOutcome.errorMessages = currentErrorMessages;

    return masterOutcome;
}

(async () => {
    var masterOutcome = await getData();
    console.log((masterOutcome).totalFails);
    console.log((masterOutcome).errorMessages);
  })()

