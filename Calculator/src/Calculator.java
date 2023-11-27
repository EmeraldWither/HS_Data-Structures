import java.util.Stack;

public class Calculator {
    private String input;
    private final Stack<Integer> num = new Stack<>();
    private final Stack<String> op = new Stack<>();

    public Calculator(String input) {
        input = input.replace("(", "( ");
        input = input.replace(")", " )");
        this.input = input;
    }

    public int eval() {
        for (String s : input.split(" ")) {
            // if you read a number
            // push it onto the number stack
            if (isNumber(s)) {
                num.push(Integer.parseInt(s));
            }
            // else if you read a (
            else if (s.equals("("))
                op.push(s);
            // else if you read an operator op
            else if (isOperator(s)) {
                while (op.size() > 0 && !isHigherPrecedence(s, op.peek())) {
                    evalTop();
                }
                op.push(s);
            } else if (s.equals(")")) {
                while (op.size() > 0 && !op.peek().equals("("))
                    evalTop();
                op.pop();
            }
        }
        // no more input
        while (op.size() > 0) {
            evalTop();
        }
        return num.peek();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private boolean isNumber(String s) {
        boolean isNum = true;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            isNum = false;
        }
        return isNum;
    }

    private boolean isHigherPrecedence(String first, String second) {
        if ((first.equals("+") || first.equals("-")) && (second.equals("*") || second.equals("/")))
            return false;
        else
            return true;
    }

    private void evalTop() {
        int i2 = num.pop();
        int i1 = num.pop();
        String operator = op.pop();

        if (operator.equals("+"))
            num.push(i1 + i2);
        if (operator.equals("-"))
            num.push(i1 + -i2);
        if (operator.equals("*"))
            num.push(i1 * i2);
        if (operator.equals("/"))
            num.push(i1 / i2);

    }
}
