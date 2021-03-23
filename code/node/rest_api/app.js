// load our app server using express somehow....
const express = require('express')
const app = express()
const morgan = require('morgan')

app.use(morgan('combined'))


//Middleware 
var myLogger = function (req, res, next) {
  console.log('You came here!')
  next()
}

var requestTime = function (req, res, next) {
  req.requestTime = Date.now()
  console.log(Date.now())

  next()
}

app.use(myLogger)
app.use(requestTime)


//App 
app.get("/", (req, res) => {
  console.log("Responding to root route")
  res.send("hiya davd!!")
})

app.get("/users", (req, res) => {
    var user1 = {firstName: "David", lastName: "V"}
    var user2 = {firstName: "Frodo", lastName: "V"}
    const user3 = {firstName: "Bilbo", lastName: "B"}
    res.json([user1, user2, user3])
})


// localhost:3003
app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})
