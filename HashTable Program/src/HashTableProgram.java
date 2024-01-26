public class HashTableProgram {
    public static void main(String[] args) throws Exception {
        HashTable table = new HashTable();
        System.out.println("Step 1: ");
        table.add("H");
        table.add("I");
        table.add("Ugh");
        table.printHashTable();


        System.out.println("\nStep 2: ");
        table.add("A");
        table.add("B");
        table.add("C");
        table.add("D");
        table.add("E");
        table.add("F");
        table.printHashTable();

        System.out.println("\nStep 3: ");
        table.add("VII");
        table.printHashTable();

        System.out.println("\nStep 4: ");
        table.remove("H");
        table.printHashTable();

        System.out.println("\nStep 5: ");
        table.remove("VII");
        table.printHashTable();
    }
}
