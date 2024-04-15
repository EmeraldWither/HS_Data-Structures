public class OddNumberVisitor implements Visitor {

    @Override
    public void visit(Comparable data) {
        if(data instanceof Integer) {
            if((int) data % 2 == 1) System.out.println(data);
        }
    }

}
