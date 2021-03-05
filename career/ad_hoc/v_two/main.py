import csv
from classes.Plan import Plan
from classes.Zips import Zips
from classes.MasterSLCSP import MasterSLCSP
from functions import DataFunctions
import time
import heapq

#ADD SLOTS 
#Remove ARRAY 
#SLCSP

#FILE PATH: Set this to the File Path where your files are located 
file_path = "C:/Users/Vasquezd/Desktop/development/ad_hoc/data_files/"

#STEP 1: Load All Data from the CSV Files 
#Step 1A: Get a list of zipcodes to find the SLCSP (slcsp.csv)
slcsp_array = DataFunctions.load_zipcodes(file_path)

#Step 1B: Load zipcode data as a list of Zips Objects (zips.csv)
zips_array = DataFunctions.load_zips(file_path)

#Step 1C: Load the plan data as a list of Plan Objects (plans.csv) 
plans_array = DataFunctions.load_silver_plans(file_path)

#STEP 2: 
slcsp_master_objects_list = []


#STEP 4: Create the slcsp objects for each zip (51) we are trying to find the rate for 
for zip_code in slcsp_array:
    current_zip_object = MasterSLCSP(zip_code)
    slcsp_master_objects_list.append(current_zip_object)


#STEP 5: For our slcsp Objects we need to get their rate areas and their states 
for zip_object in slcsp_master_objects_list:
    temp_rate_area_list = []
    temp_state_area_list = []
    for zips in zips_array:
        if zips.zipcode == zip_object.zipcode:
            temp_rate_area_list.append(zips.rate_area)
            temp_state_area_list.append(zips.state)
   
    zip_object.rate_area_list = temp_rate_area_list   
    zip_object.state_list = temp_state_area_list
    rate_set = set(temp_rate_area_list)  
    state_set = set(temp_state_area_list)  

    #Set the Rate Area if it can be determined 
    if len(rate_set) < 2:
        zip_object.rate_can_be_determined = "true"
        zip_object.rate_area = temp_rate_area_list[0]

    #Set the State if it can be determined (this most likely will be true unless a zip code is in two states, which is very rare)    
    if len(state_set) < 2:
        zip_object.single_state_zip_code = "true"
        zip_object.state = temp_state_area_list[0]

#STEP 6: Get all the Rates for each zip codes Silver Plans 
for zip_object in slcsp_master_objects_list:    
    if zip_object.rate_can_be_determined == "true":
        slcsp_state = str(zip_object.state)
        slcsp_rate_area = str(zip_object.rate_area)

        temp_rate_list = []

        #The Big Loop 
        for plan in plans_array:   
            if plan.state == slcsp_state and plan.rate_area == slcsp_rate_area:
                temp_rate_list.append(float(plan.rate))
        #print(zip_object.zipcode)
        temp_rate_list.sort()
        zip_object.rate_list = temp_rate_list
        #print(len(temp_rate_list))
         

#STEP 7: Find Second Lowest Plan
final_slcsp_list = []


for zip_object in slcsp_master_objects_list: 
    
    #print(zip_object.rate_list)
    temp_rate_list = zip_object.rate_list
    temp_rate_list_length = len(temp_rate_list)
    #print(temp_rate_list)
    if temp_rate_list_length > 2: 
        lowest_two_plans = heapq.nsmallest(2, temp_rate_list)
        lowest_silver_plan = lowest_two_plans[1]
        #print(zip_object.zipcode + " " + str(lowest_silver_plan))
        #print(zip_object.rate_list)
        #print(lowest_silver_plan)
        current_slcsp = {
            "zipcode": zip_object.zipcode,
            "rate": lowest_silver_plan
        }
        final_slcsp_list.append(current_slcsp)
    else:
        #print(zip_object.zipcode)
        #print("NOT FOUND " + zip_object.zipcode)
        current_slcsp = {
            "zipcode": zip_object.zipcode,
            "rate": ""
        }
        final_slcsp_list.append(current_slcsp)

for row in final_slcsp_list:
    rate = str(row['rate'])
    zipcode = str(row['zipcode'])
    print(zipcode + " " + rate)

#Write to CSV
with open ('C:/Users/Vasquezd/Desktop/development/ad_hoc/data_files/learning.csv', 'w') as new_file:
    fieldnames = ['zipcode', 'rate']
    thewriter = csv.DictWriter(new_file, fieldnames=fieldnames)

    thewriter.writeheader()

    for slcsp_row in final_slcsp_list:
        rate = str(slcsp_row['rate'])
        zipcode = str(slcsp_row['zipcode'])
        thewriter.writerow({'zipcode': zipcode, 'rate':rate})


"""     
 #NOTES 
#The Big Loop 
for plan in plans_array:   
    if plan.state == "GA" and plan.rate_area == "6":
        temp_rate_list.append(float(plan.rate))
#print(temp_rate_list)
temp_rate_list.sort()
#print(temp_rate_list) 
            print(plan.state + " " + plan.rate_area)
        print("__________________")   
"""     

"""
            if plan.state == zip_object.state and plan.rate_area == zip_object.rate_area:
                print(plan.rate)
                print(plan.state)
                print(plan.rate)
                print(plan.rate_area)
""" 

    #print(zip_object.rate)
"""
for zip_object in slcsp_master_objects_list:    
    for plan in plans_array:
        count = count + 1
        if zip_object.state == plan.state and zip_object.state and zip_object.rate_area == plan.rate_area:
            print(plan.rate)
        #print(zip_object.rate)

print(count)
"""








#STEP 5: (CHECK) This finds if we can get a rate area 
for zip_object in slcsp_master_objects_list:
    rate_list = zip_object.rate_area_list
    rate_set = set(rate_list)
    #print(zip_object.zipcode)
    #print(zip_object.rate_area_list)
    #print(zip_object.state_can_be_determined)
    #print(zip_object.state)
    #print(zip_object.zipcode)
    #print(zip_object.rate)
    #print(zip_object.rate_can_be_determined)
    #print(zip_object.rate)

    #print(zip_object.getslcspRate())
    #print(zip_object.zipcode)
    #print(zip_object.state_list)    
    #print(zip_object.rate_area_list)
    #print(rate_set)
    #print(len(rate_list))
    #print(len(rate_set))
    #print("___________")


"""



for zip_object in slcsp_master_objects_list:
    count = 1
    #print(zip_object.zipcode)

for zip_object in slcsp_master_objects_list:
    print(zip_object.zipcode)
    for zips in zips_array:  
        temp_rate_area_list = []

        if zip_object.zipcode == zips.zipcode:   
            temp_rate_area_list.append(zips.rate_area)
            print(temp_rate_area_list)
            #print("current object: " + zip_object.zipcode)
            #zip_object.rate_area_list.append(zips.rate_area)
            #print(zips.rate_area)
            
            #zip_object.rate = zip_object.rate_area
            #print(zips.zipcode + " State " + zips.state + " Rate Area " + zips.rate_area)

"""
#for zip_object in slcsp_master_objects_list:
#    print(zip_object.rate_area_list)

"""
rate_area_list = []
state_list = []
for slcsp_temp in slcsp_array:
    current_object = Masterslcsp(slcsp_temp)
    slcsp_master_objects_list.append(current_object)

hiya = Masterslcsp(97330)
print(hiya.zipcode)
hiya.state = "OR"
print(hiya.state)
hiya.rate_area_list.append(4)
hiya.rate_area_list.append(5)
hiya.rate_area_list.append(3)

print(hiya.rate_area_list)
"""

"""
slcsp_master_list = []

for slcsp in slcsp_array:
    for zip in zips_array:    
        if slcsp == zip.zipcode: 
            #print(zip.zipcode + " " + zip.state + " " + zip.rate_area) 
            #If the current zip is not in the added zip list add it  
            slcsp_current_dictionary = {
                "zipcode": zip.zipcode,
                "state": zip.state,
                "rate_area":  zip.rate_area
            }
            slcsp_master_list.append(slcsp_current_dictionary)
"""
#for slcsp in slcsp_master_list:
#    print(slcsp["zipcode"] + " " + slcsp["state"]+ " " + slcsp["rate_area"])


#A class Instantiate with zip code from slcsp (51 classes)
#Has a List of States 
#Has a list of zips
#Has a list of Rate Areas 
#when adding if the zip of the state equals the main zip add the rate area to its object 



#for object in slcsp_master_objects_list:
#    print(object.zipcode)




"""
CODE
slcsp_master_list_with_duplicates = []


for slcsp in slcsp_array:
    for zip in zips_array:    
        if slcsp == zip.zipcode: 
            #print(zip.zipcode + " " + zip.state + " " + zip.rate_area)  
            slcsp_current_dictionary = {
                "zipcode": zip.zipcode,
                "state": zip.state,
                "rate_area":  zip.rate_area
            }
            slcsp_master_list_with_duplicates.append(slcsp_current_dictionary)


seen = set()
slcsp_master_list = []
for d in slcsp_master_list_with_duplicates:
    t = tuple(d.items())
    if t not in seen:
        seen.add(t)
        slcsp_master_list.append(d)

 

for slcsp in slcsp_master_list:
    #Add First Dictionary and Get the zipcode 
    #new_zip = slcsp["zipcode"]
    print(slcsp["zipcode"] + " " + slcsp["state"]+ " " + slcsp["rate_area"])

CODE
"""

"""
# Find keys in common
a.keys() & b.keys() # { 'x', 'y' }
# Find keys in a that are not in b
a.keys() - b.keys() # { 'z' }
# Find (key,value) pairs in common
a.items() & b.items() # { ('y', 2) }
These kinds of operations can also be used to alter or filter dictionary contents. For
example, suppose you want to make a new dictionary with selected keys removed. Here
is some sample code using a dictionary comprehension:
# Make a new dictionary with certain keys removed
c = {key:a[key] for key in a.keys() - {'z', 'w'}}
# c is {'x': 1, 'y': 2}


thisdict["year"] = 2018
if zip_code == slcsp_zip:
state = currentPlansRow[1]
county_code = currentPlansRow[2] #not needed 
name = currentPlansRow[3]
rate_area = currentPlansRow[4]
zip_rate_object = Zips(zip_code, state, county_code, name, rate_area)               
relevant_zips_array.append(zip_rate_object) 
"""
#print(zip.zipcode + " " + zip.state + " " + zip.rate_area)  

"""

time.sleep(.2)

self.state = state
self.zipcode = zipcode
self.county_code = county_code
self.name = name
self.rate_area = rate_area

#ALMOST WORKS 
#Need to handle how some Zips have multiple Rate Areas
#Need to handle can't find state (are any states missing)
#STEP 4: Find Second Lowest Plan 
for zip in zips_array:
    #print(zip.zipcode + " " + zip.state + " " + zip.rate_area)    
    rate_array = []

    for plan in plans_array: 
        if plan.state == zip.state and plan.rate_area == zip.rate_area:
            rate_array.append(plan.rate)
            rate_array.append(plan.rate)
            
    rate_array = list(dict.fromkeys(rate_array))
    rate_array.sort()

    print(zip.zipcode)
    rate_array_length = len(rate_array)

    if rate_array_length > 1:
        rate_array = list(dict.fromkeys(rate_array))
        rate_array.sort()   
        lowest_two_plans = heapq.nsmallest(2, rate_array)
        print "SLCSP "+ lowest_two_plans[1]
    print("_______________________")
"""







"""
slcsp_dictionary = {
  "zipcode": "64148",
  "state": "MO",
  "rate_area": "3",
  "rate_list": [4,5,3,7]
}

for rate in slcsp_dictionary["rate_list"]:
    print(rate)
""" 

#for rate in rate_array:
#    print rate

#lowest_two_plans = heapq.nsmallest(2, rate_array)
#print(lowest_two_plans[1])

#STEP 6: Check State 

"""

#STEP 5: Find Second Lowest Plan (manually) 
rate_array = []
for plan in plans_array: 
    if plan.state == "TX" and plan.rate_area == "10":
        rate_array.append(plan.rate)
        rate_array.append(plan.rate)
        
rate_array = list(dict.fromkeys(rate_array))
rate_array.sort()


all_rates_array = [] #[An array of Dictionaries]

all_zips_array = DataFunctions.load_all_zips()

#for zip in all_zips_array:
#    print(zip.zipcode)

#for index, zip in enumerate(all_zips_array):
#    print(index, zip.zipcode)

zip_codes_array = []

for zip in all_zips_array:
    current_zip = zip["zip_code"]
    zip_codes_array.append(zip["zip_code"])


all_zips_sorted_array = sorted(zip_codes_array, key = lambda i: i['zip_code'])

for zip in all_zips_sorted_array:
    print(zip["zip_code"])
"""
#SORT THE ZIPS
"""
for zip in all_zips_array:
    print(zip["zip_code"])
zip_rate_area_one = {
    "state": "AL",
    "zip": 11111,
    "rate_area": 13
}
zip_rate_area_two = {
    "state": "AL",
    "zip": 55555,
    "rate_area": 13
}
zip_rate_area_three = {
    "state": "AL",
    "zip": 77777,
    "rate_area": 13
}
zip_rate_area_four = {
    "state": "AL",
    "zip": 44444,
    "rate_area": 13
}
zip_rate_area_five = {
    "state": "AL",
    "zip": 33333,
    "rate_area": 13
}
rates_array = [zip_rate_area_one, zip_rate_area_two, zip_rate_area_three, zip_rate_area_four, zip_rate_area_five]

for rate in rates_array:
    print(rate["zip"])

rates_sorted_array = sorted(rates_array, key = lambda i: i['zip'])

print("sorted")
for rate in rates_sorted_array:
    print(rate["zip"])
"""
#ORDER A LIST
"""
#my_list = [20, 15, 3, 19, 8, 6, 5, 3, 1, 19, 2]

#for plan in plans_array:
#    print(plan.)
#print(my_list)
#my_list.sort()
#print(my_list)

 
"""

"""
WORKS
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
"""
#NOTES
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