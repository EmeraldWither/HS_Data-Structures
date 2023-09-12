import java.util.Scanner;

public class SupermarketBestCustomer {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Scanner in = new Scanner(System.in);
        int price = 0;
        do{
            System.out.print("Enter your price: ");
            price = in.nextInt();
            in.nextLine();
            System.out.print("What is their name: ");
            store.addSale(in.nextLine(), price);
            System.out.println("\nThe best customer is " + store.getBestCustomer().getName() + "\n");
        }
        while (price != 0);
    }
}
