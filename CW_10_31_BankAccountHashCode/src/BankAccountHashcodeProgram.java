import java.util.HashSet;

public class BankAccountHashcodeProgram {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Jason Voorhees", 10001);
        BankAccount b2 = new BankAccount("Freddy", 10002);
        BankAccount b3 = new BankAccount("Pennywise", 10002);
        BankAccount b4 = new BankAccount("Freddy", 10);
        BankAccount b5 = new BankAccount("Micheal Meyers", 10004);
        HashSet<BankAccount> set = new HashSet<>();
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);
        System.out.println(set);
    }
}
