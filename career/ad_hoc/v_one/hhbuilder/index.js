//FUNCTIONS TABLE OF CONTENTS//
/*

FUNCTIONS A: Household Build Functions  
	1) Function A1: Add New User 
	2) Function A2: Remove User
	3) Function A3: Submit Form (for serialization) 
	
FUNCTIONS B: Folder Related 
	1) Function B1: Select Folder 

*/


//Global Variables 
var all_users = [];
var user_unique_id = 1;

//FUNCTIONS A: User Related 
//Function A1: Add a New User to Household List 
document.querySelector('.add').onclick = function(e) {
	
	//Step 1: Prevent Form Submit 
	e.preventDefault();
	
	//Step 2: Get Form Information 
	var age = document.getElementsByName("age")[0].value;
	var relationship = document.getElementsByName("rel")[0].value;
	var smoker_status = document.getElementsByName("smoker")[0].checked;  
	
	
	//Step 3: Append Form Information to List on Page 	
	var ul = document.getElementsByClassName("household")[0];
	var li = document.createElement("li");
	li.setAttribute("id", user_unique_id);	
	li.appendChild(document.createTextNode(relationship + " " + age + " " + smoker_status));
	ul.appendChild(li);
		
	//g = document.createElement('div');
	//g.setAttribute("id", "Div1");	

	//Add to Global Array 
	var user = {
		current_unique_id: user_unique_id,
		current_age: age,
		current_relationship: relationship,
		current_smoker: smoker_status	
	};
	
	user_unique_id = user_unique_id + 1;
	all_users.push(user); 

	//console.log(user);
	console.log(all_users);
	
}

//Validate data entry (age is required and > 0, relationship is required)
function validatePositiveNumber(numberToValidate) {
	validInput = false;
	
	
	
	if (Number(numberToValidate) > 0) {
		return "more then zero";
	} else {
		return "less then zero";	
	}
	
}


//alert(validatePositiveNumber(""));


//console.log(isNaN(7));

 var num1 = "";
 if(isNaN(num1)){
	//document.write(num1 + " is not a number <br/>");
 }else{
	//document.write(num1 + " is a number <br/>");
 }

//Get Element by ID
//Get Element by Class

/*

document.getElementById("guessButton").addEventListener("click", function(event){
    event.preventDefault();
   handleFireButton();
});
*/


/*
//Global Variables 
var all_users = [];

//FUNCTIONS A: Household Builder Functions  
//Function A1: Add New User 
document.querySelector('.add').onclick = function(e) {
	
	//Prevent Form Submit 
	e.preventDefault();
	
	//Get Form Information 
	var current_user_age = document.getElementsByName("age")[0].value;
	var current_user_relationship = document.getElementsByName("rel")[0].value;
	var current_user_smoker_status = document.getElementsByName("smoker")[0].checked;  

	//Add to Global Array 
	var user = {
		age: current_user_age,
		relationship: current_user_relationship,
		smoker: current_user_smoker_status	
	};
	
	all_users.push(user); 
	console.log(all_users);

	//Add to HTML 
	var ul = document.getElementsByClassName("household")[0];
	var li = document.createElement("li");
	li.appendChild(document.createTextNode(relationship + " " + age));
	ul.appendChild(li);
	
	
}


*/


/*
var myFunction = function() {
    var attribute = this.getAttribute("data-myattribute");
    alert(attribute);
};

for (var i = 0; i < classname.length; i++) {
    classname[i].addEventListener('click', myFunction, false);
}
*/


//Age Relationship Smoker 

/*
var user_one = {
    age: 22,
    relationship: "single",
    smoker:"yes"	
};

var user_two = {
    age: 25,
    relationship: "single",
    smoker:"no"		
};

var all_users = [user_one, user_two];
*/

//console.log(JSON.stringify(all_users));


// expected output: "{"x":5,"y":6}"
//console.log(JSON.stringify([new Number(3), new String('false'), new Boolean(false)]));
// expected output: "[3,"false",false]"
//console.log(JSON.stringify({ x: [10, undefined, function(){}, Symbol('')] }));
// expected output: "{"x":[10,null,null,null]}"
//console.log(JSON.stringify(new Date(2006, 0, 2, 15, 4, 5)));
// expected output: ""2006-01-02T15:04:05.000Z""












//APPENDIX
























