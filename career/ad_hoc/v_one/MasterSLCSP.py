class MasterSLCSP:
    zipcode = 00000
    state = ""
    state_list = []
    single_state_zip_code = "false"  
    
    rate = 0 
    rate_list = []
    
    rate_area = 0
    rate_area_list = []
    rate_can_be_determined = "false"  

    second_lowest_plan = 0

    zip_left_index = 0
    zip_right_index = 0

    plans_state_left_index = 0
    plans_state_right_index = 0

    plans_rates_left_index = 0
    plans_rates_right_index = 0

    def __init__(self, zipcode):
        self.zipcode = zipcode


        #print(self.rate_area_list)
    #print(len(rate_list))
    #print(len(rate_set))

    #Func get Rate
    # user area list 
"""
    def __init__(self, zipcode):
        self.zipcode = zipcode
        self.zipcode = 00000
        self.rate_area = 0
        self.state = ""
        self.rate = 0    
        self.rate_area_list = []
        self.state_list = []
"""