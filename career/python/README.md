## Fish Weight Simulation

### Project Setup and Modules
* The project requires Python 3.4 or above 
https://pypi.org/project/pandas/#installation-from-sources

### Installation and Running

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

### Function Inputs
#### Function 1A: Add Covenants to each Facility ####
https://docs.python.org/3/tutorial/floatingpoint.html
 
#### Function 1E: Process all Loans ####
 
### https://github.com/googleapis/google-api-python-client/blob/main/tests/test__auth.py
### Questions
Please feel free to reach out if there are any issues
vasquezd@oregonstate.edu

 

