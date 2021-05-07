const express = require('express');
const mysql = require('mysql');
const router = express.Router();
const Program = require('./../models/program')
const mongoose = require('mongoose');

//ROUTE 1: Get all Programs
router.get("/api/programs", (req, res) => {
    Program.find()
        .then((result) => {
            res.send(result)
        })
        .catch((err) => { 
            console.log(err)
        });
})

//ROUTE 2: Get a Program based on its Program ID (1, 2, 3 or 4)
router.get("/api/program/:program_id", (req, res) => {
    const program_id = req.params.program_id;

    Program.findOne({
            programID: program_id
        }).then((result) => {
            res.send(result)
            console.log(result.totalSections);
        })
        .catch((err) => { 
            console.log(err)
        });
})

//ROUTE 3: Select a Section by giving the Program ID and Section ID 
router.get("/api/program/:program_id/section/:page_number", (req, res) => {

    const program_id = req.params.program_id;
    const page_number = req.params.page_number;

    Program.findOne({
        programID: program_id
    }).then((result) => {
        const allSections = result.programSections;
        const totalSections = result.totalSections;
        
        const currentSection = allSections[page_number - 1];

        //Valid Section
        if(page_number >= 1 && page_number <= totalSections) {
            res.send(currentSection);
  
        //Not a Page (or Section)            
        } else {
           res.send("There is no section that matches " + page_number);
           
        }   
    })
    .catch((err) => { 
        console.log(err)
    });

})

module.exports = router;



/*
//Handle API Navigation 

//First Page (or Section)
if(page_number == 1) {
    res.send(result.programSections)
    console.log("FIRST PAGE Total Sections: " + result.totalSections + " Page Number " + page_number + " Program ID " + program_id);
    
//Middle Pages (or Section)            
} else if (page_number > 1 && page_number < totalSections) {
    console.log("MIDDLE PAGE Total Sections: " + result.totalSections + " Page Number " + page_number + " Program ID " + program_id);
    
//Last Page (or Section)            
} else if (page_number == totalSections) {
    console.log("LAST PAGE Total Sections: " + result.totalSections + " Page Number " + page_number + " Program ID " + program_id);
    
//Not a Page (or Section)            
} else {
    console.log("Error Navigating ");
    
}  
//res.send(currentSection);
*/