const mongoose = require('mongoose')
const Schema = mongoose.Schema;

//Activity Model
const ActivitySchema = new mongoose.Schema({
  activityID: {
    type: Number,
    required: true,
  },  
  activityText: {
    type: String,
    required: false,
  },
  activityQuestion: {
    type: String,
    required: false,
  },  
}, {timestamps: true});


//Section Model
const SectionSchema = new mongoose.Schema({
  sectionName: {
    type: String,
    required: false,
  },  
  sectionPage: {
    type: Number,
    required: true,
  },
  overviewImage: {
    type: String,
    required: false,
  },
  orderIndex: {
    type: String,
    required: false,
  },  
  Activities: [ActivitySchema]
}, {timestamps: true});


//Program Model 
const ProgramSchema = new mongoose.Schema({
  programName: {
    type: String,
    unique: true, required: true, dropDups: true
  },
  programDescription: {
    type: String,
    required: false,
  },
  totalSections: {
    type: Number,
    required: false,
  },  
  programSections: [SectionSchema]
}, {timestamps: true});


const Program = mongoose.model('Program', ProgramSchema)
module.exports = Program;

