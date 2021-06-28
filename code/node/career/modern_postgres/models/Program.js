const Sequelize = require('sequelize');
const db = require('../config/database');

const Programs = db.define('programs', {
  program_name: {
    type: Sequelize.STRING
  },
  program_description: {
    type: Sequelize.STRING
  }
});

Programs.sync().then(() => {
  console.log('table created');
});

module.exports = Programs;