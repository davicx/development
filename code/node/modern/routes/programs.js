const express = require('express');
const mysql = require('mysql');
const router = express.Router();
const Program = require('./../models/program')
const mongoose = require('mongoose');
//ROUTE 1: Get all Programs
router.get("/programs", (req, res) => {
    Program.find()
        .then((result) => {
            res.send(result)
        })
        .catch((err) => { 
            console.log(err)
        });
})

//ROUTE 2: Get a Program based on its input ID 
//Change to request by program_id 1, 2, 3, 4
router.get("/program/:program_id", (req, res) => {
    //console.log("Fetching user with id: " + req.params.program_id);  
    const program_id = req.params.program_id;
    console.log(mongoose.Types.ObjectId.isValid('608f2d718717b82ba0797bcd'));

    Program.findById(program_id)
        .then((result) => {
            res.send(result)
            console.log(result.totalSections);
        })
        .catch((err) => { 
            console.log(err)
        });
})

//ROUTE 3: Scroll through Sections
router.get("/program/:program_id/section/:page_number", (req, res) => {
    //console.log("Fetching user with id: " + req.params.program_id);  
    const program_id = req.params.program_id;
    const page_number = req.params.page_number;
    Program.findById(program_id)
    .then((result) => {

        const programSections = result.programSections;
        const totalSections = result.totalSections;

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
    })
    .catch((err) => { 
        console.log(err)
    });
 
})


module.exports = router;



/*
router.get("/aprogram", (req, res) => {
    Program.findOne({programName: 'Leadership Development Program'}).then(function(result) {
        res.send(result);
    });
})



*/
