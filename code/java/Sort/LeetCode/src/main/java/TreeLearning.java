import java.util.LinkedList;
import java.util.Queue;

public class TreeLearning {
    public static void main(String[] args) {

        Node myTree = new Node("A");
        myTree.left = new Node("B");
        myTree.right = new Node("E");
        myTree.left.left = new Node("C");
        myTree.left.right = new Node("D");
        myTree.right = new Node("E");
        myTree.right.left = new Node("F");
        myTree.right.right = new Node("G");

        Queue<Node> q = new LinkedList<Node>();
        Node node = myTree;
        q.add(node);

        while(!q.isEmpty()) {
            node = q.remove();
            System.out.println(node.val + " ");

            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }


        //System.out.println("The Value is " + myTree.left.left.val);

    }



    public static class Node {
        Node left;
        Node right;
        String val;

        public Node(String data) {
            this.val = data;
        }

        public Node(String data, Node left, Node right) {
            this.val = data;
            this.left = left;
            this.right = right;

        }

    }

    public class BFS {

        public void traversal(Node node) {
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);

            while(!q.isEmpty()) {
                node = q.remove();
                System.out.println(node.val + " ");

                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }

        }







    }




}
