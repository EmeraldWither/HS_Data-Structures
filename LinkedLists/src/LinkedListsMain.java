public class LinkedListsMain {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("E");
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list);
        list.reverse();
    }
}
