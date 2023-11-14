/*
 * Ishaan Sayal
 * Data Structures Period 2
 * 11/13/2023
 */

public class BinaryNumbersProgram 
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("\n===========================================");
		System.out.println("  All binary numbers are in Little Endian");
		System.out.println("===========================================\n");
		BinaryNumber b1 = new BinaryNumber("10000");
		BinaryNumber b2 = new BinaryNumber("10010011");
		System.out.println(b2);
		System.out.println("Decimal Value: " + b2.toDecimal());
		b1.shiftR(3);
		System.out.println("Shifted Right by 3: " + b1);
		b1.add(b2);
		System.out.println("B1 added to B2: " + b1);
		BinaryNumber b3 = new BinaryNumber("1110");
		BinaryNumber b4 = new BinaryNumber("1100");
		b3.add(b4);
		System.out.println(b3);
		BinaryNumber b5 = new BinaryNumber("000001");
		BinaryNumber b6 = new BinaryNumber("00001");
		b5.add(b6);
		b6.shiftR(1);
		b5.add(b6);
		System.out.println(b5);

	}

	// 10010011
	// decimal value: 201
	// shifted right by 3: 0001000
	// B1 added to B2: 10001011
	// 0101
	// Numbers not compatiable
	// Overflow
}
