import csv
from classes.Plan import Plan
from classes.Zips import Zips

#CONSTANTS
#Metal_Level: This is so we only are looking in Silver Plans 
METAL_LEVEL_CONSTANT = 'Silver' 

#FUNCTIONS: 
#Function A.1: Load Zipcodes to Find from CSV File (SLCSP.CSV)
def load_zipcodes(file_path):
    internal_zip_codes_list = []

    try:
        with open(file_path + 'slcsp.csv', 'r') as zip_code_file:
            zipCodesReader = csv.reader(zip_code_file)  
            #next(zipCodesReader)
            for currentZipCodeRow in zipCodesReader:  
                internal_zip_codes_list.append(currentZipCodeRow[0]) 
               
            #Remove the Header from the CSV    
            del internal_zip_codes_list[0]
    
        return internal_zip_codes_list

    except IOError:
        print('Please make sure your path is correctly pointing to the SLCSP.csv file ')
        return internal_zip_codes_list

#Function A.2: Load Relevent Zipcodes from CSV File (zips.csv) (this is slow need to optimize)  
def load_zips(file_path):
    relevant_zips_array = []

    with open(file_path + 'zips.csv') as file:
        zipsReader = csv.reader(file)
        #next(zipsReader)
        for currentZipsRow in zipsReader:
            zip_code = currentZipsRow[0]
            state = currentZipsRow[1]
            county_code = currentZipsRow[2] #not needed 
            name = currentZipsRow[3]
            rate_area = currentZipsRow[4]
            zip_rate_object = Zips(zip_code, state, county_code, name, rate_area)               
            relevant_zips_array.append(zip_rate_object) 

    del relevant_zips_array[0]        

    return relevant_zips_array

#Function A.3: Load Plans Data    
def load_silver_plans(file_path): 
    silver_plans_array = []
    
    with open(file_path + 'plans.csv') as file:
        plansReader = csv.reader(file)
        
        #Loop through the whole plans.csv file and create an object that represents each plan
        for currentPlansRow in plansReader:
            metal_level = currentPlansRow[2]

            #Only Create Objects for the Silver Plans 
            if metal_level == METAL_LEVEL_CONSTANT:
                plan_id = currentPlansRow[0]
                state = currentPlansRow[1]    
                rate = currentPlansRow[3]
                rate_area = currentPlansRow[4]
                plan_id = Plan(state, metal_level, rate, rate_area)
                silver_plans_array.append(plan_id) 
    
    #del silver_plans_array[0]

    return silver_plans_array      
    
    


""""""""""""""
""""""""""""""

"""
def load_zips(file_path, slscp_original_array):
    relevant_zips_array = []
   
    #This Should Return an Array of 90 Zip Codes from the Original 50 SLSCP we are looking at 
    for slscp_zip in slscp_original_array: 
        with open(file_path + 'zips.csv') as file:
            plansReader = csv.reader(file)
            
            #Read in All Data 
            #Then Sort
            #Then Binary Search 
            for currentPlansRow in plansReader:
                #If this is one of the zips we are interested in using get the info from the zips.csv file
                zip_code = currentPlansRow[0]

                if zip_code == slscp_zip:
                    state = currentPlansRow[1]
                    county_code = currentPlansRow[2] #not needed 
                    name = currentPlansRow[3]
                    rate_area = currentPlansRow[4]
                    zip_rate_object = Zips(zip_code, state, county_code, name, rate_area)               
                    relevant_zips_array.append(zip_rate_object) 

    return relevant_zips_array
"""


"""
def load_zipcodes(file_link):
    internal_zip_codes_list = []
    with open('C:/Users/Vasquezd/Desktop/SLCSP/data_files/slcsp.csv') as zip_code_file:
        zipCodesReader = csv.reader(zip_code_file)  
        
        for currentZipCodeRow in zipCodesReader:  
            internal_zip_codes_list.append(currentZipCodeRow[0]) 
    
    return internal_zip_codes_list
"""



"""
  #Function A.2: Load Relevent Zipcodes from CSV File (zips.csv) (this is slow need to optimize)  
def load_all_zips():
    all_zips_array = []

    with open('C:/Users/Vasquezd/Desktop/SLCSP/data_files/zips.csv') as file:
        plansReader = csv.reader(file)
        
        for currentPlansRow in plansReader:
            #If this is one of the zips we are interested in using get the info from the zips.csv file
        
            zip_code = currentPlansRow[0]
            state = currentPlansRow[1]
            county_code = currentPlansRow[2] #not needed 
            name = currentPlansRow[3]
            rate_area = currentPlansRow[4]
            zip_rate_object = Zips(zip_code, state, county_code, name, rate_area)               
            
         
            zip_rate_object = {
                "zip_code": currentPlansRow[0],
                "state": currentPlansRow[1],
                "county_code": currentPlansRow[2],
                "name": currentPlansRow[3],
                "rate_area": currentPlansRow[4]
            }
            all_zips_array.append(zip_rate_object) 

    return all_zips_array  
    

"""  

""" 
#PAST


#Function A.2: Load Zipcodes from CSV File (Plans.csv)
 

#Function A.3: Load Zipcodes from CSV File (.csv)
def load_rates_by_plan(): 
    zip_codes_of_interest_array_of_dictionaries = []

    with open('C:/Users/Vasquezd/Desktop/SLCSP/data_files/zips.csv') as file:
        zipReader = csv.reader(file)

        for row in zipReader:
            zip_code = row[0]
            state = row[1]
            county_code = row[2]
            name = row[3]
            rate_area = row[4]
            
            rate_area_dictionary = {
                "zip_code": zip_code,
                "state": state,
                "county_code": county_code,
                "name": name,
                "rate_area": rate_area
            }
            
            zip_codes_of_interest_array_of_dictionaries.append(rate_area_dictionary)       
            
    return zip_codes_of_interest_array_of_dictionaries    

#if count > 20: 
#    break            
#count = count + 1 

"""