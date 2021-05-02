const Section = require('./../models/Section');
const mongoose = require('mongoose');
mongoose.connect('mongodb+srv://modernHealth:GYRE1T1aarCPLDsi@cluster0.qrzt6.mongodb.net/modern_health?retryWrites=true&w=majority', {useNewUrlParser: true, useUnifiedTopology: true});

/*
//Load All Program Data
const programs = [
    new Program({
        programName: 'Leadership Development Program',
        programDescription: 'A Modern Health Leadership Development Program'
    
    }),
    new Program({
        programName: 'Cognitive Behavioral Therapy',
        programDescription: 'A Modern Health Cognitive Behavioral Therapy'
    
    }),
    new Program({
        programName: 'New Parenting ',
        programDescription: 'A Modern Health New Parenting Program'
    
    }),
    new Program({
        programName: 'Mindful Communication ',
        programDescription: 'A Modern Health Mindful Communication Program '
    
    }),        
];


let finished = 0;

for(let i = 0; i < programs.length; i++) {
    programs[i].save(function(err, result) {
        finished++;
        if(finished === programs.length){
            exit();
        }
    });
}

function exit() {
    mongoose.disconnect();
}

*/