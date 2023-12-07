public class LinkedList<E> {
    private Node<E> first = null;
    private int size = 0;

    public void addFirst(E e) {
        Node<E> node = new Node<>();
        node.data = e;
        node.next = first;
        first = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    class Node<J> {
        public J data;
        public Node<J> next;
    }

}
