#TYPE 2: With Leetcode 
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

list3 = ListNode("3")        
list2 = ListNode("2", list3)
list1 = ListNode("1", list2)

while list1:
    print(list1.val)
    if list.next == None:
        break
    list1 = list1.next

'''
while(True):
  print(cur.data) #print the data
  if(cur.next is None): #this is our do-while loop emulation, checking if this is the last Node
    break
  cur = cur.next #update cur so we move on in the next iteration
'''