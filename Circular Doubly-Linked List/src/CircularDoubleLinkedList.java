/**
 * Ishaan Sayal
 * Data Structures Period 2
 * 1/5/2024
**/

public class CircularDoubleLinkedList 
{
    private Node first = null;
    private Node itr = null;

    /**
     * Adds an element to the beginning of the list
     * @param data
     */
    public void addFirst(Object data) 
    {
        Node node = new Node();
        node.data = data;
        if (first == null) 
        {
            node.next = node;
            node.previous = node;
            itr = first;
        } 
        else 
        {
            node.next = first;
            node.previous = first.previous;
            first.previous = node;
        }
        first = node;
    }

    /**
     * Adds an element to the end of the list 
     * @param data
     */
    public void addLast(Object data) 
    {
        if (first == null) 
        {
            addFirst(data);
            return;
        }
        Node node = new Node();
        node.data = data;

        node.next = first;
        getLast().next = node;
        node.previous = getLast();
        first.previous = node;

    }

    /**
     * Removes the element at the beginning of the list
     * @return The element that was removed
     */
    public Object removeFirst() 
    {
        Node node = first;
        getLast().next = first.next;
        first.next.previous = getLast();
        first = first.next;
        itr = first;
        return node.data;
    }
/**
     * Removes the element at the end of the list
     * @return The element that was removed
     */
    public Object removeLast() 
    {
        Node node = getLast();
        first.previous = node.previous;
        node.previous.next = first;
        return node.data;
    }
    /**
     * Prints the current element in the next, and then goes to the next one
     */
    public void printNext() 
    {
        System.out.println(itr.data);
        itr = itr.next;
    }
/**
     * Prints the current element in the next, and then goes to the previous one
     */
    public void printPrevious() 
    {
        System.out.println(itr.data);
        itr = itr.previous;
    }

    public Node getLast() 
    {
        return first.previous;
    }

    /**
     * Returns the list x elements in
     * @param amount How far you want to go
     * @return The elements in the list
     */
    public String toString(int amount) 
    {
        StringBuilder builder = new StringBuilder();
        Node node = first;
        for (int i = 0; i < amount - 1; i++) 
        {
            builder.append(node.data + " ");
            node = node.next;
        }
        builder.append(node.data);

        return builder.toString();
    }

    class Node 
    {
        public Node next;
        public Node previous;
        public Object data;
    }
}
