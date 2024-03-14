public class BinarySearchTreeProgram {
    public static void main(String[] args) throws Exception {
        BinarySeachTree tree = new BinarySeachTree();
        tree.add("Juliet");
        tree.add("Tom");
        tree.add("Diana");
        tree.add("Harry");
        tree.add("Abby");
        tree.add("Cookie Monster");

        System.out.println("Smallest (Recur): " + tree.getSmallest_rec());
        System.out.println("Smallest (Itr): " + tree.getSmallest_itr());

        System.out.println("Largest (Recur): " + tree.getLargest_rec());
        System.out.println("Largest (Itr): " + tree.getLargest_itr());

        BinarySeachTree tree2 = new BinarySeachTree();
        tree2.add(3);
        tree2.add(2);
        tree2.add(1);
        tree2.add(6);
        tree2.add(5);
        tree2.add(4);
 
        System.out.println(tree2.sum());

    }
}
