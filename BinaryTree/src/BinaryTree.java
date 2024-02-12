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

    private int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }
}
