class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left    
        self.right = right

rightLeftNode = TreeNode("15")
rightRightNode = TreeNode("6")
leftNode = TreeNode("9")
#rightNode = TreeNode("20", rightLeftNode, rightRightNode)
rightNode = TreeNode("20")

root = TreeNode("3", leftNode, rightNode)

def maxDepth(myTree):
    if myTree is None:
        return 0

    left = maxDepth(myTree.left)
    right = maxDepth(myTree.right)
        
    return max(left, right) + 1

answer = maxDepth(root)

print(answer)