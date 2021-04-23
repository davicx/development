"use strict";

//Array of Values
var hobbiton = ["frodo", "sam"];
var bree = ["merry", "pippin"];
var minas_tirith = ["aragon", "faramir"];
var dol_amroth = ["elendil"];

//Associative Array with a list as value
var shire = {
    "hobbiton": hobbiton,
    "bree": bree
};

var gondor = {
    "minas_tirith": minas_tirith,
    "dol_amroth": dol_amroth
};

//Loop over Associative Array
for (var key in shire) {
    if (shire.hasOwnProperty(key)) {
        //console.log("PLACE: " + key);
        let shirePeople = shire[key];
        //console.log(key + " " + shire[key]);
        for(let i = 0; i < shirePeople.length; i++) {
            //console.log(shirePeople[i]);
        }
        //console.log("");
    }
} 

//World Map
var middle_earth = {
    "shire": shire,
    "gondor": gondor,
}

for (var key in middle_earth) {

    //Out Loop: All the Places in the World
    if (middle_earth.hasOwnProperty(key)) {  
        let place = middle_earth[key];
        
        //Inner Loop
        for (var place_key in place) {
            if (place.hasOwnProperty(place_key)) {
                console.log("PLACE: " + place_key);
                let peopleList = place[place_key];

                //Loop Over the List
                for(let i = 0; i < peopleList.length; i++) {
                    console.log(peopleList[i]);
                }
            }
            console.log("");
        }
        /*
        for (var key in shire) {
            if (shire.hasOwnProperty(key)) {
                    //console.log("PLACE: " + key);
                    let shirePeople = shire[key];
                    //console.log(key + " " + shire[key]);
                    for(let i = 0; i < shirePeople.length; i++) {
                        //console.log(shirePeople[i]);
                    }
                    //console.log("");
                }
            } 
        */

    }
} 


