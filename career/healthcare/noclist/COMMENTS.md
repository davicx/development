## Ad Hoc: Retrieve the NOC list Homework 

### Overview of Program
This program was designed to make calls to the Bureau of Adversarial Dossiers and Securely Encrypted Code (BADSEC) API to 
retrieve a list of VIP users. It is written utilizing Node.js. 

### Installation and Running Instructions 
#### Project Setup 
1. The first step is to install [Node.js](https://nodejs.org/en/download/) 
	- More instructions can be found at [Mozilla Help](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Express_Nodejs/development_environment)
2. Navigate to a place where you want and create a new folder for your app
	- *mkdir noclist*
	- *cd noclist*
3. Initilize your project 
	- *npm init*
		- You can accept the default settings by hitting Enter 
4.  Install the Modules with [NPM](https://www.npmjs.com/get-npm) 
	- *npm install axios*
		- For our API Calls
	- *npm install nodemon*
		- So we don't have to keep restarting our Server *optional 
	- *npm install express*
		- The program was developed with Express Installed 
5. Install [Docker](https://docs.docker.com/get-docker/)
 
#### Running Project 
1. Open the Project and create a file called App.js and paste the code in (or add the included code App.js) 
2. Since this program makes a call to an API we must start this using Docker 
	- docker run --rm -p 8888:8888 adhocteam/noclist
	- You should see Listening on http://0.0.0.0:8888.
3. You can now run the app 
	- *node app.js* or *nodemon app.js*
4. If everything works you will get the list of users 

### Program Logic 
- The overall logic for this program is fairly straight forward. We make a call to get an Authentication Token in Function A.2. and then call Function A.3
in order to get the list of VIP Users. 
- What makes it a little tricky is that we want to control the flow of logic or the program will not work. Calling APIs can be slow and since Node.js is asynchronous we use Async and Await
so that while we are requesting data we do not move forward until that data is received. For example, we need the Authentication Token to create the Checksum. Once we have these we can make our 
call to get the users. 

### Functions
#### FUNCTIONS A: Functions related to making API Calls 
- Function A.1: Retrieve the List of Users
- Function A.2: Retrieve the Authentication Token from the BADSEC API
- Function A.3: Get a list of VIP users from the BADSEC API

#### FUNCTIONS B: Functions for Authentication, Authorization and Checksums 
- Function B.1: Create a Checksum 
 
### Future Work and Thoughts
1. `Program Design:` Everything is in one file for simplicity but future work could separate logic. 
Adding more error and exception handling to the code would also be useful especially for a server that may not be reliable. 

 
