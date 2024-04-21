## Fish Weight Simulation

### Project Setup and Modules
* The project requires [Python](https://www.python.org/) 3.4 or above 
* It also uses [Pandas](https://pypi.org/project/pandas/#installation-from-sources) to work with our data and csv files    
* This project was built on a mac please reach out with any windows specific questions. 

### Installation and Running
STEP 1: Check Python Installation
From your terminal check that you have Python by running `python -V`   
You should see a message like Python 3.9.6

STEP 2: Install Pandas 
You should be able to use pip (which comes with your Python installation) and `run pip install pandas` 

STEP 3: Set up path to csv data
Make sure to set the path to the csv files when you start the program. 

### Project Structure
The project structure is fairly simple.   
**Main.py** is the entry point into the application and contains the salmon_growth() function which performs the logic.   
**Utils.py** is the logic needed by the main program and test_utils.py tests our code.  
**Data** The csv data is stored in the excel folder. There are three main files. Temperature_series.csv which reads the waw data the program uses. Temperature_series_error.csv which is test data to throw an error. Temperature_series_solved.csv which is hand solved data to compare our answer with.

    .
    ├── ...    
    ├── classes              
    │   ├── Salmon.py                     
    ├── constants 	
        ├── constants.py      						 
    ├── excel    
        ├── temperature_series.csv
        ├── temperature_series_error.csv
        ├── temperature_series_solved.csv					 
    ├── hello.py
    ├── simple.py
    ├── main.py
    ├── utils.py
    ├── test_utils.py
    └── ...

### Testing
python -m unittest test_utils.py

### Function Inputs (utils.py)
#### Function A1: Calculate Salmon Growth as a Function of Water Temperature ####
This function is the main equation to calculate salmon growth per day based on water temperature.

#### Function B1: Read in CSV File ####
This function is used to read in our data.

#### Function B2: Adjust for Significant Figures ####
This function adjusts for significant figures and makes sure we do not add to many.

### Questions
Please feel free to reach out if there are any issues
vasquezd@oregonstate.edu

 

