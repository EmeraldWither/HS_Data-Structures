import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedUtils {
    public static void downsize(LinkedList<String> employees, int n) {
        int i = 0;
        ListIterator<String> itr = employees.listIterator();
        while (itr.hasNext()) {
            itr.next();
            i++;
            if (i % n == 0)
                itr.remove();
        }
    }

    public static void reverse(LinkedList<String> list) {
        ListIterator<String> listIterator = list.listIterator();
        // starting element
        LinkedList<String> temp = new LinkedList<>();
        while (listIterator.hasNext()) {
            String e = listIterator.next();
            temp.addFirst(e);
        }
        listIterator = list.listIterator();
        ListIterator<String> tempIterator = temp.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(tempIterator.next());
        }
    }

    public static void reverseRec(LinkedList<String> list) {
        reverseRec(list, 0);
    }
    private static void reverseRec(LinkedList<String> list, int a) {
        if(a >= list.size() / 2) return;
        //swap and last - current position
        String first = list.get(a);
        int lastIndex = list.size() - a - 1;
        String last = list.get(lastIndex);
        list.set(a, last);
        list.set(lastIndex, first);
        reverseRec(list, a + 1);
    }
}
