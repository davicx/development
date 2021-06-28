const mongoose = require('mongoose')
//const { mongoPass } = require('./config.json')
const mongoPath = `mongodb+srv://modernHealth:$GYRE1T1aarCPLDsi@mongodb-tutorial.hbbee.mongodb.net/test-db?retryWrites=true&w=majority`

module.exports = async () => {
  await mongoose.connect(mongoPath, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })

  return mongoose
}

//mongoose.connect('mongodb+srv://modernHealth:GYRE1T1aarCPLDsi@cluster0.qrzt6.mongodb.net/modern_health?retryWrites=true&w=majority', {useNewUrlParser: true, useUnifiedTopology: true});
