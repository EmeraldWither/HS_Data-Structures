import java.util.LinkedList;
import java.util.ListIterator;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        LinkedList<String> names = new LinkedList<>();
        names.add("A");
        names.add("B");
        names.add("CEF");
        names.add("CEFF");
        names.add("DEFGH");
        names.add("DEH");
        names.add("1626e");

        ListIterator<String> listIterator = names.listIterator();
        System.out.println("Inital List:");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            if (next.length() < 4)
                listIterator.remove();
        }
        listIterator = names.listIterator();
        System.out.println("\nOnly with strings size 4 or larger:");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        ListIterator<String> iterator1 = names.listIterator();
        ListIterator<String> iterator2 = names.listIterator();
        System.out.println("\n");
        iterator1.next();
        iterator1.remove();
        System.out.println(iterator2.next());

    }
}
