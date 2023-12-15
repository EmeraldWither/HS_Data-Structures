public class LinkedListsMain {
    public static void main(String[] args) throws Exception {
        testCase1();
        testCase2();
    }
    public static void testCase1() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("E");
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list.getSizeR());
    }
    public static void testCase2() {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(list.getSizeR());

    }
}
