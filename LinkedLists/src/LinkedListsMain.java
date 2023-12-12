public class LinkedListsMain {
    public static void main(String[] args) throws Exception {
        testCase1();
        System.out.println();
        testCase2();
    }
    public static void testCase1() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("E");
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        list.print();
        list.reverse();
        list.print();
    }
    public static void testCase2() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("B");
        list.addFirst("A");
        list.print();
        list.reverse();
        list.print();
    }
}
