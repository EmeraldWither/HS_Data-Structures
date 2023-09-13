import java.util.Scanner;

public class SupermarketBestCustomer {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Scanner in = new Scanner(System.in);
        double price = 0;
        do{
            System.out.print("Enter your price: ");
            price = in.nextDouble();
            if(price == 0) break;
            in.nextLine();
            System.out.print("What is their name: ");
            store.addSale(in.nextLine(), price);
            System.out.println("\nThe best customer is " + store.getBestCustomer().getName() + "\n");
        }
        while (price != 0);
        System.out.println(store.getTopCustomers(3));
    }
}
