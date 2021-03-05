import csv

from classes.GeneralCovenants import GeneralCovenants 
from classes.Facility import Facility
from classes.Covenant import Covenant
from classes.Loan import Loan

all_facilities = [] 
all_covenants = []
all_loans_original = [] 
all_loans = [] 

#Function 2A: Load Facility data from a csv file
def load_facilities(FILE_PATH):
    with open(FILE_PATH + 'facilities.csv') as file:
        facilityReader = csv.reader(file)

        next(facilityReader)
        
        for currentLine in facilityReader:
            amount = currentLine[0]
            interest_rate = currentLine[1]
            id = currentLine[2]
            bank_id = currentLine[3]
            current_facility = Facility(id, bank_id, amount, interest_rate)
            all_facilities.append(current_facility)
        
        return all_facilities

#Function 2B: Load Covenant data from a csv file
def load_covenants(FILE_PATH):
    with open(FILE_PATH + 'covenants.csv') as file:
        covenantReader = csv.reader(file)

        next(covenantReader)
        
        for currentLine in covenantReader:
            facility_id = currentLine[0]
            max_default_likelihood = currentLine[1]
            bank_id = currentLine[2]
            banned_state = currentLine[3]
            current_covenant = Covenant(facility_id, max_default_likelihood, bank_id, banned_state)
            all_covenants.append(current_covenant)

        return all_covenants

#Function 3A: Load Loan data from a csv file
def load_loans(FILE_PATH):
    with open(FILE_PATH + 'loans.csv') as file:
        loanReader = csv.reader(file)
        
        next(loanReader)
        
        for currentLine in loanReader:
            interest_rate = currentLine[0]
            amount = currentLine[1]
            id = currentLine[2]
            default_likelihood = currentLine[3]
            state = currentLine[4]
            
            current_loan = Loan(id, amount, interest_rate, default_likelihood, state)
            all_loans_original.append(current_loan)

        all_loans = all_loans_original
            
    return all_loans

