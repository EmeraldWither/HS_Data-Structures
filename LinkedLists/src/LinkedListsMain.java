public class LinkedListsMain {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list.toString());
        System.out.println(list.getR(3));
        list.setR(3, "F");
        System.out.println(list.getR(3));
    }

    public static void withoutRecursion() {
        System.out.println(" ======= ");
        System.out.println("This is WITHOUT recursion.");
        System.out.println(" ======= ");
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list.toString());
        System.out.println(list.get(3));
        list.set(3, "F");
        System.out.println(list.toString());
    }

    public static void withRecursion() {
        System.out.println("\n ======= ");
        System.out.println("This is WITH recursion.");
        System.out.println(" ======= ");
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list.toString());
        System.out.println(list.getR(3));
        list.setR(3, "F");
        System.out.println(list.getR(3));
    }
}
