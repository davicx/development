import os
import sys 
wait_list = [1,3,2]
exec_list = [4,3,5]

comb_list = list(zip(wait_list, exec_list)) 
comb_list.sort() 
list1, list2 = list(zip(*comb_list)) 
print(list1[0],list2[0])
"""

 

 

 

 

 """
