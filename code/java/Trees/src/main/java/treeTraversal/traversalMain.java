package treeTraversal;

public class traversalMain {

    public static void main(String[] args) {
        Node data = createData();
        //preorderTraversal(data);
        //postorderTraversal(data);
        inorderTraversal(data);


    }

    public static void inorderTraversal(Node n) {
        if(n == null)
            return;
        inorderTraversal(n.left);
        System.out.println(n.value+" ");
        inorderTraversal(n.right);
    }

    public static void preorderTraversal(Node n) {
        if(n == null)
            return;
        System.out.println(n.value + " ");
        preorderTraversal(n.left);
        preorderTraversal(n.right);
    }

    public static void postorderTraversal(Node n) {
        if(n == null)
            return;
        postorderTraversal(n.left);
        postorderTraversal(n.right);
        System.out.println(n.value+" ");
    }

    public static Node createData() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        a.left = b;
        a.right = g;
        b.left = c;
        b.right = d;
        c.left = e;
        e.right = f;

        return a;
    }
}

