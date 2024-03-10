class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left    
        self.right = right

leftRightNode = TreeNode("4", None, None)
rightRightNode = TreeNode("5", None, None)
leftNode = TreeNode("2", None, leftRightNode)
rightNode = TreeNode("3", None, rightRightNode)
root = TreeNode("1", leftNode, rightNode)

 
def searchBST(myTree, val):
    if myTree is None:
        return None 
        
    if myTree.val == val:
        print("Found", myTree.val, val)
        return val
    
    if val < myTree.val:
        print("Left", myTree.val, val)
        return searchBST(myTree.left, val)
    else: 
        print("Right", myTree.val, val)
        return searchBST(myTree.right, val)

answer = searchBST(root, "2")
print(answer)



 
