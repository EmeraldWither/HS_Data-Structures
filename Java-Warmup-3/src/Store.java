import java.util.ArrayList;

public class Store {
    private final ArrayList<Customer> sales = new ArrayList<>();
    private Customer bestCustomer = null;
    public void addSale(String name, double amount){
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
    public ArrayList<Customer> getTopCustomers(int num){
        ArrayList<Customer> top = new ArrayList<>();
        sales.sort((o1, o2) -> {
            return (int) (o2.getMoney() * 100 - o1.getMoney() * 100);
        });
        for (int i = 0; i < num; i++) {
            top.add(sales.get(i));
        }
        
        return top;
    }
}
