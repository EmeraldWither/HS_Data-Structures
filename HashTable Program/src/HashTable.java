/**
 * Ishaan Sayal
 * Data Structures Period 2
 * 1/31/2024
 */

@SuppressWarnings("UnusedReturnValue")
public class HashTable
{
    public static final Object INACTIVE = new Object();
    private final Object[] table = new Object[10];

    /**
     * @param element Adds an element into the Hashtable
     * @return true if the element was added, false if the element could not be added (the array is full)
     */
    public boolean add (Object element)
    { 
        int hashCode = element.hashCode() % table.length; // calculated hashcode
        for (int i = 0; i < table.length; i++) //only move through the array once (no infinite loops!)
        {
            // if no free spot, skip over 
            if (table[hashCode] != null && !table[hashCode].equals(INACTIVE))
            {
                hashCode = (hashCode + 1) % table.length; 
                continue; 
            } 
            table[hashCode] = element;
            return true; 
        }
        return false;
    }

    /**
     * @param element Removes the element from the Hashtable
     * @return true if the element was removed, false if the element was not found
     */
    public boolean remove(Object element)
    {
        int hashCode = element.hashCode() % table.length;
        for (int i = 0; i < table.length; i++)
        {
            //keep traversing through the array, wrapping around if necessary
            int index = (hashCode + i) % table.length;
            //if we find the element, remove it
            Object currentElement = table[index];
            if (currentElement != null && currentElement.equals(element))
            {
                //set the element to be our inactive object
                table[index] = INACTIVE;
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the hash table in vertical order.
     */
    public void printHashTable()
    {
        System.out.println("=============");
        for (Object object : table)
        {
            if(object != null && !object.equals(INACTIVE)) System.out.println(object);
            else if(object == null) System.out.println("-");
            else System.out.println("INACTIVE");
        }
        System.out.println("=============");
    }
}