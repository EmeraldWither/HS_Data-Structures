import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AirportSimProgram {
    private static final Scanner in = new Scanner(System.in);
    private static final Queue<Integer> landing = new LinkedList<>();
    private static final Queue<Integer> takeoff = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        askInput();
    }

    public static void askInput() {
        System.out.print("Enter in a command: ");
        String input = in.nextLine();
        String command = input.split(" ")[0];
        if (command.equals("land")) {
            landing.add(Integer.parseInt(input.split(" ")[1]));
        } else if (command.equals("takeoff")) {
            takeoff.add(Integer.parseInt(input.split(" ")[1]));
        } else if (command.equals("next")) {
            if(landing.size() > 0) System.out.println("Flight #" + landing.remove() + " has landed.");
            else if(takeoff.size() > 0) System.out.println("Flight #" + takeoff.remove() + " has taken off.");
            else System.out.println("No more flights.");
        } else if (command.equals("quit")) {
            return;
        } else {
            System.out.println("invalid command.");
        }
        askInput();
    }
}
