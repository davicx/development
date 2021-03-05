from decimal import Decimal

#A Class that Holds a Single Facility and has methods for working with loans
class Facility:
  def __init__(self, id, bank_id, amount, interest_rate):
    self.id = id
    self.bank_id = bank_id
    self.initial_funds = amount
    self.amount = amount
    self.interest_rate = interest_rate
    self.default_rate = 0
    self.max_default = 0  
    self.total_yield = 0
    self.banned_states = set()
    self.all_loans = []

  def getRestrictions(self):
    print("Max Default Rate " + self.max_default)
    print(self.banned_states)
    print("")

  def calculateLoanYield(self, loan_id, loan_amount, default_rate, interest_rate):
    loan_amount = Decimal(loan_amount)
    default_rate = Decimal(default_rate)
    interest_rate = Decimal(interest_rate)
    bank_interest_rate = Decimal(self.interest_rate)
    loan_gain = (1-default_rate) * (interest_rate * loan_amount)
    loan_minus = (default_rate * loan_amount) + (bank_interest_rate * loan_amount)

    loan_yield = loan_gain - loan_minus

    self.total_yield = self.total_yield + loan_yield
 
  def makeWithdrawal(self, loan_amount):
    current_funds = float(self.amount)
    #print("Funds before withdrawal: ", current_funds)
    
    if current_funds - float(loan_amount) < 0:
      print("You don't have enough money to make this withdrawal")
    else:
      self.amount = current_funds - float(loan_amount)
      #print("Funds after withdrawal: ", self.amount)

