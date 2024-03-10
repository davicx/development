from turtle import left

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left    
        self.right = right

#rightNode = TreeNode("2", "3", None)
leftNode = TreeNode("2", "3", "4")
rightNode = TreeNode("8", "9", "10")
myTree = TreeNode("1", leftNode, rightNode)

print(myTree.left.right)




"""
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None    
        self.right = None

class BinarySearchTree:
    def __init__(self, value):
        self.root = None
class Solution:
    def inorderTraversal(self, root: TreeNode):
        if root is None:
            return []
        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)

        
def preorder(self, current):
    self.visit(current)
    self.preorder(current.left)
    self.preorder(current.right)

def inorder(self, current):
    self.inorder(current.left)
    self.visit(current)
    self.inorder
    
    (current.right)

"""
 