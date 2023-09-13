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
        int runTimes = num;
        if(runTimes > sales.size()) runTimes = num - (num - sales.size());
        for(int i = 0; i < runTimes; i++){
            Customer bestCustomer = new Customer("", -1);
            for (Customer customer : sales) {
                if(customer.getMoney() > bestCustomer.getMoney() && !top.contains(customer)) bestCustomer = customer;
            }
            top.add(bestCustomer);
        }
        return top;
    }
}
