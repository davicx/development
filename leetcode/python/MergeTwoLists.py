from operator import le
from re import M


class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next

class LinkedList:
    def __init__(self):
        self.head = None

    def insert_at_begining(self, data):
        node = Node(data, self.head)
        self.head = node

    def insert_at_end(self, data):
        if self.head is None:
            self.head = Node(data, None)
            return

        itr = self.head

        while itr.next:
            itr = itr.next
        itr.next = Node(data, None)

    def get_length(self):
        count = 0
        itr = self.head
        while itr:
            count+=1
            itr = itr.next

        return count
        
    def insert_values(self, data_list):
        self.head = None
        for data in data_list:
            self.insert_at_end(data)

    def remove_at(self, remove_index):
        if remove_index<0 or remove_index>=self.get_length():
            raise Exception("Invalid Index")

        if remove_index==0:
            self.head = self.head.next
            return

        count = 0
        itr = self.head
        while itr:
            if count == remove_index - 1:
                itr.next = itr.next.next
                break

            itr = itr.next
            count+=1

    def insert_at(self, index, data):
        if index<0 or index>self.get_length():
            raise Exception("Invalid Index")

        if index==0:
            self.insert_at_begining(data)
            return
        count = 0
        itr = self.head
        while itr:
            if count == index - 1:
                node = Node(data, itr.next)
                itr.next = node
                break

            itr = itr.next
            count += 1

    def insert_after_value(self, data_after, data_to_insert):
        itr = self.head

        while itr:
            print(itr.data)

            if itr.data == data_after:
                print("found", data_after, "at")
                node = Node(data_to_insert, itr.next)
                itr.next = node

                break

            itr = itr.next

        # Search for first occurance of data_after value in linked list
        # Now insert data_to_insert after data_after node
        
    def find_value_index(self, value):
        itr = self.head
        count = 0
        while itr:
            print(itr.data)

            if itr.data == value:
                print("found", value, "at", count)

            itr = itr.next
            count += 1  

        
    def print(self):
        if self.head is None:
            print("Linked list is empty")
            return
        itr = self.head
        llstr = ''
        while itr:
            llstr += str(itr.data)+' --> ' if itr.next else str(itr.data)
            itr = itr.next
        print(llstr)


l1 = LinkedList()
l1.insert_values([1,2,14])
l2 = LinkedList()
l2.insert_values([1,3,24,25])
l1.print()
l2.print()
#print("________________")

l1.head.next.next.next = l2.head
l1.print()


#TYPE 1: Merge Two Lists
def mergeTwoLists(l1,l2):
    dummyList = LinkedList()
    while l1 and l2:
        if l1.head.data < l2.head.data:
            print("L1 data ", l1.head.data)
            dummyList.insert_at_end(l1.head.data)
            l1.head = l1.head.next 
        else:        
            print("L2 data ", l2.head.data)
            dummyList.insert_at_end(l2.head.data)
            l2.head = l2.head.next  
        
        if l1.head is None or l2.head is None:
            break

    if l1.head is None:
        print("still got some l2!")
        print(l2.head.data)
        #need to append at the end 
    else:
        print("still got some l1!")
        print(l1.head.data)
        #need to append at the end 

    return dummyList

#ALMOST WORKS
#answer = mergeTwoLists(l1,l2)
#print("________________")
#answer.print()


'''
    while l1 and l2:
        #print(l1.head.data)
        #l1.head = l1.head.next
        if l1.head.data < l2.head.data:
            dummyList.insert_at_end(l1.head.data)
            l1.head = l1.head.next 
        else:
            dummyList.insert_at_end(l2.head.data)
            l2.head = l2.head.next  

        if l1.head is None or l2.head is None:
            break

    if l1.head is None:
        print("l1")
        l1.print()
    else:
        print("l2")
        l2.print()

    return dummyList'''
'''
    dummy = ListNode("-1")
    head = dummy
    while l1 and l2:
        if l1.val < l2.val:
            dummy.next = l1
            l1 = l1.next 
        else:
            dummy.next = l2
            l2 = l2.next 

        dummy = dummy.next
    
    #Check for remaining list
    if l1 != None:
        print("still got l1")
        dummy.next = l1
    else: 
        print("l2 not null")    
        dummy.next = l2

    return head.next
'''


'''

'''
#answer = mergeTwoLists(l1,l2)
#answer.print()




#TYPE 2: With Leetcode 
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

l13 = ListNode("4")        
l12 = ListNode("2", l13)
l1 = ListNode("1", l12)

l23 = ListNode("3")        
l22 = ListNode("2", l23)
l2 = ListNode("1", l22)

def merge_lists(l1, l2):
    dummy = ListNode("-1")
    head = dummy
    while l1 and l2:
        if l1.val < l2.val:
            dummy.next = l1
            l1 = l1.next 
        else:
            dummy.next = l2
            l2 = l2.next 

        dummy = dummy.next
    
    #Check for remaining list
    if l1 != None:
        print("still got l1")
        dummy.next = l1
    else: 
        print("l2 not null")    
        dummy.next = l2

    return head.next

'''
answer = merge_lists(l1,l2)

while answer:
    print(answer.val)
    answer = answer.next
'''



#NOTES 
#Loop Over 
'''
while l1:
    print(l1.val)
    l1 = l1.next
      
while l2:
    print(l2.val)
    l2 = l2.next
'''

#Print Manually
'''
print(l1.val)
print(l1.next.val)
print(l1.next.next.val)
print(l1.next.next.next.val)
'''
'''
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        dummy = ListNode(0)  
        cur = dummy  
        while l1 and l2:  
            if l1.val <= l2.val:  
                cur.next = l1  
                l1 = l1.next  
            else:  
                cur.next = l2  
                l2 = l2.next  
            cur = cur.next  
        cur.next = l1 or l2  
  
        return dummy.next  
'''