public class BinaryTreeProgram {
    public static void main(String[] args) throws Exception {
        testCase1();
        System.out.println();
        testCase2();
        System.out.println();
        testCase3();
    }

    public static void testCase1() {
        BinaryTree root = new BinaryTree("A",
                new BinaryTree("B", new BinaryTree("D", null, null), null),
                new BinaryTree("C", new BinaryTree("E", null, new BinaryTree("F", null, null)), null));
        System.out.println(root.getNodesWithOneChild());
    }

    public static void testCase2() {
        BinaryTree root = new BinaryTree("A",
                new BinaryTree("B", new BinaryTree("D", null, null), new BinaryTree("E", null, null)),
                new BinaryTree("C", new BinaryTree("F", null, null), new BinaryTree("G", null, null)));
        root.invertChildren();
        root.printTree();
    }

    public static void testCase3() {
        BinaryTree tree6 = new BinaryTree("F", new BinaryTree(), new BinaryTree());
        BinaryTree tree5 = new BinaryTree("E", new BinaryTree(), tree6);
        BinaryTree  tree4 = new BinaryTree("C", tree5, new BinaryTree());

        BinaryTree tree3 = new BinaryTree("D", new BinaryTree(), new BinaryTree());
        BinaryTree tree2 = new BinaryTree("B", tree3, new BinaryTree());
        BinaryTree tree1 = new BinaryTree("A", tree2, tree4);

        tree1.invertChildren();
        tree1.printTree();
    }
}
