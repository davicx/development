const mongoose = require('mongoose')

const reqString = {
  type: String,
  required: true,
}

const UserSchema = mongoose.Schema({
  email: reqString,
  username: reqString,
  password: reqString,
})

const User = mongoose.model('User', UserSchema)
module.exports = User;