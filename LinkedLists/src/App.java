public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list.toString());
        System.out.println(list.getR(4));
        list.setR(3, "F");
        System.out.println(list.toString());
    }
}
