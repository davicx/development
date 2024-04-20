import pandas as pd
import time
import sys
import pathlib

file_name = "sample.csv"


def main():
    hello()
    
def hello():
    data = open_csv()

    for index, row in data.iterrows():
        username = row['username']
        city = row['city']
        message = row['message']
        print(username, " ", city, " ", message)
        print(" ")

        time.sleep(1)

def open_csv():
    try:
        file_path = pathlib.Path(__file__)
        data = pd.read_csv('/Users/dvas22/Desktop/David/www/python/excel/' + file_name)
        #data = pd.read_csv(pathlib.Path(__file__))
        print(pathlib.Path.cwd())
        p = pathlib.Path(__file__)

        print(p)
        return data
    
    except FileNotFoundError:
        print("We could not find this file")
        sys.exit(1)

if __name__ == "__main__":
    main()

'''

#Base Paths 
user_name = paths["user_name"]
geography_folder = paths["geography_folder"]
download_folder_temp = paths["download_folder_temp"]
download_folder = paths["download_folder"]
status_file = paths["status_file"]

#Search Link
search_link = currentBasin.get_basin_path()

#Set Basin Status CSV File 
status_data = pd.read_csv(status_file, index_col=0)

def main():
    
    #OSU Login
    #single_login() #this is for non Tufts users 
    
    #Tufts Login:
    login_tufts_user(user_name)
    
    #Run Main Program
    single_basin_search() 
    time.sleep(60)


def main():
    
    #OSU Login
    #single_login() #this is for non Tufts users 
    
    #Tufts Login:
    login_tufts_user(user_name)
    
    #Run Main Program
    single_basin_search() 
    time.sleep(60)

if __name__ == "__main__":
    main()

    try:
        sudoku = open(prompt, 'r').readlines()
    except FileNotFoundError:
        print("Wrong file or file path")
    else:
        break
        
        def FileCheck(fn):
    try:
      open(fn, "r")
      return 1
    except IOError:
      print "Error: File does not appear to exist."
      return 0
p = Path(__file__).with_name('sample.csv')
with p.open('r') as f:
    print(f.read())

'''
