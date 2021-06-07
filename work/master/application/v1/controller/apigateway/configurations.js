const express = require('express')
const app = express()
const bodyParser = require('body-parser')

/*
//Controller (File: configurations.js)
GET endpoint (/configurations)
When this recieves a GET request it will call ProcessConfigurations.getByRegion in the logic folder

//Logic (File: process-Configurations.js)
This will have the ProcessConfigurations class with the async getByRegion method.
This method will create a ConfigurationModel using the base class in the Model folder

//Model
This will have a Configuration Model that will be structured like this
config_region
config_group []

//Mock Data


*/

app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})

app.get("/", (req, res) => {
  console.log("Responding to root route");
    res.end()
})

//USERS
app.get("/configurations", (req, res) => {
  var user1 = {firstName: "David", lastName: "V"}
  const user2 = {firstName: "Frodo", lastName: "B"}
  const user3 = {firstName: "Bilbo", lastName: "B"}
  res.json([user1, user2, user3])
})

/*
const ConfigurationGroup = require('../../logic/config-group');

exports.requirements = {
    get: {
        requiredParams: ['region']
    }
};

//requiredBody: 'v1-user-invite-request'
exports.get = async (request, response) => {
    // add logical class for user invites
    let input = {config_region: "us" }
    const configurationGroup = new ConfigurationGroup(input);
    console.log(configurationGroup);
    
    
    console.log(request.params.region)
    return response;
};

*/