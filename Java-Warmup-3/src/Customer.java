public class Customer {
    private final String name;

    private final int money;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
