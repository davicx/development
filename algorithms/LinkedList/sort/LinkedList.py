from operator import le
from re import M


class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next

class LinkedList:
    def __init__(self):
        self.head = None

    #Insert Methods 
    def insert_at_begining(self, data):
        node = Node(data, self.head)
        self.head = node

    def insert_at_end(self, data):
        if self.head is None:
            print("empty")
            self.head = Node(data, None)
            return

        itr = self.head

        while itr.next:
            #print(itr.data)
            itr = itr.next
        #print(itr.data)
        itr.next = Node(data, None)
        
    def insert_values(self, data_list):
        self.head = None
        for data in data_list:
            self.insert_at_end(data)

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

    #Remove Values 
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

    def remove_last_value(self):
        if self.head is None:
            print("empty")
            return 

        if self.head.next is None:
            self.head = None
            return None
   
        second_last_itr = self.head

        while second_last_itr.next.next:
            #print(itr.data)
            second_last_itr = second_last_itr.next
        second_last_itr.next = None
        return self.head
        #print(second_last_itr.data)
        
    #Useful Methods
    def get_length(self):
        count = 0
        itr = self.head
        while itr:
            count+=1
            itr = itr.next

        return count

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

#Create List 
myLinkedList = LinkedList()
myLinkedList.insert_at_begining(3)
myLinkedList.insert_at_begining(2)
myLinkedList.insert_at_begining(1)
myLinkedList.insert_at_end(4)

#Example 1: Remove Last Value 
myLinkedList.print()
myLinkedList.remove_last_value()
myLinkedList.print()

#Example 2: Find Value 
myLinkedList.find_value_index(2)

#myLinkedList.insert_after_value(2, "hi")
#myLinkedList.print()

#length = myLinkedList.get_length()
#print("the length is ", length)





