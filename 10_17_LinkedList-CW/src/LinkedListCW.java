import java.util.LinkedList;

public class LinkedListCW {
    public static void main(String[] args) throws Exception {
        downSize();
        System.out.println();
        reverseTestCase();
        System.out.println();
        reverseRecursivelyTestCase();
    }

    public static void downSize() {
        LinkedList<String> employee = new LinkedList<>();
        employee.add("Dennis");
        employee.add("Ishaan");
        employee.add("Sree");
        employee.add("Gavin");
        employee.add("O'Connell");
        employee.add("Auggie");
        employee.add("Ali");
        System.out.println("Prepare to use downsize on: " + employee.toString());
        LinkedUtils.downsize(employee, 3);
        System.out.println("Result: " + employee.toString());
    }

    public static void reverseTestCase() {
        LinkedList<String> employee = new LinkedList<>();
        employee.add("Dennis");
        employee.add("Ishaan");
        employee.add("Sree");
        employee.add("Gavin");
        employee.add("O'Connell");
        employee.add("Auggie");
        employee.add("Ali");
        System.out.println("Prepare to use iterative reverse on: " + employee.toString());
        LinkedUtils.reverse(employee);
        System.out.println("Result: " + employee.toString());
    }

    public static void reverseRecursivelyTestCase() {
        LinkedList<String> employee = new LinkedList<>();
        employee.add("Dennis");
        employee.add("Ishaan");
        employee.add("Sree");
        employee.add("Gavin");
        employee.add("O'Connell");
        employee.add("Auggie");
        employee.add("Ali");
        System.out.println("Prepare to use recursive reverse on: " + employee.toString());
        LinkedUtils.reverseRec(employee);
        System.out.println("Result: " + employee.toString());
    }

}
