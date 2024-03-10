class TreeNode:
    def __init__(self, val=None, left=None, right=None):
        self.val = val
        self.left = left    
        self.right = right

#rightNode = TreeNode("2", "3", None)
'''
leftNode = TreeNode("2", "3", "4")
rightNode = TreeNode("8", "9", "10")
middleNode = TreeNode("1", leftNode, rightNode)

newTree = TreeNode()
root = TreeNode("1", leftNode, rightNode)
'''




def inOrderTraversal(myTree):
    if myTree is None:
        print("empty")
    
    left = inOrderTraversal(myTree.left)
    right = inOrderTraversal(myTree.right)
    print(left)
    return left + [myTree] + right

#inOrderTraversal(root)
leftLeftNode = TreeNode("leftLeft")
leftNode = TreeNode("2", leftLeftNode)

rightNode = TreeNode("3")

newTree = TreeNode()
root = TreeNode("1", leftNode, rightNode)

def myOrderTraversal(myTree):
    elements = []

    #Visit Left Node 
    if myTree.left:
        #this returns a list and adds it to the elements
        print("Visit Left")
        elements += myOrderTraversal(myTree.left)

    #Visit Base Node 
    elements.append(myTree.val)
    print("Visit Base")

    #Visit Right Node 
    if myTree.right:
        print("Visit Right")
        elements += myOrderTraversal(myTree.right)

    return elements

answer = myOrderTraversal(root)
print(answer)

#TreeNode{val: 1, left: None, right: TreeNode{val: 2, left: TreeNode{val: 3, left: None, right: None}, right: None}}

"""
TreeNode{val: 1, left: None, right: 
TreeNode{val: 2, left: 
TreeNode{val: 3, left: None, right: None}, right: None}
}

"""

'''
def inOrderTraversal(myTree):
    if myTree.val is None:
        print("empty")
    
    left = inOrderTraversal(myTree.left)
    right = inOrderTraversal(myTree.right)
    return left + [myTree] + right

output = inOrderTraversal(myTree)

for item in output:
    print(item)

'''


#print(myTree.left.right)    



#rightNode = TreeNode("2", "3", None)
#myTree = TreeNode("1", None, rightNode)
#rightNode = TreeNode("5", "6", "7")
#leftNode = TreeNode("2", "3", "4")
#myTree = TreeNode("1", "2", "3")
#print(myTree.right.left.val)