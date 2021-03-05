"""
for facilty in all_facilities:
    print(facilty.amount)

for loan in all_loans:
    print(loan.amount)

for covenant in all_covenants:
    print(covenant.banned_state)

"""
"""
current_one = Covenant(1, .05, 1, "WA")
current_two = Covenant(1, .05, 1, "CA")
current_three = Covenant(3, .05, 1, "CA")

all_covenants[current_one.facility_id] = current_one
all_covenants[current_two.facility_id] = current_two
#all_covenants[current_three.facility_id] = current_three
#current_covenant = Covenant(facility_id, max_default_likelihood, bank_id, banned_state)



print(all_covenants.get(1).max_default_likelihood)
print(all_covenants.get(1).banned_state)



#print(allFacilitiesSorted[1].id)
#print(allFacilitiesSorted[1].all_loans)
"""

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
