const mongoose = require('mongoose')
const Schema = mongoose.Schema;

const programSchema = new mongoose.Schema({
  programName: {
    type: String,
    required: true,
  },
  programDescription: {
    type: String,
    required: true,
  }
}, {timestamps: true});

const Program = mongoose.model('Program', programSchema)
module.exports = Program;

/*
  createdAt: {
    type: Date,
    default: Date.now,
  },
  */