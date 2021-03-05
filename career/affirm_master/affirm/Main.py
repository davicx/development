import csv
from classes.Facility import Facility
from classes.Covenant import Covenant
from classes.Assignment import Assignment
from classes.Loan import Loan
from classes import dataFunctions 

#FILE_PATH = "C:/wamp/www/development/career/affirm/data/large/"
FILE_PATH = "C:/wamp/www/affirm/data/large/"

all_assignments = []
 
#STEP 1: Load all Data from the csv files  
all_covenants = dataFunctions.load_covenants(FILE_PATH) 
all_loans = dataFunctions.load_loans(FILE_PATH)
all_facilities = dataFunctions.load_facilities(FILE_PATH) 

#Sort Facilities to behave as a stack so facilities with the lowest interest rates will use funds first  
all_facilities_sorted = sorted(all_facilities, key=lambda x: x.interest_rate)

#Add Covenant Data to each facility 
#Function 1A: Add Covenants to each Facility 
for facility in all_facilities:
    for covenant in all_covenants:
        if(facility.id == covenant.facility_id):    
            if(covenant.banned_state != ""):
                facility.banned_states.add(covenant.banned_state)
            if(covenant.max_default_likelihood != ""):
                facility.max_default = covenant.max_default_likelihood


#STEP 2: Check Covenant Restrictions 
#Function 1B: Check that Facility has enough Funds 
def check_funds(loan_amount, current_funds_in_facility):
    if float(current_funds_in_facility) - float(loan_amount) >= 0:
        return True
    else:
        return False

#Function 1C: Check that the consumer Default Rate is not too high    
def check_default(loan, facility):
    default_risk_to_high = True
    
    if  float(loan.default_likelihood) > float(facility.max_default):
        default_risk_to_high = False
    
    return default_risk_to_high
           
#Function 1D: Make sure Loan Applicant does not live in a state restricted by the Facilities Covenants         
def check_state(loan, facility):
    banned_state = True

    if loan.state in facility.banned_states:
        banned_state = False

    return banned_state

#Function 1E: Process all Loans 
for loan in all_loans:

    #This starts with the Facility with the lowest interest rate and makes the loan to the first available Facility
    for facility in all_facilities_sorted:
        funds_ok = check_funds(loan.amount, facility.amount)
        default_ok = check_default(loan, facility)
        state_ok = check_state(loan, facility)
        
        if funds_ok == True and default_ok == True and state_ok == True:
            print("The Loan ", loan.id, " was made at Facility ", facility.id, " for ", loan.amount)
            facility.all_loans.append(loan.id)
            facility.makeWithdrawal(loan.amount)

            #Keep track of each loans so we can output each loan assignment and total yield 
            current_assignment ={"loan_id": loan.id, "facility_id": facility.id }
            all_assignments.append(current_assignment)
            facility.calculateLoanYield(loan.id, loan.amount, loan.default_likelihood, loan.interest_rate)
            break
 

#STEP 3: Output the total facility yield and each loans assignment to our csv files 
#Output Assignments 
with open(FILE_PATH + 'assignments.csv', 'w', newline='') as csvfile:
    fieldnames = ['loan_id', 'facility_id']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

    writer.writeheader()
 
    for line_assignment in all_assignments:
        writer.writerow(line_assignment)

#Output Yields
with open(FILE_PATH + 'yields.csv', 'w', newline='') as csvfile:
    fieldnames = ['facility_id', 'expected_yield']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
	
    writer.writeheader()

    for line_facility in all_facilities_sorted:
        current_facility = {'facility_id': line_facility.id, 'expected_yield': line_facility.total_yield}
        writer.writerow(current_facility)

