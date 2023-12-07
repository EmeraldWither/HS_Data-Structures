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

    public E get(int n) {
        return getNode(n).data;
    }

    private Node<E> getNode(int n) {
        Node<E> next = first;
        for (int i = 1; i < n; i++)
            next = next.next;
        return next;
    }

    public void set(int n, E element) {
        getNode(n).data = element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;

        while (node.next != null) {
            builder.append(node.data + " ");
            node = node.next;
        }
        builder.append(node.data);

        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    class Node<J> {
        public J data;
        public Node<J> next;
    }

}
