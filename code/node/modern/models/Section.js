const mongoose = require('mongoose')
const Schema = mongoose.Schema;

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
    totalSections: {
      type: Number,
      required: true,
    }
  }, {timestamps: true});
  
/*
const SectionSchema = new mongoose.Schema({
  sectionName: {
    type: String,
    required: true,
  },
  sectionDescription: {
    type: String,
    required: false,
  },
  overviewImage: {
    type: String,
    required: false,
  },
  orderIndex: {
    type: String,
    required: false,
  },  
  sectionPage: {
    type: Number,
    required: true,
  },
  totalSections: {
    type: Number,
    required: true,
  }
  
}, {timestamps: true});
*/
const Section = mongoose.model('Section', SectionSchema)
module.exports = Section;
