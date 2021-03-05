import csv
from collections import deque
from classes.Facility import Facility
from classes.Covenant import Covenant
from classes.Assignment import Assignment
from classes.Loan import Loan
from classes import dataFunctions 

all_facilities = []  
all_facilities_sorted = []  
all_covenants = []
all_assignments = []
all_loans = []  

#FILE_PATH = "C:/wamp/www/development/career/affirm/data/large/"
FILE_PATH = "C:/wamp/www/development/affirm/data/large/"
 
#FACILITIES: Open Facilities to Process 
all_facilities = dataFunctions.load_facilities(FILE_PATH) 

#LOANS: Load all Loan Data
all_loans = dataFunctions.load_loans(FILE_PATH)

#COVENANTS: Load all Covenant Data
all_covenants = dataFunctions.load_covenants(FILE_PATH) 


#Add Covenant Data to each facility 
for facility in all_facilities:
    for covenant in all_covenants:
        if(facility.id == covenant.facility_id):    
            if(covenant.banned_state != ""):
                facility.banned_states.add(covenant.banned_state)
            if(covenant.max_default_likelihood != ""):
                facility.max_default = covenant.max_default_likelihood

#Sort Facilities by interest rate 
all_facilities_sorted = sorted(all_facilities, key=lambda x: x.interest_rate)

#Returns True if there is enough funds 
def check_funds(loan_amount, current_funds_in_facility):
    if float(current_funds_in_facility) - float(loan_amount) >= 0:
        return True
    else:
        return False

#Returns True if the loan can be made as the applicant is not too much of a credit risk          
def check_default(loan, facility):
    default_risk_to_high = True
    
    #Check for Max Default Rate
    if  float(loan.default_likelihood) > float(facility.max_default):
        default_risk_to_high = False
        #print("You big risk!")
    
    return default_risk_to_high
           
#Returns True if the applicant does not live in a banned state            
def check_state(loan, facility):
    banned_state = True

    if loan.state in facility.banned_states:
        banned_state = False
        #print("Banned!")
    
    return banned_state

total_loans = 0
#count = 0
 
#print("LOAN", all_loans[0].id, " ", all_loans[0].amount, " ", all_loans[0].default_likelihood) 
#print(all_facilities_sorted[0].id, " ", all_facilities_sorted[0].interest_rate, " ", all_facilities_sorted[0].banned_states)

for loan in all_loans:
    print("LOAN", loan.id, " ", loan.amount, " ", loan.default_likelihood, " ", loan.interest_rate, " ", loan.state) 

    for facility in all_facilities_sorted:
        funds_ok = check_funds(loan.amount, facility.amount)
        default_ok = check_default(loan, facility)
        state_ok = check_state(loan, facility)

        print(facility.id, " ", facility.interest_rate, " ", facility.banned_states)
        print("Funds ", check_funds(loan.amount, facility.amount), " Default ", check_default(loan, facility), " State ", check_state(loan, facility))
        #print("Default ", check_default(loan, facility))
        #print("State ", check_state(loan, facility))
        
        #Make loan for this current facility 
        if funds_ok == True and default_ok == True and state_ok == True:
            print("LOAN MADE AT FACIILTY", facility.id)
            print("Starting Balance at ", facility.id,  " ", facility.amount)
            facility.all_loans.append(loan.id)
            facility.makeWithdrawal(loan.amount)
            print("Ending Balance at ", facility.id,  " ", facility.amount)       
            total_loans = total_loans + 1
            
            #Add Loan to Assignments
            #current_assignment = Assignment(loan.id, facility.id)
            current_assignment ={"loan_id": loan.id, "facility_id": facility.id }
 

            all_assignments.append(current_assignment)

            facility.calculateLoanYield(loan.id, loan.amount, loan.default_likelihood, loan.interest_rate)
            break
 

#SOLUTION: 
#Print out Assignments
for assignment in all_assignments:
    print(assignment)
    pass

#Print out Total Yield 
for facility in all_facilities:
    #print(facility.id, " ", facility.total_yield)
    pass

#Write Answers: Facility Assignment
with open('C:/wamp/www/development/affirm/data/small/output/assignments.csv', 'w', newline='') as csvfile:
    fieldnames = ['loan_id', 'facility_id']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
 
    for line_assignment in all_assignments:
        writer.writerow(line_assignment)

#Write Answers: Yield Assignment
with open('C:/wamp/www/development/affirm/data/small/output/yields.csv', 'w', newline='') as csvfile:
    fieldnames = ['facility_id', 'expected_yield']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
	
    writer.writeheader()

    for line_facility in all_facilities_sorted:
        current_facility = {'facility_id': line_facility.id, 'expected_yield': line_facility.total_yield}
        writer.writerow(current_facility)


