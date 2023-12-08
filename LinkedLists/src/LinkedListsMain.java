public class LinkedListsMain {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list.contains("D"));
        System.out.println(list.contains("Z"));
    }
}
