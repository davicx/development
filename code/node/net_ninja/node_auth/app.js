const express = require('express');
const mongoose = require('mongoose');
const mysql = require('mysql')
const authRoutes = require('./routes/authRoutes');

const app = express();

//Middleware
app.use(express.static('public'));
app.use(express.json());

//View Engine
app.set('view engine', 'ejs');


app.post('/api/recieveData', (req, res) => {  
  const firstName = req.body.first_name;
  const lastName = req.body.last_name
  
  console.log("test");
  console.log(lastName);
  res.end()
}); 


//Get Users
app.get('/allusers', (req, res) => {
  console.log("Responding to database route");
  const connection = mysql.createConnection({
      host: 'localhost',
      user: 'root',
      database: 'test'
    })
    const queryString = "SELECT * FROM users";
    connection.query(queryString, (err, rows, fields) => {    
      console.log("Fetched")
      res.json(rows);
  })
})

/*
//Get All Users
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


//Database connection
/*
const dbURI = 'mongodb+srv://shaun:test1234@cluster0.del96.mongodb.net/node-auth';
mongoose.connect(dbURI, { useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex:true })
  .then((result) => app.listen(3000))
  .catch((err) => console.log(err));
*/


//Routes
app.get('/', (req, res) => res.render('home'));
app.get('/smoothies', (req, res) => res.render('smoothies'));


app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})
 

app.use(authRoutes);

/*
const express = require('express')
const app = express()
const morgan = require('morgan')

const bodyParser = require('body-parser')

app.use(bodyParser.urlencoded({extended: false}))
app.use(express.static('./public'))
app.use(morgan('short'))
 */
 