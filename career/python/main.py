import pandas as pd
import time
import sys
import pathlib
from constants import constants
from functions import biology_utils
from functions import utils

file_name = "temperature_series.csv"

def main():
    hello()
    
def hello():
    print("hello")
    biology_utils.calc_weight(5, 8.447)
    
    # Attemp to read in data 
    data = utils.open_csv(optionalFilePath = "/Users/david/Desktop/David/www/development/career/python/excel/temperature_series.csv")
    
    for index, row in data.iterrows():
        day = row['Day #']
        date = row['Day/Month']
        temp = row['Temp']
    
        if index == 0:
            current_weight = biology_utils.calc_weight(constants.INITIAL, temp)
            print(day, " ", date, " ", temp, "|| ", current_weight)
        else:
            current_weight = biology_utils.calc_weight(current_weight, temp)
            #print(day, " ", date, " ", temp, "|| ", current_weight)
        
        time.sleep(.01)
        if(day == 365):
            print("START ", constants.INITIAL)
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