import heapq 
  

#Simple Priority Q
nums = [3,1,5,8,2,9,2]
list = []
heapq.heapify(list) 

for num in nums:
    heapq.heappush(list, num) 

print(list)

#Pop smallest element 
#heapq.heappop(list)
while list:
    print(heapq.heappop(list))

print(list)

  
#Create a Dictionary
heroes = {
    "frodo": 4,
    "bilbo": 3,
    "david": 1
}

print(heroes)
 




""" 
words_dict = {"hiya": 2526, "ab": 12, "cd": 34, "yay": 910, "hi": 67} 
heap = [(-value, key) for key,value in words_dict.items()]
top_two = heapq.nsmallest(2, heap)
largest = [(key, -value) for value, key in top_two]
print(top_two)
print(largest)


# convert dictionary to list of tuples 
di = list(dict_1.items()) 
  
print("dictionary into list :", di) 
  
# converting into heap 
hq.heapify(di) 
  
print("Heapified list of tuples :", di) 
  
# converting heap to dictionary 
di = dict(di) 
  
print("Dictionary as heap :", di)
 
# initializing list 
li = [5, 7, 9, 1, 3] 
  
# using heapify to convert list into heap 
heapq.heapify(li) 
  
# printing created heap 
print ("The created heap is : ",end="") 
print (list(li)) 
  
# using heappush() to push elements into heap 
# pushes 4 
heapq.heappush(li,4) 
  
# printing modified heap 
print ("The modified heap after push is : ",end="") 
print (list(li)) 
  
# using heappop() to pop smallest element 
print ("The popped and smallest element is : ",end="") 
print (heapq.heappop(li)) 

# initializing list  
li1 = [6, 7, 9, 4, 3, 5, 8, 10, 1] 
  
# using heapify() to convert list into heap 
heapq.heapify(li1) 
  
# using nlargest to print 3 largest numbers 
# prints 10, 9 and 8 
print("The 3 largest numbers in list are : ",end="") 
print(heapq.nlargest(3, li1)) 
  
# using nsmallest to print 3 smallest numbers 
# prints 1, 3 and 4 
print("The 3 smallest numbers in list are : ",end="") 
print(heapq.nsmallest(3, li1))
"""