import java.util.NoSuchElementException;

public class CircularLinkedList {
    private Node last = null;
    private int currentSize = 0;

    public void addFirst(Object data) {
        Node node = new Node();
        node.data = data;
        if (last == null) {
            node.next = node;
            last = node; 
        }
        else {
            node.next = last.next;
            last.next = node;
        }
        currentSize++;
    }

    public void addLast(Object data) {
        Node node = new Node();
        if (last == null) {
            addFirst(data);
            return;
        }
        node.data = data;
        node.next = last.next;
        last.next = node;
        last = node;
        currentSize++;
    }

    public String toString(int amount) {
        StringBuilder builder = new StringBuilder();
        Node node = last.next;
        for (int i = 0; i < amount - 1; i++) {
            builder.append(node.data + " ");
            node = node.next;
        }
        builder.append(node.data);

        return builder.toString();
    }
    public int getSize() {
        return currentSize;
    }

    public CircularLinkedListIterator toIterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements LinkedListIterator
   {
      private Node position;
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public CircularLinkedListIterator()
      {
         position = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         if (position == null)
            position = last.next;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return last.next != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = last.next;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
            currentSize++;
         }
      }

    //   /**
    //      Removes the last traversed element. This method may
    //      only be called after a call to the next() method.
    //   */
    //   public void remove()
    //   {
    //      if (previous == position)
    //         throw new IllegalStateException();

    //      if (position == first)
    //      {
    //         removeFirst();
    //      }
    //      else
    //      {
    //         previous.next = position.next;
    //         currentSize--;
    //      }
    //      position = previous;
    //   }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
   }

    class Node {
        public Node next;
        public Object data;
    }
}
