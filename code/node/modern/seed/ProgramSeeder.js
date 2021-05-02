const Program = require('./../models/program');
const Section = require('./../models/section');
const mongoose = require('mongoose');
mongoose.connect('mongodb+srv://modernHealth:GYRE1T1aarCPLDsi@cluster0.qrzt6.mongodb.net/modern_health?retryWrites=true&w=majority', {useNewUrlParser: true, useUnifiedTopology: true});


//Create Section 1: Leadership Development Program
const sectionOne = new Section({
    sectionName: 'my section name!',
    sectionPage: 1
})

const sectionTwo = new Section({
    sectionName: 'my section 2',
    sectionPage: 2
})

let leadership = new Program({
    programName: 'Leadership Development Program',
    programDescription: 'A Modern Health Leadership Development Program',
    totalSections: 2,
    programSections: [sectionOne, sectionTwo] 
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



/*


const sectionTwo = new Section({
    sectionName: 'my section name!'
})


//Load All Program Data
const programs = [
    new Program({
        programName: 'Leadership Development Program',
        programDescription: 'A Modern Health Leadership Development Program',
        programSections: [sectionOne]
    }),
    new Program({
        programName: 'Cognitive Behavioral Therapy',
        programDescription: 'A Modern Health Cognitive Behavioral Therapy',
        programSections: []
    }),
    new Program({
        programName: 'New Parenting ',
        programDescription: 'A Modern Health New Parenting Program',
        programSections: []
    }),
    new Program({
        programName: 'Mindful Communication ',
        programDescription: 'A Modern Health Mindful Communication Program ',
        programSections: []
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
*/
function exit() {
    mongoose.disconnect();
}



