const express = require('express')
const app = express()
const morgan = require('morgan')
const bodyParser = require('body-parser')
app.use(morgan('short'));
let port = process.env.PORT || 3003
//https://myfirstappdv77.herokuapp.com/ 
//https://git.heroku.com/myfirstappdv77.git


app.listen(port, () => {
  console.log("Server is up and listening on 3003...")
})


app.get("/", (req, res) => {
  console.log("Responding to root route");
    res.end()
})

//USERS
app.get("/user", (req, res) => {
    var user1 = {firstName: "David", lastName: "V"}
    res.json(user1)
})

app.get("/users", (req, res) => {
  var user1 = {firstName: "David", lastName: "V"}
  const user2 = {firstName: "Frodo", lastName: "B"}
  const user3 = {firstName: "Bilbo", lastName: "B"}
  res.json([user1, user2, user3])
})