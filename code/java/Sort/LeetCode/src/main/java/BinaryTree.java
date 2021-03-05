public class BinaryTree {

    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        //theTree.inOrderTraverseTree(theTree.root);
        //theTree.postOrderTraverseTree(theTree.root);
        System.out.println(theTree.findNode(15));


    }

    //Add Node
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {

            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;

                    }

                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node

            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node

            System.out.println(focusNode);

            // Traverse the right node

            inOrderTraverseTree(focusNode.rightChild);

        }
    }

    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);

        }



    }


    public Node findNode(int key) {

        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the Node
        // keep looking
        while (focusNode.key != key) {

            // If we should search to the left
            if (key < focusNode.key) {

                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;

            } else {

                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;

            }

            // The node wasn't found
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }



    class Node {

        int key;
        String name;

        Node leftChild;
        Node rightChild;

        Node(int key, String name) {

            this.key = key;
            this.name = name;

        }

        public String toString() {
            return name + " has the key " + key;
        }
    }
}
