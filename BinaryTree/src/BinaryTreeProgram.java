public class BinaryTreeProgram {
    public static void main(String[] args) throws Exception {
        BinaryTree a = new BinaryTree("A",
                new BinaryTree("B", new BinaryTree("D", null, null), new BinaryTree("E", null, null)),
                new BinaryTree("C", new BinaryTree("F", null, null), new BinaryTree("G", null, null)));
        System.out.println(a.getHeight());
        a.printTree();
    }
}
