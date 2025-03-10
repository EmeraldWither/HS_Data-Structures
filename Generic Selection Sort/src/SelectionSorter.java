/**
   This class sorts an array, using the selection sort 
   algorithm
*/
public class SelectionSorter <E extends Comparable<E>> 
{
   /**
      Constructs a selection sorter.
      @param anArray the array to sort
   */
   public SelectionSorter(E[] anArray)
   {
      a = anArray;
   }

   /**
      Sorts the array managed by this selection sorter.
   */
   public void sort()
   {  
      for (int i = 0; i < a.length - 1; i++)
      {  
         int minPos = minimumPosition(i);
         swap(minPos, i);
      }
   }

   /**
      Finds the smallest element in a tail range of the array.
      @param from the first position in a to compare
      @return the position of the smallest element in the
      range a[from] . . . a[a.length - 1]
   */
   private int minimumPosition(int from)
   {  
      int minPos = from;
      for (int i = from + 1; i < a.length; i++)
         if (a[i].compareTo(a[minPos]) < 0) minPos = i;
      return minPos;
   }

   /**
      Swaps two entries of the array.
      @param i the first position to swap
      @param j the second position to swap
   */
   private void swap(int i, int j)
   {
      E temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   private E[] a;
}