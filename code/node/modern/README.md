## Modern Health Coding Challenge
This is a small program to develop an API that will output Programs for a self paced mental health library. 
 
### Prerequisites
You need to have Node.js installed on your computer to run this program. 

### Installation and Running
#### Project Setup 
##### Create a new project and install express
npm init
npm install express

##### Install all other Dependencies 
npm install mongoose --save
npm install mocha --save-dev
npm install morgan --save-dev
npm install chai --save-dev
npm install chai-http --save-dev
npm install --save-dev nodemon

#### Database Setup
Mongo DB: 
User: modernHealth
PW: GYRE1T1aarCPLDsi

mongodb+srv://modernHealth:<password>@cluster0.qrzt6.mongodb.net/myFirstDatabase?retryWrites=true&w=majority

##### Database Seeding
There are two ways you can get the data. There is a public MongoDB database that I put up that you can access or you can 
create your own MongoDB database and run the seed file. 

Run Seed File: 
1) Navigate to seed folder
2) node ProgramSeeder.js


### Project Structure

    .
    ├── ...
    ├── models	                   
    │   ├── Program.js               
    │   ├── Section.js              
    │   ├── Activity.js                    
    ├── node_modules							 
    ├── routes
    │   ├── program.js         
    ├── seed
    │   ├── ProgramSeeder.js  
    ├── test
    │   ├── app_test.js  
    ├── app.js (Entry Point into the Application) 
    ├── package.json
    ├── README.MD
    └── ...
 
### API Routes
This is the API you would call to get all the programs 
//ROUTE 1: Get all Programs
http://localhost:3003/api/programs

//ROUTE 2: Get a Program based on its input ID 
http://localhost:3003/api/programs/program_id
http://localhost:3003/api/programs/1

//ROUTE 3: Find an Individual Section
http://localhost:3003/api/programs/program_id/section/section_id
http://localhost:3003/api/programs/1/section/3


###Testing
From the projects Root Directory run
npm run test


### Overall Thoughts 
There is a lot to do on this project. 

#### Navigating the API
The API for Sections has a Page Number and Total Sections for each Section Area.



### Questions
Please feel free to reach out if there are any issues
vasquezd@oregonstate.edu

 

