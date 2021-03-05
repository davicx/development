## Ad Hoc: SLCSP Homework 


### Overview of Program
We are looking to find the second lowest cost silver plan (SLCSP) for a number of zip codes. It is important because it
is used as a "benchmark" health plan for an area. The steps to determine this are outlined below.
1) The first step is getting the zip code of interest from the slcsp.csv
2) From here we work to determine the Rate Area for that zip code using the zips.csv file 
3) Once we have the rate area we can utilize plans.csv to determine all the Silver Plan Rates and from this get the SLCSP if
it exists 

### Installation and Running Instructions 
1) Make sure you have Python 3 or higher installed. 
2) Open main.py and set the path the folder where the three csv files (slcsp.csv, zips.csv, plans.csv) are located. 
3) Open a terminal and navigate to the folder with main.py 
4) In the terminal type 'python3 main.py' to run 

### Program Logic 
- The program starts by loading all 51 zip codes we are interested in finding
- From here it uses the MasterSLCSP which is a class where we gather most of the data related to finding the SLCSP
- The MasterSLCSP class has a list of both the states and rate areas for the zip code it represents
- From here we can find if we can determine the rate from the Rate Area and also if it represents a single state
- This class also has a method (determineSLCSP) that will find the SLCSP if it exists and return this as a dictionary
- This dictionary is what we use to write our output into slcsp.csv

### Functions
#### FUNCTIONS A: Functions to handle working with Files 
- Function A.1: Load Zipcodes to Find from CSV File (SLCSP.CSV)
- Function A.2: Load Relevent Zipcodes from CSV File (zips.csv) 
- Function A.3: Load Plans Data    
- Function A.4: Write Rates to slcsp.csv file

#### FUNCTIONS B: Logic related Functions 
- Function B.1: Create a list of MasterSLCSP objects from a list of zip codes 
- Function B.2: Given a list of MasterSLCSP objects determine the second lowest cost silver plan for a given zipcode and return a list of these as dictionaries 

### CLASSES:
- Plan Class: To hold Plan Data 
- Zips Class: To hold Zip Code Data 
- MasterSLCSP Class: To work with Insurance Plans and Determine Rates 

### Future Work and Comments
The code was getting long but I feel there is a lot that could be done to improve things. 
1) `Error Handling:` The main thing would be adding more error and exception handling to the code. There is a lot that could be done 
as working with csv files can be particuarly error prone.
2) `Efficiency:` I just looped through the data but sorting the data and using a binary search would be a much better practice. I did not do this
because I would have needed to write a binary search that worked on my object attributes and would have wanted to include error handling and unit testing
since I think this could add more complexity. 
3) `Unit Testing:` Also, it is not needed but I think proper testing would be essential for a program like this if it was used in Production.
4) `Data:` I left in some data that does not appear to be used but decided to do so for clarity. An example would be the county
code in the zips.csv file. 
