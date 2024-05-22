public class App {
    public static void main(String[] args) throws Exception {
        BankAccount[] a = {
            new BankAccount(2),
            new BankAccount(1),
            new BankAccount(3),
            new BankAccount(5),
            new BankAccount(6),
            new BankAccount(4),
            new BankAccount(7),

        };
        SelectionSorter<BankAccount> sorter = new SelectionSorter<>(a);
        sorter.sort();
        for (BankAccount a2 : a) {
            System.out.println(a2);
        }
    }
}
