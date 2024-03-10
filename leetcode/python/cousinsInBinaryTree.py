class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left    
        self.right = right

#leftLeftNode = TreeNode("4")
leftRightNode = TreeNode("4")
rightRightNode = TreeNode("5")

rightNode = TreeNode("2", None, rightRightNode)
leftNode = TreeNode("2", None, leftRightNode)

root = TreeNode("1", leftNode, rightNode)

print(root.left.right.val)

def isCousins(myTree):
    if myTree is None:
        return False

def findPath(myTree, val, myList=[]):
    if myTree is None:
        return myList 
    
    if myTree.val == val:
        #myList.append("root")
        print("Found the value ", myTree.val)
        return myList
    
    if val < myTree.val:
        print("left", myTree.val)
        myList.append("left")
        return findPath(myTree.left, val, myList)
    else: 
        print("right", myTree.val)
        myList.append("right")
        return findPath(myTree.right, val, myList)

path = findPath(root, "4")
#print(path)
