const express = require('express')
const userRouter = express.Router();
const user = require('../logic/postLogic')
const cors = require('cors')
const functions = require('../functions/functions');
//const friendFunctions = require('../functions/friendFunctions');


/*
FUNCTIONS A: All Routes Related to Getting Users
	1) Function A1: Get Users
*/

userRouter.post('/login', function(req, res) {


    // Validate username
    // Validate password
    // Save user to database

    const answer = functions.sum(2,2)
    console.log(answer)
    const validPassword = functions.validatePassword(true)

    if (validPassword) {
      res.json({message: "Valid User"})
    } else {
      res.json({error: "Invalid Password"})
    }
})

module.exports = userRouter;

/*
const express = require('express')
const cors = require('cors')

const app = express()

app.use(express.json())
app.use(cors())


const validatePassword = require('./validatePassword')

app.post('/users', (req, res) => {
  const { username, password } = req.body

  // Validate username
  // Validate password
  // Save user to database

  const validPassword = validatePassword(password)

  if (validPassword) {
    res.send({message: "Valid User"})
  } else {
    res.send({error: "Invalid Password"})
  }
})

*/