/*
 * Ishaan Sayal
 * Data Structures Period 2
 * 11/13/2023
 */

import java.util.Arrays;

/**
 * Represents a little-endian binary number.
 */
public class BinaryNumber 
{
    private int[] binNum;
    private boolean overFlow = false;

    /**
     * Creates a new binary number with 0's
     * 
     * @param length size of the binary number
     */
    public BinaryNumber(int length) 
    {
        binNum = new int[length];
    }

    /**
     * Creates a binary number which is represented by a string
     * 
     * @param num
     */
    public BinaryNumber(String num) 
    {
        binNum = new int[num.length()];
        for (int i = 0; i < binNum.length; i++) 
        {
            binNum[i] = Character.getNumericValue(num.charAt(i));
        }
    }

    /**
     * Adds the other binary number to this binary number.
     * Only this binary number is modified
     * 
     * @param other The other binary number
     */
    public void add(BinaryNumber other) 
    {
        if (getLength() != other.getLength()) 
        {
            System.out.println("Numbers not compatiable");
            return;
        }
        int carry = 0;
        int[] newNum = new int[this.binNum.length];
        for (int i = 0; i < this.binNum.length; i++) 
        {

            int num1 = binNum[i];
            int num2 = other.binNum[i];

            newNum[i] = (num1 + num2 + carry) % 2;
            carry = (num1 + num2 + carry) >= 2 ? 1 : 0;
        }
        if (carry != 0) 
        {
            overFlow = true;
            newNum = Arrays.copyOf(newNum, this.binNum.length + 1);
            newNum[binNum.length] += carry;
        }

        binNum = newNum;
    }

    @Override
    public String toString() 
    {
        if (overFlow)
            return "Overflow";
        return Arrays.toString(binNum)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "");
    }

    /**
     * Converts the binary number into a decimal value
     * 
     * @return The decimal value of the binary number
     */
    public int toDecimal() 
    {
        int amount = 0;
        for (int i = 0; i < binNum.length; i++) 
        {
            int digit = binNum[i];
            if (digit == 1)
                amount += Math.pow(2, i);
        }
        return amount;
    }

    /**
     * @param index the index starting at 0
     * @return The digit of the binary number
     */
    public int getDigit(int index) 
    {
        return binNum[index];
    }

    /**
     * Shifts the number to the left by amount.
     * Adds 0 at the end
     * 
     * @param amount The amount to shift
     */
    public void shiftR(int amount) 
    {
        int[] arr = new int[getLength() + amount];
        for (int i = amount; i < arr.length; i++) 
        {
            arr[i] = binNum[i - amount];
        }
        binNum = arr;
    }

    /**
     * The length of the binary number
     * 
     * @return
     */
    public int getLength() 
    {
        return binNum.length;
    }

    /**
     * Clears the overflow flag on the binary number
     */
    public void clearOverflow() 
    {
        overFlow = false;
    }
}
