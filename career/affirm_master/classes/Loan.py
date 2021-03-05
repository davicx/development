#A Class that Holds a Single Loan Request from a Borrower 
class Loan:
  def __init__(self, id, amount, interest_rate, default_likelihood, state):
    self.id = id
    self.amount = amount    
    self.interest_rate = interest_rate
    self.default_likelihood = default_likelihood
    self.state = state
 

#interest_rate	amount	id	default_likelihood	state