/*
 * Ishaan Sayal
 * Data Structures Period 2
 * 11/30/23
 */
import java.util.Stack;

/**
 * Calculator, which evaluates algebric expressions
 **/
public class Calculator 
{
    private final String input;
    private final Stack<Integer> num = new Stack<>();
    private final Stack<String> op = new Stack<>();

    /**
     * @param input A string representing the algebric expression
     */
    public Calculator(String input) 
    {
        // replace the parenthesis with a space to split
        input = input.replace("(", "( ");
        input = input.replace(")", " )");
        this.input = input;
    }

    //
    /**
     * Evaluates the inputted algebric expression.
     * 
     * @return The evaluated number
     */
    public int eval() 
    {
        for (String s : input.split(" ")) 
        {
            // if you read a number
            if (isNumber(s))
                // push it onto the number stack
                num.push(Integer.parseInt(s));
            // else if you read a (
            else if (s.equals("("))
                // push it onto the operator stack
                op.push(s);
            // else if you read an operator op
            else if (isOperator(s)) 
            {
                //while the top is of higher precedence (and is greater than 0)
                while (!op.isEmpty() && !isHigherPrecedence(s, op.peek()))
                    //eval the top
                    evalTop();
                //push the operator
                op.push(s);
            } 
            //if it is a )
            else if (s.equals(")")) 
            {
                //loop until we find a (
                while (!op.isEmpty() && !op.peek().equals("("))
                    //eval the top
                    evalTop();
                //remove the (
                op.pop();
            }
        }
        // no more input
        while (!op.isEmpty())
            //eval the rest of the numbers
            evalTop();
        //return the first number in the stack
        return num.peek();
    }

    /**
     * @param s The string to check
     * @return True if it is an operator (not including parenthesis)
     */
    private boolean isOperator(String s) 
    {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    /**
     * @param s The string to check
     * @return Checks to see if a string is a number
     */
    private boolean isNumber(String s) 
    {
        boolean isNum = true;
        try 
        {
            Integer.parseInt(s);
        } 
        catch (NumberFormatException e) 
        {
            isNum = false;
        }
        return isNum;
    }

    /**
     * Checks the precedence in PEMDAS
     * @param first The operator to check to see if its higher
     * @param second The operator that is first is comparing to 
     * @return True if "first" is higher than "second"
     */
    private boolean isHigherPrecedence(String first, String second) 
    {
        return (!first.equals("+") && !first.equals("-")) || (!second.equals("*") && !second.equals("/"));
    }

    /**
     * Evaluates the top of the stack. 
     * Pops two numbers and an operator.
     * Push the evaluated num onto the stack.
     */
    private void evalTop() 
    {
        int i2 = num.pop();
        int i1 = num.pop();
        String operator = op.pop();

        if (operator.equals("+"))
            num.push(i1 + i2);
        if (operator.equals("-"))
            num.push(i1 - i2);
        if (operator.equals("*"))
            num.push(i1 * i2);
        if (operator.equals("/"))
            num.push(i1 / i2);

    }
}
