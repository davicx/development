import java.util.LinkedList;

public class LinkedListCode {
    Node root;
    int size;



    public LinkedListCode() {
        root = new Node();
        size = 0;
    }

    public void setSize(int s) {
        this.size = s;
    }

    public int getSize() {
        return this.size;
    }

    public Node add(int data) {
        Node newNode = new Node(data, root);
        this.root = newNode;
        this.size++;
        return newNode;
    }

    public Node find(int data) {
        Node thisNode = this.root;

        while (thisNode != null) {
            if (thisNode.getData() == data)
                return thisNode;
            thisNode = thisNode.getNextNode();
        }
        return null;
    }

    public boolean remove(int data) {
        Node thisNode = this.root;
        Node prevNode = null;

        while (thisNode != null) {
            if (thisNode.getData() == data) {
                if (prevNode != null)
                    prevNode.setNextNode(thisNode.getNextNode());
                else
                    this.root = null;
                this.setSize(this.getSize()-1);
                return true;
            }
            prevNode = thisNode;
            thisNode = thisNode.getNextNode();
        }
        return false;
    }

    // Node class
    private class Node {
        private Node nextNode;
        private int data;

        // 0-arg constructor, 1-arg constructor, 2-arg constructor
        private Node() { }

        private Node(int val) {
            data = val;
        }

        private Node(int val, Node next) {
            data = val;
            nextNode = next;
        }

        private void setData(int val) {
            this.data = val;
        }

        private int getData() {
            return this.data;
        }

        private void setNextNode(Node n) {
            this.nextNode = n;
        }

        private Node getNextNode() {
            return this.nextNode;
        }
    }
}