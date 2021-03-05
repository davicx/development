# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


#myList = ListNode(0)
nodeOne = ListNode(1)
nodeTwo = ListNode(2)
nodeThree = ListNode(3)

nodeOne.val = 1
nodeTwo.val = 2
nodeThree.val = 3

#myList.next = nodeOne
nodeOne.next = nodeTwo
nodeThree.next = nodeThree

print(nodeOne.val)
print(nodeOne.next.val)
print(nodeThree.val)
print(nodeThree.val)

#myList.val = 2
#print(myList.val)
#print(myList.next)