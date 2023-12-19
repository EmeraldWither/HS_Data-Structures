public class LinkedListsMain {
    public static void main(String[] args) throws Exception {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addFirst("CCC");
        circularLinkedList.addLast("BBB");
        circularLinkedList.addLast("AAA");
        LinkedListIterator iterator = circularLinkedList.toIterator();
        for(int i = 0; i < 5; i++) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

    }
}
