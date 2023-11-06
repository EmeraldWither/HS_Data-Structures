import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HashmapStudentGrades {
    private static final Map<String, String> grades = new TreeMap<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        askInput();
    }

    public static void askInput() {
        System.out.print("Pick a thing to do (add, remove, print, exit): ");
        String opt = in.nextLine();
        if (opt.equals("add")) {
            addGrade();
        }
        if (opt.equals("remove")) {
            removePerson();
        }
        if (opt.equals("print")) {
            System.out.println(grades.toString());
        }
        if (opt.equals("exit")) {
            return;
        }

        askInput();
    }

    public static void addGrade() {
        System.out.print("enter name: ");
        String name = in.nextLine();
        System.out.print("enter grade: ");
        String grade = in.nextLine();
        grades.put(name, grade);
    }
    public static void removePerson(){
        System.out.print("enter name: ");
        grades.remove(in.nextLine());
    }

}
