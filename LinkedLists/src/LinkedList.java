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

    public boolean contains(E element) {
        if (first == null)
            return false;
        Node<E> node = first;
        while (node.next != null) {
            if (node.data.equals(element))
                return true;
            node = node.next;
        }
        if (node.data.equals(element))
            return true;
        return false;
    }

    public E get(int n) {
        verifyIndex(n);
        return getNode(n).data;
    }

    private Node<E> getNode(int n) {
        Node<E> next = first;
        for (int i = 1; i < n; i++)
            next = next.next;
        return next;
    }

    private Node<E> getNode(Node<E> start, int distance) {
        if (distance == 1)
            return start;
        return getNode(start.next, distance - 1);
    }

    public void set(int n, E element) {
        verifyIndex(n);
        getNode(n).data = element;
    }

    public E getR(int n) {
        verifyIndex(n);
        return getNode(first, n).data;
    }

    public void setR(int n, E element) {
        verifyIndex(n);
        getNode(first, n).data = element;
    }

    private void verifyIndex(int n) {
        if (n < 1 || n > getSize())
            throw new ArrayIndexOutOfBoundsException(n);
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
