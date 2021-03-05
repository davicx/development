public class Tree {
    Tree left, right;
    int data;

    /* Constructor */
    public Tree()
    {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */
    public Tree(int n)
    {
        left = null;
        right = null;
        data = n;
    }
    /* Function to set left node */
    public void setLeft(Tree n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(Tree n)
    {
        right = n;
    }
    /* Function to get left node */
    public Tree getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public Tree getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }

}