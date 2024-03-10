class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left    
        self.right = right
 
leftLeftNode = TreeNode("1")
leftNode = TreeNode("2", leftLeftNode)
rightNode = TreeNode("3")

root = TreeNode("4", leftNode, rightNode)

def changeBST(myTree, val, myList):
    if myTree is None:
        return myList 
    
    if myTree.val == val:
        print("HIYA")
        return myList
    
    if val < myTree.val:
        print("left")
        myList.append("left")
        return changeBST(myTree.left, val, myList)
    else: 
        print("right")
        myList.append("right")
        return changeBST(myTree.right, val, myList)

'''
print(root.val)
print(root.left.val)
print(root.right.val)
'''

answer = changeBST(root, "1", []) 
print(answer)
'''
print(root.val)
print(root.left.val)
print(root.right.val)
'''


'''
def changeValue(myTree, val):
    if myTree is None:
        return None 

    if val < myTree.val:
        if myTree.left:
            return changeValue(myTree.left, val)  
        else:
            return False

    if val > myTree.data:
        if myTree.right:
            return changeValue(myTree.right, val)  
        else:
            return False
''' 






"""
answer = searchBST(root, "2")
print(answer.val)
print(answer.left.val)
"""

"""
def maxDepth(myTree):
    if myTree is None:
        return 0

    left = maxDepth(myTree.left)
    right = maxDepth(myTree.right)
        
    return max(left, right) + 1

answer = maxDepth(root)

print(answer)
"""
