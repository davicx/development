const express = require('express')
const app = express()
const morgan = require('morgan')
const Program = require('./models/program')
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

app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})
 
app.get("/", (req, res) => {
    console.log("Responding to root route");
    res.end()
})

app.get("/program", (req, res) => {
    const program = new Program({
        programName: "The name 2",
        programDescription: "the desc"
    });

    program.save()
        .then((result)  => {
            res.send(result)
        })
        .catch((err) => { 
         console.log(err)
    });
})

const router = require('./routes/user.js');
app.use(router);