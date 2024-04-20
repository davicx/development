import pandas as pd
import time
import math
import sys
import pathlib

file_name = "temperature_series.csv"

ALPHA = 0.038
BETA = 0.6667
INITIAL = 1
TAU = 0.08

def main():
    hello()
    
def hello():
    print("run simple")
    data = open_csv()
    
    for index, row in data.iterrows():
        temp = row['Temp']
        date = row['Day/Month']
        day = row['Day #']
        print(day)
    
        if index == 0:
            current_weight = calc_weight(INITIAL, temp)
        else:
            current_weight = calc_weight(current_weight, temp)
        time.sleep(.05)
    
        if(day > 365):
            break

    print(" ")


def calc_weight(weight_cur, temp_cur):
    w = math.pow(weight_cur, BETA)
    temp = math.exp(temp_cur * TAU)
    weight = ALPHA * w
    weight_new = weight * temp + weight_cur

    print(" _____ ")
    print("weight ", weight, " temp ", temp)
    print("ANSWER ", weight_new)

    return weight_new


def open_csv():
    try:
        file_path = pathlib.Path(__file__)
        data = pd.read_csv('/Users/dvas22/Desktop/David/www/python/excel/' + file_name)
        return data
    
    except FileNotFoundError:
        print("We could not find this file")
        sys.exit(1)


if __name__ == "__main__":
    main()
