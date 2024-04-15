public class BinarySearchTreeProgram {
    public static void main(String[] args) throws Exception {
        BinarySeachTree tree1 = new BinarySeachTree();
        tree1.add(4);
        tree1.add(2);
        tree1.add(1);
        tree1.add(3);
        tree1.add(6);
        tree1.add(5);
        tree1.add(7);
        

        tree1.preOrder(new OddNumberVisitor());
        System.out.println();
        tree1.inOrder(new OddNumberVisitor());
        System.out.println();
        tree1.postOrder(new OddNumberVisitor());
    

    }
}
