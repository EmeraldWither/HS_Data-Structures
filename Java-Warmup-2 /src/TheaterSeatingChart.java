import java.util.Arrays;
import java.util.Scanner;

public class TheaterSeatingChart {
    public static final int[][] seatingChart = {
            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
            { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
            { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
            { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
            { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 },
    };
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        requestInputMethod();
    }

    public static void requestInputMethod() {
        System.out.print("Would you like Seat Selection (s), Price Selection (p), or View Seating Chart (c): ");
        switch (in.next()) {
            case "s":
                requestSeatSelection();
                break;
            case "p":
                requestPriceSelection();
                break;
            case "c":
                printSeatingChart();
                break;
            default:
                System.out.println("Invalid selection.");
                requestInputMethod();
                break;
        }
    }

    public static void printSeatingChart() {
        for (int row = 0; row < seatingChart.length; row++) {
            for (int col = 0; col < seatingChart[0].length; col++) {
                System.out.print(seatingChart[row][col] + " ");
            }
            System.out.println();
        }
        requestInputMethod();
    }

    public static void requestPriceSelection() {
        System.out.print("Pick a price: ");
        bookPrice(in.nextInt());
    }

    public static void bookPrice(int price) {
        for (int row = 0; row < seatingChart.length; row++) {
            for (int col = 0; col < seatingChart[0].length; col++) {
                int seat = seatingChart[row][col];
                if (seat == price && seat != 0) {
                    seatingChart[row][col] = 0;
                    System.out.println("Booked seat at row " + row + ", column " + col + " for " + price);
                    requestInputMethod();
                    return;
                }

            }
        }
        System.out.println("We are currently out of " + price + "$ seats. Please try again.");
        requestPriceSelection();
    }

    public static void requestSeatSelection() {
        int row, column = 0;
        System.out.println("Pick a row and column, seperate by a comma (ex, \"5,4\"): ");
        in.nextLine();
        String input = in.nextLine();
        // parse the string
        try{
            row = Integer.parseInt(input.split(",")[0]);
            column = Integer.parseInt(input.split(",")[1]);
            bookSeat(row, column);
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input.");
            requestSeatSelection();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid input.");
            requestSeatSelection();
        }
    }

    public static void bookSeat(int row, int column) {
        if(row > 8 || column > 9) {
            System.out.println("Invalid.");
            requestInputMethod();
        }
        if (seatingChart[row][column] != 0) {
            seatingChart[row][column] = 0;
            System.out.println("You have booked the seat at row " + row + ", column " + column);
        } else {
            System.out.println("Sorry. That seat is sold out. Try again");
        }
        requestInputMethod();

    }
}
