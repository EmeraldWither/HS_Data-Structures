public class HashTable {
    public static final Object INACTIVE = new Object();
    private Object[] table = new Object[10];

    public void add(Object element) {
        int hashCode = element.hashCode() % table.length;
        if (table[hashCode] == null || table[hashCode].equals(INACTIVE)) {
            table[hashCode] = element;
        } else {
            // keeping moving down until we find it
            int i = hashCode;
            while (true) {
                // if no free spot, skip over
                if (table[i] != null && !table[i].equals(INACTIVE)) {
                    i = (i + 1) % table.length;
                    continue;
                }
                // place it here
                table[i] = element;
                return;
            }
        }
    }

    public void remove(Object element) {
        int hashCode = element.hashCode() % table.length;
        for (int i = 0; i < table.length; i++) {
            int index = (hashCode + i) % table.length;
            Object currentElement = table[index];
            if (currentElement.equals(element)) {
                table[index] = INACTIVE;
                return;
            }
        }
    }

    public void printHashTable() {
        System.out.println("=============");
        for (Object object : table) {
            if(object != null && !object.equals(INACTIVE)) System.out.println(object);
            else if(object == null) System.out.println("-");
            else System.out.println("INACTIVE");
        }
        System.out.println("=============");
    }

}
