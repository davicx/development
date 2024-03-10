class BinarySearchTreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def add_child(self, data):
        if data == self.data:
            return # node already exist

        if data < self.data:
            if self.left:
                self.left.add_child(data)
            else:
                self.left = BinarySearchTreeNode(data)
        else:
            if self.right:
                self.right.add_child(data)
            else:
                self.right = BinarySearchTreeNode(data)

    def search(self, val):
        if self.data == val:
            return True

        if val < self.data:
            if self.left:
                return self.left.search(val)
            else:
                return False

        if val > self.data:
            if self.right:
                return self.right.search(val)
            else:
                return False

    def in_order_traversal(self):
        elements = []
        print("elements")
        print(elements)
        print("____________")

        #Visit Left Node 
        if self.left:
            #this returns a list and adds it to the elements
            print("Visit Left")
            elements += self.left.in_order_traversal()

        #Visit Base Node 
        elements.append(self.data)
        print("Visit Base")

        #Visit Right Node 
        if self.right:
            print("Visit Left")
            elements += self.right.in_order_traversal()

        return elements

myTree = BinarySearchTreeNode(1)
leftTree = BinarySearchTreeNode(2)
leftLeftTree = BinarySearchTreeNode("left,left")
rightTree = BinarySearchTreeNode(3)
leftTree.left = leftLeftTree
myTree.left = leftTree
myTree.right = rightTree

#print(myTree.data)
#print(myTree.left.data)
#print(myTree.right.data)
#items = myTree.in_order_traversal()
#print(items)


def in_order_traversal(myTree):
    elements = []

    #Visit Left Node 
    if myTree.left:
        #this returns a list and adds it to the elements
        print("Visit Left")
        elements += myTree.left.in_order_traversal()

    #Visit Base Node 
    elements.append(myTree.data)
    print("Visit Base")

    #Visit Right Node 
    if myTree.right:
        print("Visit Left")
        elements += myTree.right.in_order_traversal()

    return elements

def playground(myTree):
    elements = []

    #Visit Left Node 
    if myTree.left:
        print(myTree.data)
        elements += myTree.left.in_order_traversal()

    #Visit Base Node 
    elements.append(myTree.data)

    #Visit Right Node 
    if myTree.right:
        elements += myTree.right.in_order_traversal()

    return elements


my_elements = playground(myTree)
print(my_elements)





#elements = in_order_traversal(myTree)



#print(elements)
"""
def build_tree(elements):
    print("Building tree with these elements:",elements)
    root = BinarySearchTreeNode(elements[0])

    for i in range(1,len(elements)):
        root.add_child(elements[i])

    return root

if __name__ == '__main__':
    countries = ["India","Pakistan","Germany", "USA","China","India","UK","USA"]
    country_tree = build_tree(countries)

    print("UK is in the list? ", country_tree.search("UK"))
    print("Sweden is in the list? ", country_tree.search("Sweden"))

    numbers_tree = build_tree([17, 4, 1, 20, 9, 23, 18, 34])
    print("In order traversal gives this sorted list:",numbers_tree.in_order_traversal())

"""
