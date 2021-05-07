//APP
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


//TYPE 1: Simple Users Response
app.get("/users", (req, res) => {
    const user1 = {firstName: "David", lastName: "V"}
    const user2 = {firstName: "Frodo", lastName: "B"}
    const user3 = {firstName: "Bilbo", lastName: "B"}
    res.json([user1, user2, user3])
})
 
//TYPE 2: Simple GET Request
app.get('/usersimple/:id', (req, res) => {
    console.log("Fetching user with id: " + req.params.id);  
    res.send("User " + req.params.id);
    res.end();
})

//TYPE 3: Simple GET Request with Database
app.get('/user/:id', (req, res) => {

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

//TYPE 4: Simple GET Request with Database and Connection Function
//http://localhost:3003/userConnection/1
app.get('/userConnection/:id', (req, res) => {
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


//TYPE 5: Simple POST request 
app.post('/simple_post', function(req, res, next) {
    res.send("hello! Sent from POST request")
    
    //const firstName = req.body.create_first_name
    //const lastName = req.body.create_last_name 
    
    //console.log("First name: " + req.body.create_first_name)
    console.log(req.body.firstName + " " + req.body.lastName);

    res.end()
})

//TYPE 6: Simple Router
const router = express.Router();
router.get('/messages', (req, res) => {
    console.log("my messages!");
    res.end();
});

app.use(router)


//Functions: Get Connection
function getConnection() {
    return mysql.createConnection({
      host: 'localhost',
      user: 'root',
      password: '',
      database: 'shareshare'
    })
}
  


//ROUTES
const express = require('express');
const mysql = require('mysql');
const router = express.Router();
const Program = require('./../models/program')
const mongoose = require('mongoose');

//ROUTE 1: Get all Programs
router.get("/api/programs", (req, res) => {
    Program.find()
        .then((result) => {
            res.send(result)
        })
        .catch((err) => { 
            console.log(err)
        });
})

//ROUTE 2: Get a Program based on its Program ID (1, 2, 3 or 4)
router.get("/api/program/:program_id", (req, res) => {
    const program_id = req.params.program_id;

    Program.findOne({
            programID: program_id
        }).then((result) => {
            res.send(result)
            console.log(result.totalSections);
        })
        .catch((err) => { 
            console.log(err)
        });
})

//ROUTE 3: Select a Section by giving the Program ID and Section ID 
router.get("/api/program/:program_id/section/:page_number", (req, res) => {

    const program_id = req.params.program_id;
    const page_number = req.params.page_number;

    Program.findOne({
        programID: program_id
    }).then((result) => {
        const allSections = result.programSections;
        const totalSections = result.totalSections;
        
        const currentSection = allSections[page_number - 1];

        //Valid Section
        if(page_number >= 1 && page_number <= totalSections) {
            res.send(currentSection);
  
        //Not a Page (or Section)            
        } else {
           res.send("There is no section that matches " + page_number);
           
        }   
    })
    .catch((err) => { 
        console.log(err)
    });

})

module.exports = router;

//LOGIN
const express = require('express')
const jwt = require('jsonwebtoken')
//const bodyParser = require('body-parser');
const app = express()
//app.use(bodyparser.json());
app.use(express.json());
//app.use(bodyParser.urlencoded());
//app.use(bodyParser.json());


//GET: localhost:3003
app.listen(3003, () => {
    console.log("Server is up and listening on 3003...")
})

//LOGIN
//Login (This make a request and provides a token to request a protected route)
app.post("/api/login", (req, res) => {

    const userName = req.body.username;
    const password = req.body.password;
    const email = req.body.email;
    console.log("login "  + userName + " " + password);
   
    //Mock User
    const user = {
        username: userName,
        email: password
    }
    console.log(user);
    jwt.sign({user}, 'secretkey', { expiresIn: '30s' }, (err, token) => {
    //jwt.sign({user}, 'secretkey', (err, token) => {
        res.json({
          token
        });
    });
});



//POST
//Create Post
app.post('/api/posts', verifyToken, (req, res) => {  
    jwt.verify(req.token, 'secretkey', (err, authData) => {
      if(err) {
        res.sendStatus(403);
      } else {
        res.json({
          message: 'Post created...',
          authData
        });
      }
    });
});
  
app.post('/api/recieveData', (req, res) => {  
    const firstName = req.body.first_name;
    const lastName = req.body.last_name
    
    console.log(firstName);
    console.log(lastName);
    res.end()
}); 


//FORMAT OF TOKEN
//Authorization: Bearer <access_token>
function verifyToken(req, res, next) {
    // Get auth header value
    const bearerHeader = req.headers['authorization'];
    // Check if bearer is undefined
    if(typeof bearerHeader !== 'undefined') {

        // Split at the space
        const bearer = bearerHeader.split(' ');
        // Get token from array
        const bearerToken = bearer[1];
        // Set the token
        req.token = bearerToken;
        // Next middleware
        next();

    } else {
      // Forbidden
      res.sendStatus(403);
    }
  
  }

