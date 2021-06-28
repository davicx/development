const express = require('express');
const router = express.Router();
const db = require('../config/database');
const Program = require('../models/Program');


//ROUTE 1: Get all Programs 
router.get('/api/programs', (req, res) => {
    console.log("all programs!");
    Program.findAll()
        .then(programs => {
            console.log(programs);
            res.sendStatus(200);
            res.end();
        })
        .catch(err => console.log(err))
});


module.exports = router;



/*
//ROUTE 2: Simple Users Response
router.get("/users", (req, res) => {
    const user1 = {firstName: "David", lastName: "V"}
    const user2 = {firstName: "Frodo", lastName: "B"}
    const user3 = {firstName: "Bilbo", lastName: "B"}
    res.json([user1, user2, user3])
})
 


//ROUTE 3: Simple GET Request
router.get('/usersimple/:id', (req, res) => {
    console.log("Fetching user with id: " + req.params.id);  
    res.send("User " + req.params.id);
    res.end();
})

//ROUTER 4: Simple GET Request with Database
router.get('/user/:id', (req, res) => {

    //Connect to Database 
    const connection = mysql.createConnection({
        host: 'localhost',
        user: 'root',
        database: 'shareshare'
    })

    //Create Query 
    let userId = req.params.id;
    const queryString = "SELECT user_name, email, first_name, last_name FROM user_profile WHERE user_id = ?";
    connection.query(queryString, [userId], (err, rows, fields) => {

    //Handle Error 
    if (err) {
        console.log("Failed to query for users: " + err);
        res.sendStatus(500);
        res.end();
    }
    
    console.log("I think we fetched users successfully");

    //Format data
    const users = rows.map((row) => {
        return {
            userName: row.user_name,
            email: row.email,
            firstName: row.first_name,
            lastName: row.last_name
        }
    });

    res.json(users);

    })     
});



//ROUTER 5: Simple GET Request with Database and Connection Function
//http://localhost:3003/userConnection/1
router.get('/userConnection/:id', (req, res) => {
    let userId = req.params.id;

    //Create Query 
    const queryString = "SELECT user_name, email, first_name, last_name FROM user_profile WHERE user_id = ?";

    getConnection().query(queryString, [userId], (err, rows, fields) => {
        if (err) {
            console.log("Failed to Select New User: " + err)
            res.sendStatus(500)
            return
        }

        //Output Data
        const users = rows.map((row) => {
            return {
                userName: row.user_name,
                email: row.email,
                firstName: row.first_name,
                lastName: row.last_name
            }
        });

        res.json(rows);
        res.end()

    })
 
});

//ROUTER 6: Simple POST request 
router.post('/simple_post', function(req, res, next) {
    res.send("hello! Sent from POST request")
    
    //const firstName = req.body.create_first_name
    //const lastName = req.body.create_last_name 
    
    //console.log("First name: " + req.body.create_first_name)
    console.log(req.body.firstName + " " + req.body.lastName);

    res.end()
})

//Function Test
function getBooks(req, res) {
    //Query the DB and if no errors, send all the books
    console.log("getBooks");
}



*/