/**
 * Ishaan Sayal
 * Data Structures Period 2
 * 1/5/2024
**/

public class DoublyCircularilyLinkedList {
    public static void main(String[] args) throws Exception {
        CircularDoubleLinkedList linkedList = new CircularDoubleLinkedList();
        linkedList.addFirst("C");
        linkedList.addFirst("B");
        linkedList.addFirst("A");
        linkedList.addFirst("0");
        linkedList.addLast("D");
        linkedList.addLast("E");
        linkedList.addLast("F");

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());

        System.out.println(linkedList.removeFirst());
        linkedList.printNext();
        linkedList.printNext();
        linkedList.printNext();
        linkedList.printPrevious();
        linkedList.printPrevious();
        linkedList.printPrevious();
        linkedList.printPrevious();
    }
}
