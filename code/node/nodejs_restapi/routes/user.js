//User Routes 
const express = require('express')
const router = express.Router();
const mysql = require('mysql')

router.get('/messages', (req, res) => {
    console.log("my messages")
    res.end()
})

//Connection Pool
const pool = mysql.createPool({
        connectionLimit: 10,
        host: 'localhost',
        user: 'root',
        password: '',
        database: 'shareshare'
})


function getConnection() {
    return pool;
    //Can do pool.query
  }
  


//FUNCTIONS: 
//Function A.1: Get All Users
router.get("/users", (req, res) => {
    const connection = getConnection();
    const queryString = "SELECT * FROM user_profile";
    connection.query(queryString, (err, rows, fields) => {    
        console.log("Fetched")
        res.json(rows);
    })
})

//Function A.2: Get Individual User
router.get('/user/:id', (req, res) => {
    const connection = getConnection();
  
    const userId = req.params.id
    console.log(userId);
    const queryString = "SELECT * FROM user_profile WHERE user_id = ?"
    connection.query(queryString, [userId], (err, rows, fields) => {
        if (err) {
          console.log("Failed to query for users: " + err)
          res.sendStatus(500)
          return
          // throw err
        }
    
        console.log("I think we fetched users successfully");
        res.json(rows);
    })     
  })

//Function A.3: Get Users Friends
router.get('/userFriends/:id', (req, res) => {
    console.log("Fetching user with id: " + req.params.id)
    const connection = getConnection();
  
    const userId = req.params.id
    console.log(userId);
    const queryString = "SELECT * FROM friends WHERE user_id = ?";

    connection.query(queryString, [userId], (err, rows, fields) => {
        if (err) {
          console.log("Failed to query for users: " + err)
          res.sendStatus(500)
          return
          // throw err
        }
    
        console.log("I think we fetched users successfully");
        res.json(rows);
    })     
  })

module.exports = router




/*


router.get("/users", (req, res) => {
  var user1 = {firstName: "David", lastName: "V"}
  const user2 = {firstName: "Frodo", lastName: "B"}
  const user3 = {firstName: "Bilbo", lastName: "B"}
  res.json([user1, user2, user3])
})

app.get('/allusers', (req, res) => {
    console.log("Responding to database route");
    const connection = mysql.createConnection({
        host: 'localhost',
        user: 'root',
        database: 'shareshare'
      })
      const queryString = "SELECT * FROM user_profile";
      connection.query(queryString, (err, rows, fields) => {    
        console.log("Fetched")
        res.json(rows);
    })
})
  


*/