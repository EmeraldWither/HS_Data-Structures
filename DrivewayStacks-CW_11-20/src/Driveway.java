import java.util.Scanner;
import java.util.Stack;

public class Driveway {
    private final Stack<Integer> driveway = new Stack<>();
    private final Stack<Integer> street = new Stack<>();
    private final Scanner in = new Scanner(System.in);

    public void simulate() {
        askForInput();
    }

    private void askForInput() {
        System.out.print("Enter in the plate number: ");
        int plateNum = in.nextInt();
        if (plateNum == 0)
            return;
        if (plateNum > 0)
            addPlate(plateNum);
        if (plateNum < 0)
            removePlate(-plateNum);
        askForInput();
    }

    private void addPlate(int plateNum) {
        // add car to the stack
        if(driveway.contains(plateNum)){
            System.out.println("There is already a car there!");
            return;
        } 
        driveway.push(plateNum);
        printStatus();
    }

    private void removePlate(int i) {
        if(!driveway.contains(i)) { 
            System.out.println("That car does not exist!");
            return;
        }
        // push out all cars from the driveway
        boolean removed = false;
        while (driveway.size() > 0) {
            int num = driveway.pop();
            if (num == i) {
                // remove the car that we need to remove
                printStatus();
                System.out.println("The car has been removed.");
                removed = true;
                break;
            }
            street.push(num);
            printStatus();
        }
        //now, push them all back in
        while(street.size() > 0){
            driveway.push(street.pop());
            printStatus();
        }
        if(removed) System.out.println("The car with the license plate " + i + " was removed.");
        if(!removed) System.out.println("Your car is not found.");
    }

    private void printStatus() {
        System.out.println("Driveway: " + driveway.toString());
        System.out.println("Street: " + street.toString());
    }

}
