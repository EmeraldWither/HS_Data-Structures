public class BankAccount {
    private final int accountID;
    private final String name;

    public BankAccount(String name, int accountID) {
        this.accountID = accountID;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((BankAccount) obj).name.equals(this.name);
    }

    @Override
    public String toString() {
        return "{AccountID: " + accountID + ", Name: " + name + "}";
    }
}
