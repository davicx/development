import os
import csv
import heapq
import os.path

#Set Constants 
FILE_PATH = "C:/Users/vasquez_d/Desktop/development/ad_hoc/data_files/"
METAL_LEVEL_CONSTANT = 'Silver' 

def main():

    #Step 1: Load data from zips.csv and plans.csv into a List of Plan and Zip objects and load slcsp.csv into a List 
    slcsp_list = load_slcsp(FILE_PATH)
    zips_list= load_zips(FILE_PATH)
    plans_list = load_silver_plans(FILE_PATH)

    #Step 2: Create a list of MasterSLCSP objects for each zip code we are trying to find the SLCSP for 
    slcsp_master_objects_list = create_slcsp_objects(slcsp_list)

    #Step 3: Get the Rate Area Pair (State, Rate Area) from the zips.csv file for each zip code we are intersted in finding 
    for slcsp_object in slcsp_master_objects_list:
        slcsp_object.getRateArea(zips_list)

    #Step 4: Based on the Rate Area Pair from Step 3 find all the rates in plans.csv that match the State, Rate Area and Metal Level
    for slcsp_object in slcsp_master_objects_list:
        slcsp_object.getPlanCosts(plans_list)

    #Step 5: With the list of rates try to determine the SLCSP and return its associated information as a dictionary 
    final_slcsp_list = determineSLCSP(slcsp_master_objects_list)

    #Step 6: Write the outcome to our slcsp.csv file 
    write_silver_plans(FILE_PATH, final_slcsp_list)

#FUNCTIONS: Functions to handle working with Files 
#Function A.1: Load Zipcodes to Find from CSV File (SLCSP.CSV)
def load_slcsp(FILE_PATH):
    internal_zip_codes_list = []

    try:
        with open(FILE_PATH + 'slcsp.csv', 'r') as zip_code_file:
            zipCodesReader = csv.reader(zip_code_file)  
            next(zipCodesReader)
            for currentZipCodeRow in zipCodesReader:  
                internal_zip_codes_list.append(currentZipCodeRow[0]) 
            
        return internal_zip_codes_list

    except IOError:
        print('Please make sure your path is correctly pointing to the slcsp.csv file ')
        return internal_zip_codes_list

#Function A.2: Load Relevent Zipcodes from CSV File (zips.csv) 
def load_zips(FILE_PATH):
    relevant_zips_array = []

    try:
        with open(FILE_PATH + 'zips.csv') as file:
            zipsReader = csv.reader(file)
            
            #Skip the header 
            next(zipsReader) 
            for currentZipsRow in zipsReader:
                zip_code = currentZipsRow[0]
                state = currentZipsRow[1]
                county_code = currentZipsRow[2] 
                name = currentZipsRow[3]
                rate_area = currentZipsRow[4]
                zip_rate_object = Zips(zip_code, state, county_code, name, rate_area)               
                relevant_zips_array.append(zip_rate_object) 

        return relevant_zips_array

    except IOError:
        print('Please make sure your path is correctly pointing to the zips.csv file ')
        return relevant_zips_array

#Function A.3: Load Plans Data    
def load_silver_plans(FILE_PATH): 
    silver_plans_array = []
    
    try:
        with open(FILE_PATH + 'plans.csv') as file:
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
        return silver_plans_array      
    
    except IOError:
        print('Please make sure your path is correctly pointing to the plans.csv file ')
        return silver_plans_array    

#Function A.4: Write Rates to slcsp.csv file
def write_silver_plans(FILE_PATH, final_slcsp_list): 
    with open (FILE_PATH + 'slcsp.csv', 'w', newline='') as new_file:
        fieldnames = ['zipcode', 'rate']
        thewriter = csv.DictWriter(new_file, fieldnames=fieldnames)
        thewriter.writeheader()
        rates_found = 0

        for slcsp_row in final_slcsp_list:
            zipcode = str(slcsp_row['zipcode'])
            rate = slcsp_row['rate']

            if rate != "":
                rate_formatted = "{:.2f}".format(rate)
                rates_found = rates_found + 1
            else:
                rate_formatted = ""
            thewriter.writerow({'zipcode': zipcode, 'rate':rate_formatted})
        
        print(str(rates_found) + " rates were found")

#FUNCTIONS B: Logic related Functions 
#Function B.1: Create a list of MasterSLCSP objects from a list of zip codes 
def create_slcsp_objects(slcsp_array):
    slcsp_objects_list = []

    for zip_code in slcsp_array:
        current_zip_object = MasterSLCSP(zip_code)
        slcsp_objects_list.append(current_zip_object)

    return slcsp_objects_list

#Function B.2: Given a list of MasterSLCSP objects determine the second lowest cost silver plan for a given zipcode and return a list of these as dictionaries 
def determineSLCSP(slcsp_master_objects_list):
    slcsp_list = []

    for slcsp_object in slcsp_master_objects_list: 
        temp_rate_list = slcsp_object.rate_list
        temp_rate_list_length = len(temp_rate_list)

        if temp_rate_list_length > 2: 
            lowest_two_plans = heapq.nsmallest(2, temp_rate_list)
            lowest_silver_plan = lowest_two_plans[1]

            current_slcsp = {
                "zipcode": slcsp_object.zipcode,
                "rate": lowest_silver_plan
            }
            slcsp_list.append(current_slcsp)
        else:
            current_slcsp = {
                "zipcode": slcsp_object.zipcode,
                "rate": ""
            }
            slcsp_list.append(current_slcsp)

    return slcsp_list


#CLASSES:
#Class to hold Plan Data
class Plan:
    __slots__ = ['zipcode', 'state','metal_level', 'rate','rate_area']
    def __init__(self, state, metal_level, rate, rate_area):
        self.state = state
        self.metal_level = metal_level
        self.rate = rate
        self.rate_area = rate_area

#Class to hold Zip Code Data 
class Zips:
    __slots__ = ['zipcode', 'state','county_code', 'name','rate_area']
    def __init__(self, zipcode, state, county_code, name, rate_area):
        self.state = state
        self.zipcode = zipcode
        self.county_code = county_code
        self.name = name
        self.rate_area = rate_area

#Class to work with Insurance Plans and Determine Rates 
class MasterSLCSP:

    def __init__(self, zipcode):
        self.zipcode = zipcode

    #A method to get a list of state and rates for a given zipcode 
    def getRateArea(self, zips_array):
        temp_rate_area_list = []
        temp_state_area_list = []

        #Get all the potential rate areas and states for a given zipcode 
        for zips in zips_array:
            if zips.zipcode == self.zipcode:
                temp_rate_area_list.append(zips.rate_area)
                temp_state_area_list.append(zips.state)

        #Convert this to a Set, this will allow us to know if there is just one state and rate area    
        rate_set = set(temp_rate_area_list)  
        state_set = set(temp_state_area_list)  

        #Set the Rate Area if it can be determined 
        if len(rate_set) < 2:
            self.rate_can_be_determined = "true"
            self.rate_area = temp_rate_area_list[0]
        else:
            self.rate_can_be_determined = "false"
            self.rate_area = "0"

        #Set the State if it can be determined (this most likely will be true unless a zip code is in two states, which is rare)    
        if len(state_set) < 2:
            self.single_state_zip_code = "true"
            self.state = temp_state_area_list[0]
        else: 
            self.single_state_zip_code = "false"
            self.state = "N/A"

    #A method to get all the Silver Plan Costs for a given State and Rate Area Pair 
    def getPlanCosts(self, plans_list):
        if self.rate_can_be_determined == "true":
            slcsp_rate_area = str(self.rate_area)
            internal_rate_list = []

            #This goes through the plan list and gets all the silver plan rates for the Rate Area Pair 
            for plan in plans_list:   
                if plan.rate_area == slcsp_rate_area and plan.state == self.state:
                    internal_rate_list.append(float(plan.rate))    
            internal_rate_list.sort()
            self.rate_list = internal_rate_list
        else: 
            self.rate_list = []

if __name__ == "__main__":
    main()
