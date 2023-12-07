public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        System.out.println(list.toString());
        System.out.println(list.get(3));
        list.set(3, "F");
        System.out.println(list.toString());
    }
}
