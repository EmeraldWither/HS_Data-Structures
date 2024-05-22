public class BankAccount implements Comparable<BankAccount> {
    private final int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "BankAccount with Balance " + this.balance;
    }
    @Override
    public int hashCode() {
        return this.balance;
    }
    @Override
    public int compareTo(BankAccount o) {
        return this.balance - o.balance;
    }
}
