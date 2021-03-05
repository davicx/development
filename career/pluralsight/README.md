#Pluralsight Code Challenge 
General Notes 
- After I finished I simplified the file structure to just one file so it is easier to run and share over Dropbox 
- The project only has some very basic error and exception handling

Installation Instructions:
- The code is all included in the Main.py File 
- Make sure you have a working Python Environment setup preferably with at least Python Version 3 
- Install Numpy (pip install numpy)

Execution Instructions:
- Open the main.py file in Visual Studio, a similar IDE or run from a terminal 
- The program opens two files including the story of Alice's Adventures in Wonderland (Alice.txt) and the list of Common Words (common_words.txt) 
- Before running you need to adjust the path to these two files 
- Once this is done you should be able to run the program and the word count will be output to the terminal 

Logic Explanations 
- Parsing:
    a) The Parsing is fairly simple and occurs in Function A.2
    b) It iterates over each line in the story and parses this into a List (alice_story_list)
- Removing Common Words:
    a) One a List is created of Common Words and Alice they are both sorted so that a binary search can be used 
    b) The Alice List is converted to a Numpy Array because it is fairly efficient and also has a nice binary search that can be used on strings
    c) Function B.1 creates a dictionary for each word that contains the word and its left and right index
    d) The index is adjusted so that as the words are deleted the indexes still match and the correct parts of the List are deleted 
    e) The actual removal is done with the original List (alice_story_list)
    f) A Counter is used to find the occurrences of each word 

List of Functions 
FUNCTIONS A: Functions related to processing Text Files 
    Function A.1: Get a List of all the Common Words 
    Function A.2: Load and Clean a Text File 
FUNCTIONS B:   
    #Function B.1: Create a List that contains Dictionaries of the words to remove and their indexes  
