/*
 * Ishaan Sayal
 * Data Structures Period 2
 * 11/13/2023
 */

 /**
  * Represents a little-endian binary number.
  */
public class BinaryNumber {
    private String binNum;
    private boolean overFlow = false;
    /**
     * Creates a new binary number with 0's
     * @param length size of the binary number
     */
    public BinaryNumber(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++)
            builder.append("0");
        binNum = builder.toString();
    }
    /**
     * Creates a binary number which is represented by a string
     * @param num
     */
    public BinaryNumber(String num) {
        this.binNum = num;
    }
    /**
     * Adds the other binary number to this binary number.
     * Only this binary number is modified
     * @param other The other binary number
     */
    public void add(BinaryNumber other) {
        int carry = 0;
        String newNum = "";
        for (int i = 0; i < this.binNum.length(); i++) {

            int num1 = Character.getNumericValue(binNum.charAt(i));
            int num2 = Character.getNumericValue(other.binNum.charAt(i));

            newNum += (num1 + num2 + carry) % 2;
            carry = (num1 + num2 + carry) >= 2 ? 1 : 0;
        }
        if (carry != 0) {
            overFlow = true;
            newNum += carry;
        }

        binNum = newNum;
    }

    @Override
    public String toString() {
        if (overFlow)
            return "Overflow";
        return "Binary: " + binNum + " | Integer: " + toDecimal();
    }

    /**
     * Converts the binary number into a decimal value
     * @return The decimal value of the binary number
     */
    public int toDecimal() {
        int amount = 0;
        for (int i = 0; i < binNum.length(); i++) {
            int digit = Character.getNumericValue(binNum.charAt(i));
            if (digit == 1)
                amount += Math.pow(2, i);
        }
        return amount;
    }

    /**
     * @param index the index starting at 0
     * @return The digit of the binary number
     */
    public int getDigit(int index) {
        return Character.getNumericValue(binNum.charAt(index));
    }
    /**
     * Shifts the number to the left by amount.
     * Adds 0 at the end
     * @param amount The amount to shift
     */
    public void shiftL(int amount) {
        for (int i = 0; i < amount; i++)
            binNum += "0";
    }
    /**
     * The length of the binary number
     * @return
     */
    public int getLength() {
        return binNum.length();
    }
    /**
     * Clears the overflow flag on the binary number
     */
    public void clearOverflow() {
        overFlow = false;
    }
}
