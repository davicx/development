// load our app server using express somehow....
const express = require('express')
const app = express()
const morgan = require('morgan')

app.use(morgan('combined'))

app.get("/", (req, res) => {
  console.log("Responding to root route")
  res.send("Hello from ROOOOOT")
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
