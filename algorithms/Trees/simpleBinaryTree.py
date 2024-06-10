class Node:
	def __init__(self,key):
		self.left = None
		self.right = None
		self.val = key

root = Node(1)
print(" ", root.val)
root.left	 = Node(2)
root.right	 = Node(3)
print(root.left.val, " ", root.right.val  )

#root.left.left = Node(4);

