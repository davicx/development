#A Class that Holds a Single Facility. After it is instantiated we can add the Loan Restrictions to this
class GeneralCovenants:
  def __init__(self, facility_id, bank_id):
    self.facility_id = facility_id
    self.max_default_likelihood = 0
    self.bank_id = bank_id
    self.banned_states = set()

"""
class MyClass(object):
    __slots__ = ['name', 'identifier']
    def __init__(self, name, identifier):
        self.name = name
        self.identifier = identifier
        self.set_up()
"""