import java.util.Scanner;

public class SupermarketBestCustomer {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Scanner in = new Scanner(System.in);
        double price = 0;
        do{

            System.out.print("Enter name: ");
            String name = in.nextLine();
            if(name.equalsIgnoreCase("end")) break;
            System.out.print("Enter your price: ");
            price = in.nextDouble();
            in.nextLine();
            if(price == 0) break;
            store.addSale(name, price);
            System.out.println("=======================");
            System.out.println("The purchase was successful.");
            System.out.println("\nTHANK YOU OUR LOYAL CUSTOMER: " + store.getBestCustomer().getName());
            System.out.println("=======================\n");
        }
        while (true);
        System.out.println("THANK YOU TO OUR 3 LOYAL CUSTOMERS: " + store.getTopCustomers(3));
        System.out.println("THANK YOU TO OUR 7 LOYAL CUSTOMERS: " + store.getTopCustomers(7));
    }
}
