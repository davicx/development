import math
import pandas as pd
import sys
import re
from pathlib import Path
from constants import constants

'''
FUNCTIONS A: All Biology Related Functions  
	1) Function A1: Calculate Salmon Growth as a Function of Water Temperature

FUNCTIONS B: All Functions Related to Common Utilities  
	1) Function B1: Read in CSV File
    2) Function B2: Adjust for Significant Figures 
'''

#FUNCTIONS A: All Biology Related Functions  
#Function A1: Calculate Salmon Growth as a Function of Water Temperature
def calc_weight(weight_cur, temp_cur):

    #Calculate days growth from formula
    w_beta = math.pow(weight_cur, constants.BETA)
    temp = math.exp(temp_cur * constants.TAU)
    weight = constants.ALPHA * w_beta
    weight_new_raw = weight * temp + weight_cur

    #Adjust for significant figures
    current_sig_figs = sig_figs([weight_new_raw, temp_cur])
    #weight_new = round(weight_new_raw, current_sig_figs)
    print(weight_new_raw)
    print(current_sig_figs)
    #print(format(weight_new_raw, '.4g'))
    #sig_fig_formula = str('.',  current_sig_figs, 'g')
    #weight_new = float(format(weight_new_raw, sig_fig_formula))
    #print(weight_new)
    #print("")
    #print(float(format(weight_new_raw, '.','g')))


    return weight_new_raw

    

#FUNCTIONS B: All Functions Related to Common Utilities  
#Function B1: Read in CSV File
def open_csv(file_name, optionalFilePath):
    try:
        cwd = Path.cwd()
        temperature_file = cwd / 'excel' / file_name
        print("Current Path: ", temperature_file)
        data = pd.read_csv(temperature_file)
        return data
    
    except FileNotFoundError:
        print("Current Path: ", temperature_file)
        print("We could not find this file and will try to open with your path as a string")
        pass

    try:
        data = pd.read_csv(optionalFilePath)
        print("We were able to open with the path you included")
        return data
    
    except FileNotFoundError:
        print("We could not find this file")
        sys.exit(1)

#Function B2: Adjust for Significant Figures 
def sig_figs(nums):
    min_figs = sys.maxsize

    #Loop over inputs and count the characters as a string
    for num in nums:
        string_num = str(num)

        #If the number contains a Decimal do not count '.' 
        #Any number with a last digit of '.' will be assumed to have a trailing 0 (10. would be viewed as 10.0 with 3 sig figs)
        if re.search(r"[.]", string_num):
            num_length = len(string_num) - 1

        #Does not contain a Decimal so we can count all the digits
        else:
            print(string_num, " does not have period")
            num_length = len(string_num)

        min_figs = min(min_figs, num_length)
    
    #Return the smallest significant figures of the input numbers
    return min_figs

     