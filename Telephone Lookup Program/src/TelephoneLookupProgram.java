/**
 * Ishaan Sayal
 * Data Structures Period 2
 * 10/5/2023
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TelephoneLookupProgram
{
    private static final Scanner in = new Scanner(System.in);
    private static final ArrayList<Person> nameSorted = new ArrayList<>();
    private static final ArrayList<Person> numberSorted = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {

        Scanner in = new Scanner(new File("Telephone Lookup Program/directory.txt"));
        while (in.hasNextLine())
        {
            String name = in.nextLine();
            String phoneNumber = in.nextLine();

            nameSorted.add(new Person(name, phoneNumber));
            numberSorted.add(new Person(phoneNumber, name));
        }
        //https://apps.timwhitlock.info/unicode/inspect?s=%EF%BB%BFAbercrombie%2C+Neil
        Collections.sort(nameSorted);
        Collections.sort(numberSorted);

        System.out.println("The directory has been loaded.");
        askInputType();
    }

    private static void askInputType()
    {
        System.out.print("\nPick an input type (N)ame, (P)hone Number, or (E)xit: ");
        switch (in.nextLine())
        {
            case "N":
                askName();
                break;
            case "P":
                askNumber();
                break;
            case "E":
                System.out.println("Goodbye.");
                System.exit(0);
                return;
            default:
                askInputType();
        }
    }

    public static void askName()
    {
        System.out.print("Type in the name (Last, First): ");
        String name = in.nextLine();
        int index = Collections.binarySearch(nameSorted, new Person(name, "0"));
        if(index < 0)
        {
            System.out.println("ERROR: Lookup Failed. That customer does not exist.");
            askInputType();
            return;
        }
        Person person = nameSorted.get(index);

        System.out.println("Name: " + person.getKey() + " | Phone #: " + person.getValue());
        askInputType();
    }
    public static void askNumber()
    {
        System.out.print("Type in the phone number (###-####): ");
        String price = in.nextLine();
        int index = Collections.binarySearch(numberSorted, new Person(price, "0"));
        if(index < 0)
        {
            System.out.println("ERROR: Lookup Failed. That customer doess not exist.");
            askInputType();
            return;
        }
        Person person = numberSorted.get(index);

        System.out.println("Name: " + person.getValue() + " | Phone #: " + person.getKey());
        askInputType();
    }
}
