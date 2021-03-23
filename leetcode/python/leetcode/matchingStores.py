from collections import Counter
from collections import defaultdict
import heapq 

total_loops = 0  
group_one = {"fred_meyer", "starbucks", "winco"}
group_two = {"fred_meyer", "starbucks", "dutch"}
group_three = {"new_morning", "winco", "dutch"}

stores = [group_one, group_two, group_three]
stores_dict = {}


#Step 1: Create a List of all the Stores 
for group in stores:
    for store in group:
        total_loops +=1
        stores_dict[store] = {}

#Fred Meyers
current_store = "fred_meyer"
current_store_dict = { current_store: {} }

store_counter = defaultdict(int)

for group in stores:
    for store in group:
        if current_store in group and current_store != store:
            store_counter[store] +=1

current_store_dict[current_store] = store_counter

print(store_counter)   

#New Morning 
current_store = "new_morning"
current_store_dict = { current_store: {} }

store_counter = defaultdict(int)

for group in stores:
    for store in group:
        if current_store in group and current_store != store:
            store_counter[store] +=1

current_store_dict[current_store] = store_counter

print(store_counter)    

















"""
for store in group_one:
    print(store)
""" 


"""
fred_meyer = {
    "starbucks": 2,
    "winco": 2,
    "dutch": 1
}

stores_dict["fred_meyer"] = fred_meyer
"""


#Step 2: Loop over each group of stores 
"""
for store in store_set:
    print(store)
    for group in stores:
        print(group)

        if store in group:
            print("found ", store)
        else:
            print("NO ", store)
        total_loops +=1
    print("______________")



words = ['hi', 'hello', 'this', 'is', 'hi', 'hello']

words_counter = defaultdict(int)

for word in words:
    words_counter[word] +=1
    

for item in words_counter:
    print(words_counter[item], " ", item)

s = "hi hello this is hi hello"
words = s.split()

counter = Counter(words)
print(words)

#returns list of Tuples
most_common_list = counter.most_common(2)
for item in most_common_list:
    print(item[0])



"""




"""
fred_meyer {
    starbucks: 2,
    winco: 2,
    dutch: 1
}

starbucks {
    fred_meyer: 2,
    winco: 1,
    dutch: 1    
}

new_morning {
    winco: 1,
    dutch: 1    
}

thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
"""
 