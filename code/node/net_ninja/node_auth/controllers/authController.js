const mysql = require('mysql')

// controller actions
module.exports.signup_get = (req, res) => {
  res.render('signup');
}

module.exports.login_get = (req, res) => {
  res.render('login');
}

module.exports.signup_post = async (req, res) => {

  console.log("Trying to create a new user...")
    
  const userName = req.body.user_name
  const email = req.body.email
  const password = req.body.password
  const firstName = req.body.first_name
  const lastName = req.body.last_name 
  console.log(userName);

  const queryString = "INSERT INTO users (user_name, password) VALUES (?, ?)"
  
  
  getConnection().query(queryString, [userName, email], (err, results, fields) => {
    if (err) {
      console.log("Failed to insert new user: " + err)
      res.sendStatus(500)
      return
    }

    console.log("Inserted a new user with id: ", results.insertId);
    res.end()
  })

  /*
  const queryString = "INSERT INTO user_profile (user_name, email, password, first_name, last_name) VALUES (?, ?, ?, ?, ?)"
  getConnection().query(queryString, [userName, email, password, firstName, lastName], (err, results, fields) => {
    if (err) {
      console.log("Failed to insert new user: " + err)
      res.sendStatus(500)
      return
    }

    console.log("Inserted a new user with id: ", results.insertId);
    res.end()
  })

  */
}

module.exports.login_post = async (req, res) => {
  const userName = req.body.user_name;
  const password = req.body.password
  
  console.log(userName + " " + password);
  res.send('user login');
}


function getConnection() {
  return mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'test'
  })
}