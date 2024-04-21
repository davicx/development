import math
import pandas as pd
import sys
from pathlib import Path
from constants import constants

'''
FUNCTIONS A: All Biology Related Functions  
	1) Function A1: Calculate Salmon Growth as a Function of Water Temperature

FUNCTIONS B: All Functions Related to Common Utilities  
	1) Function B1: Read in CSV File
'''

#FUNCTIONS A: All Biology Related Functions  
#Function A1: Calculate Salmon Growth as a Function of Water Temperature
def calc_weight(weight_cur, temp_cur):
    w_beta = math.pow(weight_cur, constants.BETA)
    temp = math.exp(temp_cur * constants.TAU)
    weight = constants.ALPHA * w_beta
    weight_new = weight * temp + weight_cur

    return weight_new

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
