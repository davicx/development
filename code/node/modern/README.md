## Modern Health Coding Challenge

 
### Prerequisites
 

### Installation and Running
#### Project Setup 
npm init
npm install express
npm install morgan
npm install mysql
npm install mongoose --save
npm install mocha --save

npm install --save-dev nodemon



#### Database Setup
Mongo DB: 
User: modernHealth
PW: GYRE1T1aarCPLDsi
PW: th9HI4ydlU0coyvz

mongodb+srv://modernHealth:<password>@cluster0.qrzt6.mongodb.net/myFirstDatabase?retryWrites=true&w=majority

// sequelize pg pg-hstore

##### Database Seeding
Navigate to seed folder
node ProgramSeeder.js


### Project Structure

    .
    ├── ...
    ├── classes 	                   
    │   ├── Assignments.py               
    │   ├── Covenant.py              
    │   ├── DataFunctions.py             
    │   ├── Facility.py             
    │   ├── Loan.py           
    ├── data 							 
    ├── Affirm- Discussion Questions     
    ├── Main.py 						 
    ├── README.MD
    └── ...
 
### API Routes
This is the API you would call to get all the programs 
/api/programs

This is the API that displays 
/api/section/section_id

###JSON
Program:
{ 
	"name":"John", 
	"age":30, 
	"city":"New York"
	Sections: [
		{ "name":"John", "age":30, "city":"New York" },
		{ "name":"John", "age":30, "city":"New York"}
	]
}



### Function Inputs
#### Function 1A: Add Covenants to each Facility ####
Parameters: 
all_facilities (Facility Objects): List of Facility Objects 
all_covenants (Covenant Objects): List of Covenant Objects 
 
Returns: 
Updates Facility Object with Banned States and Max Default Rate
 
#### Function 1B: Check that Facility has enough Funds ####
Parameters: 
loan_amount (int): The requested loan amount
current_funds_in_facility (decimal): Remaining Facility Funds

Returns: 
boolean: Returns True if there is enough funds to make the loan
 
#### Function 1C: Check that the consumer Default Rate is not too high ####
Parameters: 
Loan (Object): The current Loan instance
Facility (Object): The current Facility instance

Returns: 
boolean: Returns True if the loan can be made
 
#### Function 1D: Make sure Loan Applicant does not live in a state restricted by the Facilities Covenants ####
Parameters: 
Loan (Object): The current Loan instance
Facility (Object): The current Facility instance

Returns: 
boolean: Returns True if the state is not banned and the loan can be made
 
#### Function 1E: Process all Loans ####
Parameters: 
all_loans (list of Loans): The whole list of Loans
all_facilities_sorted (list of Facilities):  The whole list of Facilities

Returns: 
csv: This will output the csv files yields.csv and assignments.csv
 

### Questions
Please feel free to reach out if there are any issues
vasquezd@oregonstate.edu

 

