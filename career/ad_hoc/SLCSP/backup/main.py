import csv
from classes.Plan import Plan
from functions import DataFunctions
#https://www.w3schools.com/python/numpy_array_search.asp
#Arrays of Data 
plan_objects_array = []
zip_codes_array = []
zip_codes_of_interest_array_of_dictionaries = [] 

#STEP 1: Load Zip Codes (slcsp.csv)
zip_codes_array = DataFunctions.load_zipcodes()

#STEP 2: Load Plans Data (plans.csv)
plan_objects_array = DataFunctions.load_silver_plans()
  

#STEP 3: Load Zip Code Data (zips.csv) into a Dictionary and put this in an array This Returns an array of Dictionaries 
zip_codes_of_interest_array_of_dictionaries = DataFunctions.load_rates_by_plan()
     
#STEP 4: This is SLSCP 
slscp_array_of_dictionaries = []
for zip_dictionary in zip_codes_of_interest_array_of_dictionaries:
    for zip_slcsp in zip_codes_array:
        if zip_dictionary["zip_code"] == zip_slcsp:
            #print(zip_dictionary["zip_code"] + " " + zip_dictionary["state"] + " " + zip_dictionary["rate_area"])
            zip_code = zip_dictionary["zip_code"]
            state = zip_dictionary["state"]
            rate_area = zip_dictionary["rate_area"]

            slscp_dictionary = {
                "zip_code": zip_code,
                "state": state,
                "rate_area": rate_area
            }
            
            slscp_array_of_dictionaries.append(slscp_dictionary)      
   


#STEP 6: Loop Over SLSCP and Find Silver Plan Cost


for current_plan in slscp_array_of_dictionaries: 
    #print(current_plan["zip_code"] + " " + current_plan["rate_area"] + " " + current_plan["state"])
    temp_rates_array = []
    for plan in plan_objects_array: 
        #print(current_plan["state"])
        if plan.state == current_plan["state"] and plan.rate_area == current_plan["rate_area"]:
            temp_rates_array.append(plan.rate) 
            
print(len(temp_rates_array))

"""
#STEP 7: Find Silver Plan Cost
for plan in plan_objects_array: 
    if plan.state == "OR" and plan.rate_area == "2":
        print(plan.rate)
 
print(len(slscp_array_of_dictionaries))
print(len(plan_objects_array))
"""
 
"""
thisdict =	{
    "state": "OR",
    "plans": [100, 101, 102]
}
x = thisdict["plans"]
print(x)
"""
"""
thisdict =	{
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x = thisdict["model"]
print(x)
"""

#mostly working
"""
count = 0
for slcp_dictionary in slscp_array_of_dictionaries:
    #print(slcp_dictionary["zip_code"] + " " + slcp_dictionary["state"] + " " + slcp_dictionary["rate_area"])
    for current_plan_object in plan_objects_array:
        if current_plan_object.state == slcp_dictionary["state"] and slcp_dictionary["rate_area"] == current_plan_object.rate_area:
            print(slcp_dictionary["zip_code"])
            print(current_plan_object.state + " + " + current_plan_object.rate + " " + current_plan_object.rate_area)
            print("___________________")      
            count = count + 1   
            
print(count)
"""


            

"""
    if count > 50: 
        break            
    count = count + 1    
    
    
    thisdict =	{
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}

x = thisdict["model"]
print(x)
for zip_code_to_find_plan in zip_codes_array:
    if count > 100: 
        break            
    count = count + 1       

    for zip in zip_codes_of_interest_array_of_dictionaries:
        print(zip_code_to_find_plan)
        print(zip_codes_of_interest_array_of_dictionaries[zip])
        print("_________________")
  for zip in zip_codes_of_interest_array_of_dictionaries:
    #print(zip_code_to_find_plan)
    #print(zip_codes_of_interest_array_of_dictionaries[zip])
    #print("_________________")  

"""        
        #if zip_code_to_find_plan == "48418": 
        #    print("OUTPUT: " + zip_code + " " + state + " " + rate_area) 


#for x in thisdict:
#  print(thisdict[x])

#print(zip_code_to_find_plan)
#print(len(zip_codes_of_interest_array_of_dictionaries))    





#count = count + 1
#print(str(zip_code_to_find_plan[0]))
#if zip_code == "48418": 
#    print("OUTPUT: " + zip_code + " " + state + " " + rate_area) 

#with open('C:/Users/Vasquezd/Desktop/SLCSP/data_files/answers.csv') as csvfile:
#    reader = csv.DictReader(csvfile)
#    for row in reader:
#        print(row['zipcode'], row['rate'])
        
        
   
    
#Loop through the whole zips.csv file 
#for zip_code in zip_codes_array:
    #print(zip_code)

#print("Internal Loop " + zip_code)
"""
if row == zip_code:
    state = row[1]
    county_code = row[2]
    name = row[3]
    rate_area = row[4]
    print(zip_code + " " + state + " " + rate_area) 
"""               
#for zip_code in zip_codes_array:
    #print(zip_code)


rate_area_dictionary = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
#print(thisdict)

#Only Create Objects for the Silver Plans 
#if metal_level == METAL_LEVEL_CONSTANT:
#    plan_id = Plan(state, metal_level, rate, rate_area)
#    silver_plans_array.append(plan_id) 


#TEMP#
#Plans for 97330 
benton_rates_array_temp = []

count = 0

for current_plan in plan_objects_array:
    if current_plan.state == "OR" and current_plan.rate_area == "2":
        #print(current_plan.state + " " + current_plan.rate_area)
        benton_rates_array_temp.append(current_plan.rate)

#print(len(benton_rates_array_temp))
benton_rates_set_temp = list(set(benton_rates_array_temp))

benton_rates_set_temp.sort()

#print(len(benton_rates_set_temp))
#print(benton_rates_set_temp[1])
#for rate in benton_rates_array_temp:  
#   print(rate)




