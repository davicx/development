#A Class to hold Assignments of each Loan to a Facility
class Assignment:
  def __init__(self, loan_id, facility_id):
    self.loan_id = loan_id
    self.facility_id = facility_id