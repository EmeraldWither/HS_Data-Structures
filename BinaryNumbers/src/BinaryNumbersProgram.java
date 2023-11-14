public class BinaryNumbersProgram {
    public static void main(String[] args) throws Exception {
        System.out.println("\n===========================================");
        System.out.println("  All binary numbers are in Little Endian");
        System.out.println("===========================================\n");
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

    // 10010011
    // decimal value: 201
    // shifted right by 3: 0001000
    // R1 added to B2: 10001011
    // 0101
    // Numbers not compatiable
    // Overflow
}
