# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next

#Setup 
node3 = Node(val="b", next= None)
node2 = Node(val="b", next= node3)
head = Node(val="a", next= node2)



def deleteDuplicates(head):
    cur = head
    
    while cur: 
        while cur.next and cur.val == cur.next.val:
            #print("Duplicate found")
            #print("the current value ", cur.val, " and the next value ", cur.next.val)
            cur.next = cur.next.next

        cur = cur.next 

    return head

#Answer
answer = deleteDuplicates(head)

itr = answer
print("The Answer ")
while itr:
    print(itr.val)
    itr = itr.next






#NOTES
#Set Up
'''
node4 = Node(val="b", next= None)
node3 = Node(val="b", next= node4)
node2 = Node(val="a", next= node3)
head = Node(val="a", next= node2)
'''

node3 = Node(val="1", next= None)
node2 = Node(val="1", next= node3)
head = Node(val="1", next= node2)

#Mine
'''
def deleteDuplicates(head):
    cur = head
    
    while cur: 
        while cur.next and cur.val == cur.next.val:
            print("Duplicate found")
            print("the current value ", cur.val, " and the next value ", cur.next.val)
            cur.next = cur.next.next

        cur = cur.next 

    return head
'''


'''
    cur = head
    
    while cur: 
        if cur.next:
            print("the current value ", cur.val, " and the next value ", cur.next.val)

            if cur.val == cur.next.val:
                print("Duplicate found")
                cur.next = cur.next.next

        cur = cur.next 

    return head
'''



'''

deleteDuplicates(head)
itr = answer
print("The Answer ")
while itr:
    print(itr.val)
    itr = itr.next

'''



def traverse(head):
    itr = head

    while itr:
        print(itr.val)
        itr = itr.next

    print(" ")

#From Video 
def deleteDuplicatesTutorial(head):
    cur = head
    
    while cur: 
        #delete operation 
        while cur.next and cur.next.val == cur.val:
            cur.next = cur.next.next
        cur = cur.next 

        return head

'''
newHead = deleteDuplicates(head)
itr = newHead

while itr:
    print(itr.val)
    itr = itr.next
'''


'''
node5 = Node(val="d", next=None)
node4 = Node(val="c", next=node5)
node3 = Node(val="b", next= node4)
node2 = Node(val="b", next= node3)
node1 = Node(val="a", next= node2)

itr = node1
 
while itr: 
    if itr.next != None:
        current = itr.val
        next = itr.next.val
    else: 
        current = itr.val
        next = None

    print("Current ", current, ": Next ", next)
    print()

'''


'''
while node1.next:
    print(node1.val)
    node1 = node1.next

    if node1.next == None:
        print(node1.val)
'''

  
    

#With Iterator 


'''
    if count == remove_index - 1:
        itr.next = itr.next.next
        break

    itr = itr.next
    count+=1
'''




