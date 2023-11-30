/*
 * Ishaan Sayal
 * Data Structures Period 2
 * 11/30/23
 */

import java.util.Scanner;

public class CalculatorProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Enter in an expression (\"exit\" to exit): ");
            String input = in.nextLine();
            if(input.equals("exit")) break;
            System.out.println("The value is: " + new Calculator(input).eval());
        }
    }
}
