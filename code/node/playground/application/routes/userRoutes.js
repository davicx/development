const express = require('express')
const postRouter = express.Router();
const user = require('../logic/postLogic')
const cors = require('cors')

/*
FUNCTIONS A: All Routes Related to Getting Users
	1) Function A1: Get Users
*/


userRouter.post('/users', function(req, res) {
	//const postFrom = req.body.postFrom 
	//const postTo = req.body.postTo 
	//const postCaption = req.body.postCaption 
	console.log(req.body)
    //posts.postText(req, res);
	res.json({postCaption: "postCaption"})
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