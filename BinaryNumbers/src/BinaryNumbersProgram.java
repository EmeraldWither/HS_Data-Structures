public class BinaryNumbersProgram {
    public static void main(String[] args) throws Exception {
        BinaryNumber num1 = new BinaryNumber("10110");
        BinaryNumber num2 = new BinaryNumber("11100");
        num1.add(num2);
        System.out.println(num1);
        BinaryNumber num3 = new BinaryNumber("10110");
        BinaryNumber num4 = new BinaryNumber("11101");
        num3.add(num4);
        num3.clearOverflow();
        System.out.println(num3);
    }
}
