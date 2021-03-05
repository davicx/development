import csv
 

#Open Facilities to Process 
with open('C:/wamp/www/development/career/affirm/data/small/loans.csv') as file:
    plansReader = csv.reader(file)

    for currentPlansRow in plansReader:
        amount = currentPlansRow[0]
        interest_rate = currentPlansRow[1]
        id = currentPlansRow[2]
        bank_id = currentPlansRow[3]
        print(amount, " ", interest_rate, " ", id, " ", bank_id)

"""
#Open Loans to Process 
with open('C:/wamp/www/development/career/affirm/data/small/loans.csv') as file:
    plansReader = csv.reader(file)

    for currentPlansRow in plansReader:
        interest_rate = currentPlansRow[0]
        amount = currentPlansRow[1]
        id = currentPlansRow[2]
        default_likelihood = currentPlansRow[3]
        state = currentPlansRow[4]
        #print(id, " ", interest_rate, " ", amount, " ", state)
"""	
