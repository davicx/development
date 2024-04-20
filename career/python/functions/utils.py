import pandas as pd
import sys
from pathlib import Path

file_name = "temperature_series.csv"

def open_csv(optionalFilePath):
    try:
        #file_path = pathlib.Path(__file__)
        #data = pd.read_csv('/Users/dvas22/Desktop/David/www/python/excel/' + file_name)
        #data = pd.read_csv('/Users/david/Desktop/David/www/development/career/python/excel/' + file_name)

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
