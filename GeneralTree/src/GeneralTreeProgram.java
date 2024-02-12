public class GeneralTreeProgram {
    public static void main(String[] args) throws Exception {
        testCase1();
        testCase2();
    }
    public static void testCase1() {
        Tree root = new Tree("A");
        Tree b = new Tree("B");
        root.addSubtree(b);

        Tree c = new Tree("C");
        Tree e = new Tree("E");
        c.addSubtree(e);
        root.addSubtree(c);

        Tree d = new Tree("d");
        root.addSubtree(d);
        System.out.println(root.getMaxSiblings());
    }
    public static void testCase2() {
        Tree root = new Tree("A");
        root.addSubtree(new Tree("B"));
        root.addSubtree(new Tree("C"));
        Tree d = new Tree("D");
        d.addSubtree(new Tree("E"));
        d.addSubtree(new Tree("F"));
        d.addSubtree(new Tree("G"));
        d.addSubtree(new Tree("H"));
        root.addSubtree(d);
        System.out.println(root.getMaxSiblings());
    }
   
}
