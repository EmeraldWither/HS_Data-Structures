public class GeneralTreeProgram {
    public static void main(String[] args) {
        Tree tree = new Tree("A");
        Tree b = new Tree("B");
        b.addSubtree(new Tree("E"));
        b.addSubtree(new Tree("F"));
        b.addSubtree(new Tree("G"));
        tree.addSubtree(b);

        Tree c = new Tree("C");
        tree.addSubtree(c);

        Tree d = new Tree("D");
        d.addSubtree(new Tree("H"));
        d.addSubtree(new Tree("I"));

        tree.addSubtree(d);

        tree.depthFirstSearch(data -> {
            if(data.equals("F")) {
                System.out.println("Found Node " + data + "!");
                return false;
            }
            return true;
        });
        tree.depthFirstSearch(data -> {
            if(data.equals("Z")) {
                System.out.println("Found Node " + data + "!");
                return false;
            }
            return true;
        });
    }
   
}
