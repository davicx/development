#class Solution:
#    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def isSameTree(p, q):
    if p == None and q == None:
        return False
    elif p == None or q == None:
        return False
    elif p.val != q.val:
        return False
    else:
        return isSameTree(p.left, q.left) and isSameTree(p.right, q.right)

"""
p = TreeNode(1)
p.left = 2
p.right = 3

q = TreeNode(1)
q.left = 2
q.right = 3
"""
p = TreeNode()
q = TreeNode()

print(isSameTree(p, q))