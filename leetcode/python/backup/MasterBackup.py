from collections import deque

#Queue
my_queue = deque()
my_queue.append(1)
my_queue.append(2)
my_queue.append(3)
print(my_queue)
print(my_queue.popleft())

#Stack
"""
my_stack = list()
my_stack.append(4)
my_stack.append(7)
my_stack.append(12)
my_stack.append(19)
print(my_stack)
print(my_stack.pop())
print(my_stack)
"""

"""
#Double Loop
nums = [1,2,3,4,5]
left_pointer = 0
right_pointer = 2

while right_pointer < len(nums):
    print("Left: ", nums[left_pointer], " Right: ", nums[right_pointer])
    left_pointer +=1
    right_pointer +=1

#Single Loop
nums = [1,2,3,4,5]
count = 0

while count < len(nums):
    print(count, " ", nums[count])
    if(count == 2):
        count += 1
    count += 1
"""

