import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("give n: ");
        int n = in.nextInt();
        allPrimeNumbers(n);
    }

    public static void allPrimeNumbers(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i <= n; i++)
            set.add(i);
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            int num = itr.next();
            if (num == 2 || num == 3)
                continue;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (num % i == 0 && num != i) {
                    itr.remove();
                    break;
                }
        }
        System.out.println(set);
    }
}
