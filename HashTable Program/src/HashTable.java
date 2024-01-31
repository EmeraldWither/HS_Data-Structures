/**
 * Ishaan Sayal
 * Data Structures Period 2
 * 1/31/2024
 */

public class HashTable
{
    public static final Object INACTIVE = new Object();
    private final Object[] table = new Object[10];

    /**
     * @param element Adds an element into the Hashtable
     */
    public void add(Object element)
    {
        // keeping moving down the list until we find an empty spot to place our element
        int i = element.hashCode() % table.length; //calculated hashcode
        while (true) {
            // if no free spot, skip over
            if (table[i] != null && !table[i].equals(INACTIVE)) {
                i = (i + 1) % table.length;
                continue;
            }
            table[i] = element;
            return;
        }
    }

    /**
     * @param element Removes the element from the Hashtable
     */
    public void remove(Object element)
    {
        int hashCode = element.hashCode() % table.length;
        for (int i = 0; i < table.length; i++)
        {
            //keep traversing through the array, wrapping around if necessary
            int index = (hashCode + i) % table.length;

            //if we find the element, remove it
            Object currentElement = table[index];
            if (currentElement.equals(element))
            {
                //set the element to be our inactive object
                table[index] = INACTIVE;
                return;
            }
        }
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
