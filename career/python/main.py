import pandas as pd
import time
import math
import sys
import re
import pathlib
from constants import constants
import utils
from decimal import *
import pandas as pd
import numpy as np

def main():
    salmon_csv = "temperature_series.csv"
    #salmon_csv = "temperature_series_error.csv"
    starting_weight = 5
    #salmon_growth(starting_weight, salmon_csv)
    num = 12345.54321

    #print(num)
 
    #new_num = np.format_float_positional(np.float16(num), unique=False, precision=8)
    #print(new_num)
    #nums = [199.8, 20., 20.30]
    #num_sig_figs = sig_figs(nums)
    #print(num_sig_figs)
    x = 1039.48564
    round_to = "6"
    round_amt = '.' + round_to + 'g'
    rounded = format(x, round_amt) 
    round_float = float(rounded)
    print(round_float)

   # print(f"x is approximately {x:5g}")

def salmon_growth(initial_weight, salmon_file):
    
    # Attemp to read in data csv_file
    data = utils.open_csv(salmon_file, optionalFilePath = "/Users/david/Desktop/David/www/development/career/python/excel/" + salmon_file)
 
    for index, row in data.iterrows():
        try:
            day = row['Day #']
            date = row['Day/Month']
            temp = row['Temp']
        except KeyError as ke:
            print("Please double check that the headings in the temperature_series.csv in the excel folder. They should match the following format")
            print("Day # | Day/Month | Temp")
            sys.exit(1)
    
        if index == 0:
            current_weight = utils.calc_weight(initial_weight, temp)
            print(day, " ", date, " ", temp, "|| ", current_weight)
        else:
            current_weight = utils.calc_weight(current_weight, temp)
            print(day, " ", date, " ", temp, "|| ", current_weight)
            print(" ")
        time.sleep(.01)
        
        #time.sleep(.01)
        if(day == 365):
            print("START ", initial_weight)
            print("FINAL ", current_weight)
            break
    print(" ")


if __name__ == "__main__":
    main()



'''



def open_csv():
    try:
        file_path = pathlib.Path(__file__)
        #data = pd.read_csv('/Users/dvas22/Desktop/David/www/python/excel/' + file_name)
        data = pd.read_csv('/Users/david/Desktop/David/www/development/career/python/excel/temperature_series.csv' + file_name)
        return data
    
    except FileNotFoundError:
        print("We could not find this file")
        sys.exit(1)


        #data = pd.read_csv(pathlib.Path(__file__))
        print(pathlib.Path.cwd())
        p = pathlib.Path(__file__)

        print(p)
    temp_weight = format(temp_weight, '.2f')
    #format(math.pi, '.2f')

https://docs.python.org/3/tutorial/floatingpoint.html
Day #	Day/Month	Temp
1	1-Jan	8.447
'''