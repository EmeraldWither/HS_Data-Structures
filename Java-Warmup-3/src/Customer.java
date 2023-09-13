public class Customer {
    private final String name;

    private final double money;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "{Name: " + name + ", Money: " + money + "}";
    }
}
