/*
 * Ishaan Sayal
 * Period 1
 * 4/18/2024
 */

//package solution;

import java.util.*;

/**
   This class implements a heap.
*/
public class MinHeap
{
   private ArrayList<Comparable> elements;

   public ArrayList<Comparable> getRawElements() 
   {
      return new ArrayList<>(elements);
   }

   /**
      Constructs an empty heap.
   */
   public MinHeap()
   {
      elements = new ArrayList<Comparable>();
   }

   /**
      Adds a new element to this heap.
      @param newElement the element to add
   */
   public void add(Comparable newElement)
   {
      // Add a new leaf
      elements.add(null);
      int index = elements.size() - 1;

      // Demote parents that are larger than the new element
      while (index > 0
            && getParent(index).compareTo(newElement) > 0)
      {
         elements.set(index, getParent(index));
         index = getParentIndex(index);
      }

      // Store the new element into the vacant slot
      elements.set(index, newElement);
   }

   /**
      Gets the minimum element stored in this heap.
      @return the minimum element
   */
   public Comparable peek()
   {
      return elements.get(0);
   }

   /**
      Removes the minimum element from this heap.
      @return the minimum element
   */
   public Comparable remove()
   {
      Comparable minimum = elements.get(0);

      // Remove last element
      int lastIndex = elements.size() - 1;
      Comparable last = elements.remove(lastIndex);

      if (lastIndex > 0)
      {
         elements.set(0, last);
         fixHeap();
      }

      return minimum;
   }

   /**
      Turns the tree back into a heap, provided only the root
      node violates the heap condition.
   */
   private void fixHeap()
   {
      Comparable root = elements.get(0);

      int lastIndex = elements.size() - 1;
      // Promote children of removed root while they are larger than last

      int index = 0;
      boolean more = true;
      while (more)
      {
         int childIndex = getLeftChildIndex(index);
         if (childIndex <= lastIndex)
         {
            // Get smaller child

            // Get left child first
            Comparable child = getLeftChild(index);

            // Use right child instead if it is smaller
            if (getRightChildIndex(index) <= lastIndex
                  && getRightChild(index).compareTo(child) < 0)
            {
               childIndex = getRightChildIndex(index);
               child = getRightChild(index);
            }

            // Check if larger child is smaller than root
            if (child.compareTo(root) < 0)
            {
               // Promote child
               elements.set(index, child);
               index = childIndex;
            }
            else
            {
               // Root is smaller than both children
               more = false;
            }
         }
         else
         {
            // No children
            more = false;
         }
      }

      // Store root element in vacant slot
      elements.set(index, root);
   }

   /**
      Returns the number of elements in this heap.
   */
   public int size()
   {
      return elements.size();
   }

   /**
      Returns the index of the left child.
      @param index the index of a node in this heap
      @return the index of the left child of the given node
   */
   private static int getLeftChildIndex(int index)
   {
      index = index + 1;
      return 2 * index - 1;
   }

   /**
      Returns the index of the right child.
      @param index the index of a node in this heap
      @return the index of the right child of the given node
   */
   private static int getRightChildIndex(int index)
   {
      index = index + 1;
      return 2 * index;
   }

   /**
      Returns the index of the parent.
      @param index the index of a node in this heap
      @return the index of the parent of the given node
   */
   private static int getParentIndex(int index)
   {
      index = index + 1;
      return index / 2 - 1;
   }

   /**
      Returns the value of the left child.
      @param index the index of a node in this heap
      @return the value of the left child of the given node
   */
   private Comparable getLeftChild(int index)
   {
      return elements.get(2 * index + 1);
   }

   /**
      Returns the value of the right child.
      @param index the index of a node in this heap
      @return the value of the right child of the given node
   */
   private Comparable getRightChild(int index)
   {
      return elements.get(2 * index + 2);
   }

   /**
      Returns the value of the parent.
      @param index the index of a node in this heap
      @return the value of the parent of the given node
   */
   private Comparable getParent(int index)
   {
      return elements.get((index + 1) / 2 - 1);
   }
}