/*
 * Ishaan Sayal
 * Data Structures Period 2
 * 11/30/23
 */
public class CalculatorProgram {
    public static void main(String[] args) {
        System.out.println("Value of 3 + 4: " + new Calculator("3 + 4").eval());
        System.out.println("Value of 3 * 4 + 2: " + new Calculator("3 * 4 + 2").eval());
        System.out.println("Value of (3 + 5) * 2: " + new Calculator("(3 + 5) * 2").eval());
        System.out.println("Value of (7 * 2) / 5 + 1: " + new Calculator("(7 * 2) / 5 + 1").eval());
        System.out.println("Value of (7 * -2) / 5 + 1: " + new Calculator("(7 * -2) / 5 + 1").eval());
    }
}
