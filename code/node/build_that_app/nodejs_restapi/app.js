const express = require('express')
const app = express()
const morgan = require('morgan')
const mysql = require('mysql')
const bodyParser = require('body-parser')

//app.use(bodyParser.urlencoded({extended: false}))
app.use(express.static('./public'))
app.use(morgan('short'))


//Router
//const router = require('./routes/user.js')
//app.use(router)
app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})

app.use(morgan('short'));

app.get("/", (req, res) => {
  console.log("Responding to root route");
    res.end()
})

//USERS
app.get("/users", (req, res) => {
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



//Functions: Get Connection
function getConnection() {
  return mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'shareshare'
  })
}

//Clean Below 

/*
//app.use(morgan('combined'))


app.post('/user_create', (req, res) => {
  console.log("Trying to create a new user...")

  const firstName = req.body.create_first_name
  const lastName = req.body.create_last_name

  const queryString = "INSERT INTO user_profile (user_name, first_name, last_name) VALUES (?, ?, ?)"
  getConnection().query(queryString, [firstName, firstName, lastName], (err, results, fields) => {
    if (err) {
      console.log("Failed to insert new user: " + err)
      res.sendStatus(500)
      return
    }
    var newUserID = results.insertId;
    console.log("Inserted a new user with id: ", results.insertId);

    res.end()
  })
})




// localhost:3003
app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})
*/
//////////////////

/*
// load our app server using express somehow....
const express = require('express')
const app = express()
const morgan = require('morgan')
const mysql = require('mysql')
const bodyParser = require('body-parser')

app.use(bodyParser.urlencoded({extended: false}))
app.use(express.static('./public'))
app.use(morgan('short'))


}


//app.use(morgan('combined'))
app.use(morgan('short'));

app.get("/", (req, res) => {
  console.log("Responding to root route");
    res.end()
})

app.get("/user_create", (req, res) => {
  console.log("Responding to root route");
  const firstName = req.body.create_first_name
  const lastName = req.body.create_last_name 

    const queryString = "INSERT INTO user_profile (first_name, last_name) VALUES (?, ?)"
    getConnection().query(queryString, [firstName, lastName], (err, results, fields) => {
      if (err) {
        console.log("Failed to insert new user: " + err)
        res.sendStatus(500)
        return
      }
  
  getConnection().query();
      //user_profile_id user_id
  //console.log("Inserted a new user with id: ", results.insertId);

  res.end()
})


app.post('/user_createss', (req, res) => {
    console.log("Trying to create a new user...")
    
    const firstName = req.body.create_first_name
    const lastName = req.body.create_last_name 
    
    console.log("First name: " + req.body.create_first_name)
    const firstName = req.body.create_first_name
    const lastName = req.body.create_last_name
  
    const queryString = "INSERT INTO users (first_name, last_name) VALUES (?, ?)"
    getConnection().query(queryString, [firstName, lastName], (err, results, fields) => {
      if (err) {
        console.log("Failed to insert new user: " + err)
        res.sendStatus(500)
        return
      }
  
      console.log("Inserted a new user with id: ", results.insertId);
      res.end()
    })
    
  })

app.get('/getfriends/:id', (req, res) => {
    console.log("Fetching user with id: " + req.params.id)
  
    const connection = mysql.createConnection({
      host: 'localhost',
      user: 'root',
      database: 'shareshare'
    })
  
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

  app.get('/user/:id', (req, res) => {
    console.log("Fetching user with id: " + req.params.id)
  
    const connection = mysql.createConnection({
      host: 'localhost',
      user: 'root',
      database: 'shareshare'
    })
  
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





app.get("/users", (req, res) => {
  var user1 = {firstName: "David", lastName: "V"}
  const user2 = {firstName: "Frodo", lastName: "B"}
  const user3 = {firstName: "Bilbo", lastName: "B"}
  res.json([user1, user2, user3])
})

// localhost:3003

*/