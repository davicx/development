import csv
from collections import deque
from classes.Facility import Facility
from classes.Covenant import Covenant
from classes.Assignment import Assignment
from classes.Loan import Loan
from classes import dataFunctions 

allFacilities = []  
allFacilitiesSorted = []  
allCovenants = []  
all_assignments = []
allLoans = []  

#FILE_PATH = "C:/wamp/www/development/career/affirm/data/large/"
FILE_PATH = "C:/wamp/www/development/affirm/data/small/"

#FACILITIES: Open Facilities to Process 
allFacilities = dataFunctions.load_facilities(FILE_PATH) 

#COVENANTS: Load all Covenant Data
allCovenants = dataFunctions.load_covenants(FILE_PATH) 

#LOANS: Load all Loan Data
allLoans = dataFunctions.load_loans(FILE_PATH)

#Add Covenant Data to each facility 
for facility in allFacilities:
    for covenant in allCovenants:
        if(facility.id == covenant.facility_id):    
            if(covenant.banned_state != ""):
                facility.banned_states.append(covenant.banned_state)
            if(covenant.max_default_likelihood != ""):
                facility.max_default = covenant.max_default_likelihood

#Sort Facilities by interest rate 
allFacilitiesSorted = sorted(allFacilities, key=lambda x: x.interest_rate)

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
 
#print("LOAN", allLoans[0].id, " ", allLoans[0].amount, " ", allLoans[0].default_likelihood) 
#print(allFacilitiesSorted[0].id, " ", allFacilitiesSorted[0].interest_rate, " ", allFacilitiesSorted[0].banned_states)

for loan in allLoans:
    print("LOAN", loan.id, " ", loan.amount, " ", loan.default_likelihood, " ", loan.interest_rate, " ", loan.state) 

    for facility in allFacilitiesSorted:
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
            current_assignment = Assignment(loan.id, facility.id)
            all_assignments.append(current_assignment)

            facility.calculateLoanYield(loan.id, loan.amount, loan.default_likelihood, loan.interest_rate)
            break
 


#SOLUTION: 
#Print out Assignments
for assignment in all_assignments:
    #print(assignment.loan_id, " ", assignment.facility_id)
    pass

#Print out Total Yield 
for facility in allFacilitiesSorted:
    #print(facility.id, " ", facility.total_yield)
    pass

#print(allFacilitiesSorted[1].id)
#print(allFacilitiesSorted[1].all_loans)

"""
print()
print()
 
loan_amount = 10552
default_rate = 0.02
interest_rate = 0.15
bank_interest_rate = 0.06


loan_gain = (1-default_rate) * (interest_rate * loan_amount)
loan_minus = (default_rate * loan_amount) + (bank_interest_rate * loan_amount)

loan_yield = loan_gain - loan_minus
print(loan_gain)
print(loan_minus)
print(loan_yield)
 
"""



#PROCESS SINGLE LOAN AT ONE FACILITY (WORKS)
"""
current_loan = Loan(3, 74965, .35, .06,  "AL")
loan_amouunt = current_loan.amount
 
current_facility = allFacilitiesSorted[0]

loanStatus = checkLoan(current_loan, current_facility)
sufficientFunds = checkFacilityRemainingFunds(current_loan.amount, current_facility.remaining_funds)

if(loanStatus == True and sufficientFunds == True):
    current_facility.makeWithdrawal(loan_amouunt)
"""
"""
for facility in allFacilitiesSorted:
    print(facility.id, " ", facility.amount, " ", facility.remaining_funds)
    #print(facility.getRestrictions())   
"""


 
#current_loan = Loan(3, 74965, .35, .06,  "AL")
#current_facility = allFacilitiesSorted[0]

#PROCESS LOANS
"""
for current_loan in allLoans:
    loan_amount = current_loan.amount
    print(loan_amount)

    for current_facility in allFacilitiesSorted:
        #print(current_loan.id, " ", current_loan.amount)   
        loanStatus = checkLoan(current_loan, current_facility)
        sufficientFunds = checkFacilityRemainingFunds(current_loan.amount, current_facility.remaining_funds)

        if(loanStatus == True and sufficientFunds == True):
            current_facility.makeWithdrawal(loan_amount)
        else:
            break

for facility in allFacilitiesSorted:
    print(facility.id, " ", facility.amount, " ", facility.remaining_funds)
"""    

"""
#STEP 1: Start Looping over the Facilities with the Best Interest Rate First 

#Step 1A: Check that the max default rate is acceptable 

#Step 1B: Make sure this user is not in a banned state

#If both pass check if there is enough remaining funds

#If there is assign this loan to the facility and close out the loan 
    #Update the facilities remaining funds

#IF NOT: Then go to the next facility and try 


#print(allFacilitiesSorted[0].interest_rate)

































"""
"""
for loan in allLoans:
    print(loan.id, " ", loan.amount, " ", loan.interest_rate, " ", loan.default_likelihood, " ", loan.state)
"""
