public class BinaryTree {
    private Node root;

    public class Node {
        public Object data;
        public Node left;
        public Node right;
    }

    public BinaryTree(Object rootData, BinaryTree left, BinaryTree right) {
        root = new Node();
        root.data = rootData;
        root.left = left == null ? null : left.root;
        root.right = right == null ? null : right.root;
    }
    public BinaryTree(){
        
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node n) {
        if (n == null)
            return;
        printTree(n.left);
        System.out.println(n.data);
        printTree(n.right);
    }

    public int getHeight(){
        return height(root);
    }

    public void invertChildren() {
        invertChildren(root);
    }

    public int getNodesWithOneChild() {
        return getNodesWithOneChild(root);
    }
    
    private int getNodesWithOneChild(Node n) {
        if(n == null) return 0;
        int sum = 0;
        if(n.left != null || n.right != null && (n.left != null && n.right != null)) {
            sum = 1;
        }
        return sum + getNodesWithOneChild(n.left) + getNodesWithOneChild(n.right);
    }

    private void invertChildren(Node n) {
        if(n == null) return;
        Node left = n.left;
        n.left = n.right;
        n.right = left;
        invertChildren(n.left);
        invertChildren(n.right);
    }

    private int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }
}
