# Code Challenge for Pluralsight 
# David Vasquez
# Vasquezd@oregonstate.edu 

import os.path
import re
import time 
import numpy as np
from collections import Counter

#FILE PATH: Set this to the File Path where the story and common words files are located 
file_path = "path/to/your/file"

def main():

    #STEP 1: Load and clean Alice's Adventures in Wonderland and the List of Common Words into a list 
    common_words_list = load_common_words(file_path)
    alice_story_list = load_text_file(file_path)

    #STEP 2: Make sure that the files were read properly 
    if alice_story_list and common_words_list:
        
        #Pass both lists to the function to find common words and their indexes that need to be removed  
        words_to_remove_list = find_words_to_remove(alice_story_list, common_words_list)

        #STEP 3: Remove all the common words from the story 
        for word_to_delete in words_to_remove_list:
            word_to_delete_left_index = word_to_delete['left_index']
            word_to_delete_right_index = word_to_delete['right_index']
            del alice_story_list[word_to_delete_left_index:word_to_delete_right_index]

        #STEP 4: Count final words and print the output 
        alice_story_final = Counter(alice_story_list).most_common()

        for (word,word_count) in alice_story_final:
            print("{0:16} {1:4}".format(word + ":", word_count)) 
            time.sleep(.2)
    else: 
        print("Please make sure that both Common Words and the Story have been read in")

#FUNCTIONS: 
#Function A.1: Get a List of all the Common Words       
def load_common_words(file_path):
    common_words_list = []

    try:
        with open(file_path + 'common_words.txt', 'r') as common_words_file:
            #Iterate over each line, convert to a single lowercase word and add to common_words_list 
            current_line = common_words_file.readlines()
            current_line = [x.strip().lower() for x in current_line] 
            common_words_list = current_line
        return common_words_list
    except IOError:
        print('Please make sure your path is correctly pointing to the Common Words File ')
        return common_words_list

#Function A.2: Load and Clean a Text File 
def load_text_file(file_path):   
    text_words_list = []

    try:
        with open(file_path + 'alice.txt', 'r') as alice_file:
            for line in alice_file:

                #Part 1: Remove Punctuation and Special Characters in each line and create a List with each value being a single word 
                cleaned_line = re.sub('[\[\]?,()-;:!".`*_]', ' ', line) 
                text_line_list = cleaned_line.split()

                #Part 2: Make sure List is not empty 
                if text_line_list:

                    #Part 3: Add all the words that contain more then one letter (this also removes both the common words A and I)
                    for word in text_line_list:   
                            if re.search('[a-zA-Z]', word):
                                if (len(word) > 1):
                                    text_words_list.append(word.lower().rstrip("'").lstrip("'") )   

        return text_words_list

    except IOError:
        print('Please make sure your path is correctly pointing to Alice\'s Adventures in Wonderland ')
        return text_words_list

#Function B.1: Create a List that contains Dictionaries of the words to remove and their indexes 
def find_words_to_remove(alice_story_list, common_words_list): 
    
    #Set up all the Lists and Variables
    words_to_remove_list = []
    words_to_remove_index_list = []
    total_list_shift = 0
    current_list_shift = 0

    #Sort the Lists so that a binary search can be used 
    alice_story_list.sort()

    #Use numpy to find the left and right indexes of all the words to remove from the main Alice List 
    np_alice_story_list = np.array(alice_story_list)
    
    for current_word in common_words_list:
        left_index = np.searchsorted(np_alice_story_list, current_word)
        right_index = np.searchsorted(np_alice_story_list, current_word, side='right')
        
        try:
            word_found = alice_story_list[left_index]
            words_to_remove_index_list.append(left_index)
            words_to_remove_index_list.append(right_index)
        except IndexError:
            break

        #This accounts for the fact that as we remove common words the indexes will shift
        #If we didn't do this after the first delete all the other indexes would be incorrect        
        if word_found == current_word:
            actual_left_index = left_index - total_list_shift
            actual_right_index = right_index - total_list_shift
            word_to_remove_dictionary = {
                    "current_word": word_found,
                    "left_index": actual_left_index,
                    "right_index": actual_right_index
            }
    
            words_to_remove_list.append(word_to_remove_dictionary)
    
        #Determine how much the List will shift after the word has been deleted 
        current_list_shift = right_index - left_index
        total_list_shift = total_list_shift + current_list_shift

    return words_to_remove_list

if __name__ == "__main__":
    main()