import java.util.LinkedList;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        LinkedList<String> staff = new LinkedList<String>();
        staff.addFirst("Harry");
        staff.addLast("Diana");
        staff.addFirst("Tom");
        System.out.println(staff.removeLast());
        System.out.println(staff.removeFirst());
        System.out.println(staff.removeLast());

    }
}
