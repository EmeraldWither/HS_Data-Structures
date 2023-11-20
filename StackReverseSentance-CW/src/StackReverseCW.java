import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackReverseCW {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter sentance: ");
        String sentance = in.nextLine();
        // add to stack
        Stack<String> stack = new Stack<>();
        String[] sent = sentance.split("\\.");
        for (int i = sent.length - 1; i >= 0; i--) {
            String s = sent[i];
            stack.push(s);
        }
        while(stack.size() > 0) {
            String[] s = stack.pop().split(" ");
            for (int i = s.length - 1; i >= 0; i--) {
                String word = s[i];
                if(word.isEmpty()) continue;
                if(i == s.length - 1) System.out.print(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ");
                else if ((i == 1 && stack.size() == 0) || i == 0) System.out.print(word.toLowerCase());
                else if (i > 0) System.out.print(word.toLowerCase() + " ");
                if(i == 0 && stack.size() > 0) System.out.print(". ");
                if(i == 1 && stack.size() == 0) System.out.print(".");
            }
        }
        System.out.println();
    }
}
