const express = require('express')
const app = express()
const morgan = require('morgan')
const mysql = require('mysql')

app.use(morgan('short'))
app.use(express.json());


app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})

app.get("/", (req, res) => {
    console.log("Responding to root route");
    res.send("Responding to root route");
    res.end()
})

const router = require('./routes/user.js');

app.use(router);


