const Program = require('./../models/program');
const Section = require('./../models/section');
const mongoose = require('mongoose');
mongoose.connect('mongodb+srv://modernHealth:GYRE1T1aarCPLDsi@cluster0.qrzt6.mongodb.net/modern_health?retryWrites=true&w=majority', {useNewUrlParser: true, useUnifiedTopology: true});

//Drop Current Collections

//Create Section 1: Leadership Development Program
leadershipSections = [];

for(let i = 1; i <= 10; i++) {
    let sectionName = "Leadership Development Program Page " + i;
    let sectionPage = i;
    let currentSection = new Section({
        sectionName: sectionName,
        sectionPage: sectionPage
    })
    leadershipSections.push(currentSection);
}

let leadership = new Program({
    programID: 1,
    programName: 'Leadership Development Program',
    programDescription: 'A Modern Health Leadership Development Program',
    totalSections: 2,
    programSections: leadershipSections
})

leadership.save()
    .then((result)  => {
       console.log(result)
    })
    .catch((err) => { 
    console.log(err)
});


//Create Section 2: Cognitive Behavioral Therapy
behavioralSections = [];

for(let i = 1; i <= 8; i++) {
    let sectionName = "Cognitive Behavioral Therapy Program Page " + i;
    let sectionPage = i;
    let currentSection = new Section({
        sectionName: sectionName,
        sectionPage: sectionPage
    })
    behavioralSections.push(currentSection);
}

let behavioral = new Program({
    programID: 2,
    programName: 'Cognitive Behavioral Therapy',
    programDescription: 'A Modern Health Cognitive Behavioral Therapy',
    totalSections: 8,
    programSections: behavioralSections
})

behavioral.save()
    .then((result)  => {
       console.log(result)
    })
    .catch((err) => { 
    console.log(err)
});


function exit() {
    mongoose.disconnect();
}



