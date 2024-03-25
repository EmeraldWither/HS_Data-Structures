public class BinarySearchTreeProgram {
    public static void main(String[] args) throws Exception {
        BinarySeachTree tree1 = new BinarySeachTree();
        tree1.add("D");
        tree1.add("C");
        tree1.add("B");
        tree1.add("A");
       
        BinarySeachTree tree2 = new BinarySeachTree();
        tree2.add("D");
        tree2.add("C");
        tree2.add("B");
        tree2.add("A");

        System.out.println(BinarySeachTree.isSame(tree1, tree2));
    }
}
