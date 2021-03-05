import csv
from collections import deque
from classes.Facility import Facility
from classes.Covenant import Covenant
from classes.GeneralCovenants import GeneralCovenants
from classes.Assignment import Assignment
from classes.Loan import Loan
from classes import dataFunctions 


#current_covenant = Covenant(facility_id, max_default_likelihood, bank_id, banned_state)
current_one = Covenant(1, .1, 1, "")
current_two = Covenant(1, .2, 2, "CA")
current_three = Covenant(1, .4, 1, "WA")
current_four = Covenant(2, .2, 1, "UT")

all_covenants = []
all_covenants.append(current_one)
all_covenants.append(current_two)
all_covenants.append(current_three)
all_covenants.append(current_four)

covenent_dicts = []
current_facilities = set()

for covenant in all_covenants:
    #print(covenant.facility_id, " Default: ", covenant.max_default_likelihood)
    current_facility_id = covenant.facility_id
    current_bank_id = covenant.bank_id
    current_max_default_rate = covenant.max_default_likelihood
    current_banned_state = covenant.banned_state
 
    #Facility already exists so just update its banned state list
    if current_facility_id in current_facilities:
        print(current_facility_id, " IS ALREADY in a facility")
        print()
         
    else:
        print(current_facility_id, " is not in a facility")
        general_covenant = GeneralCovenants(current_facility_id, current_bank_id)
        general_covenant.banned_states.add(current_banned_state)
        general_covenant.max_default_likelihood = current_max_default_rate

        current_dict = { "facility_id": current_facility_id, "general_covenants":general_covenant }     
        covenent_dicts.append(current_dict)     
        
    current_facilities.add(current_facility_id)
    
    print(current_dict)

print("")
for item in covenent_dicts:
    print(item["facility_id"])
    print(item["general_covenants"].facility_id, " ", item["general_covenants"].banned_states)

"""
x = thisdict["model"]
for covenant in all_covenants:
    #print(covenant.facility_id, " Default: ", covenant.max_default_likelihood)
    current_facility_id = covenant.facility_id
 
    #Facility already exists so just update its banned state list
    if current_facility_id in current_facilities:
        print(current_facility_id, " IS ALREADY in a facility")
         
    else:
        print(current_facility_id, " is not in a facility")
        current_dict = { "facility_id": current_facility_id, "banned_state": covenant.banned_state }     
        covenent_dicts.append(current_dict)     
        
    current_facilities.add(current_facility_id)
    
    #print(current_facilities)



    #Facility does not exist so create a new one 



#print out output
for covenant in covenent_dicts:
    print(covenant)
    pass
"""
#print(current_facilities)

