import java.util.ArrayList;

public class Store {
    private final ArrayList<Customer> sales = new ArrayList<>();
    private Customer bestCustomer = null;
    public void addSale(String name, int amount){
        Customer customer = new Customer(name, amount);
        sales.add(customer);
        if(bestCustomer == null) bestCustomer = customer;
        //recalc best
        for (Customer ppl : sales) {
            if(ppl.getMoney() > bestCustomer.getMoney()) bestCustomer = ppl;
        }
    }
    public Customer getBestCustomer(){
        return this.bestCustomer;
    }
}
