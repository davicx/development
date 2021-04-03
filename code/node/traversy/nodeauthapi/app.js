// load our app server using express somehow....
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


  
/*
app.post("/api/posts", verifyToken, (req, res) => {
    res.json({
        message: 'Post Created!'
    })
})
*/


/*

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

app.post('/api/login', (req, res) => {
  // Mock user
  const user = {
    id: 1, 
    username: 'brad',
    email: 'brad@gmail.com'
  }

  jwt.sign({user}, 'secretkey', { expiresIn: '30s' }, (err, token) => {
    res.json({
      token
    });
  });
});



// Verify Token
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
 */


/*
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

*/

/*
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


*/