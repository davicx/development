from collections import deque
import heapq 

"""
nums = [1,4,3,2]

myQueue = deque()
myQueue.append(1)
myQueue.append(2)
myQueue.append(3)

print(myQueue)

#Get First Item 
print(myQueue.popleft())
print(myQueue.popleft())
print(myQueue.popleft())
print(myQueue)

#Get Last Item 
#print(myQueue.pop())
"""

#STACK
my_stack = list()
my_stack.append(1)
my_stack.append(2)
my_stack.append(3)

print(my_stack)
print(my_stack.pop())
print(my_stack)

#PRIORITY HEAP:
#initializing list  
nums = [1,4,2,3,5,7,6] 
  
# using heapify() to convert list into heap 
heapq.heapify(nums) 
  
# using nlargest to print 3 largest numbers 
print("The 2 largest numbers in list are : ", end="") 
print(heapq.nlargest(2, nums)) 
  
# using nsmallest to print 3 smallest numbers 
print("The 2 smallest numbers in list are : ",end="") 
print(heapq.nsmallest(2, nums)) 
