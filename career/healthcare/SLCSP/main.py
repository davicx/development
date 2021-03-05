import csv
from classes.Plan import Plan
from classes.Zips import Zips
from functions import DataFunctions

  
    
#https://www.w3schools.com/python/numpy_array_search.asp

#STEP 1: Get Original Zipcodes to Find (slscp.csv)
slscp_original_array = DataFunctions.load_zipcodes()

#STEP 2: Load Zip Data only returns those we are intersted in finding [An array of Zip Code Objects] (zips.csv)
zips_array = DataFunctions.load_zips(slscp_original_array)

#STEP 3: Load Plans Data [An array of Plan Objects] (plans.csv) 
plans_array = DataFunctions.load_silver_plans()

all_rates_array = [] #[An array of Dictionaries]

for zip in zips_array: 
    print("NEW ZIP " + zip.state + " " + zip.zipcode)
    
    lowest_silver_plan_array = []
    
    for plan in plans_array: 
        if plan.state == zip.state and plan.rate_area == zip.rate_area:
            #Find Second Lowest Plan 
            lowest_silver_plan_array.append(plan.rate)
            #print(plan.state + " " + plan.rate_area + " " + plan.rate)
    
    print(len(lowest_silver_plan_array))    
    print("RATES")
    for rate in lowest_silver_plan_array:
        print(rate)
    print("RATES")
  
    

"""
    #Create the Data to find the outcome
    zip.state = {
        "state": zip.state,
        "zip": zip.zipcode,
        "rate_area": zip.rate_area
    }
    all_rates_array.append(zip.state)

for current_list_of_rates in all_rates_array:
    print(current_list_of_rates["state"] + " " + current_list_of_rates["zip"] + " " + current_list_of_rates["rate_area"] )
       




current_plan["state"] 
thisdict =	{
    "state": "OR",
    "plans": [100, 101, 102]
}
x = thisdict["plans"]
"""