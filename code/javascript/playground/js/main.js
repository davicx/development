console.log("hiya!")

//PART 1: Local Storage
//Set
//localStorage.setItem("userName", "davey");

//Get
console.log("Local " + localStorage.getItem('userName'));

//Remove
//localStorage.removeItem('userName')

//PART 2: Session Storage
//Set
sessionStorage.setItem("userName", "davey");
sessionStorage.setItem("userName", "frodo");

//Get
console.log("Session " + sessionStorage.getItem('userName'));

//Remove
//sessionStorage.removeItem('userName')

//PART 3: Cookies
document.cookie = 'name=david; expires = ' + new Date(2022, 8, 1).toUTCString();
document.cookie = 'nameTwo=frodo; expires = ' + new Date(9999, 8, 1).toUTCString();
