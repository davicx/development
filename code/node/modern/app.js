const express = require('express')
const morgan = require('morgan')
const app = express()
app.use(morgan('short'))
app.use(express.json());

//Mongo DB
const mongoose = require('mongoose');
mongoose.connect('mongodb+srv://modernHealth:GYRE1T1aarCPLDsi@cluster0.qrzt6.mongodb.net/modern_health?retryWrites=true&w=majority', {useNewUrlParser: true, useUnifiedTopology: true});
const db = mongoose.connection;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
    console.log("Connected!")
});

//General App and Routes 
app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})
 
app.get("/", (req, res) => {
    console.log("Responding to root route");
    res.end()
})

const router = require('./routes/programs.js');
app.use(router);