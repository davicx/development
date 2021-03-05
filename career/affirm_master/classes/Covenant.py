#A Class that Holds a Single Covenant 
class Covenant:
  def __init__(self, facility_id, max_default_likelihood, bank_id, banned_state):
    self.facility_id = facility_id
    self.max_default_likelihood = max_default_likelihood
    self.bank_id = bank_id
    self.banned_state = banned_state

