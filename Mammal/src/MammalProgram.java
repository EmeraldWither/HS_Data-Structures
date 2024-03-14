import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MammalProgram
{
    private static Node root = new Node();

    public static void main(String[] args) throws Exception
    {
        System.out.println("==========================");
        System.out.println("         Mammal v1        ");
        System.out.println("==========================");
        Scanner in = new Scanner(System.in);
        loadTree();
        Node n = root;

        while (true)
        {
            if (n == null)
                return;
            System.out.print(n.data + " (y/n/q): ");
            String response = in.nextLine();
            if (response.equalsIgnoreCase("q")) break;
            if (response.equalsIgnoreCase("y"))
            {
                if (n.isLeaf())
                {
                    System.out.println("I got it! Lets go again!\n============================\n");
                    n = root;
                    continue;
                }
                n = n.yes;
                continue;
            }
            if (response.equalsIgnoreCase("n"))
            {
                if (n.isLeaf())
                {
                    System.out.println("I couldnt get it. What was your animal?");
                    String animal = in.nextLine();
                    String currentAnimal = n.data.replace("Is it a ", "").replace("\\?", "");
                    System.out.println(
                            "Make a question that is true for a " + animal + " but is false for a " + currentAnimal);
                    // rebuild the tree
                    n.data = in.nextLine();
                    n.yes = new Node("Is it an " + animal + "?");
                    n.no = new Node("Is it an " + currentAnimal + "?");
                    System.out.println("Alright! I got that. Lets try again!\n============================\n");
                    n = root;
                    continue;
                }
                n = n.no;
            }
        }
        saveTree("mammal.tree");
    }
    private static void buildNewTree()
    {
        root.data = "Is it a Mammal?";
        root.no = new Node("Does it fly?",
                new Node("Is it a Eagle?"),
                new Node("Does it swim?",
                        new Node("Is it a penguin?"), new Node("Is it a ostrich?")));
        root.yes = new Node("Does it have stripes?",
                new Node("Is it a canivore?", new Node("Is it a tiger?"), new Node("Is it a zebra?")),
                new Node("Is it a pig?"));
    }

    private static void loadTree() throws FileNotFoundException
    {
        File file = new File("mammal.tree");
        if (!file.exists())
        {
            System.out.println("Unable to find previous mammal save file at " + file.getAbsolutePath() + ". Building a new tree...");
            buildNewTree();
            return;
        }
        // start loading process
        Scanner in = new Scanner(file);
        // get parent
        root = loadTree(in);
        in.close();
        System.out.println("The previous save file has been loaded.");
    }

    public static void saveTree(String filename) throws IOException
    {
        File file = new File(filename);
        FileWriter writer = new FileWriter(file);
        writer.write(treeToString(root));
        writer.close();

        System.out.println("Tree has been saved at " + file.getAbsolutePath());
    }
    private static String treeToString(Node n)
    {
        if(n.isLeaf()) return n.data + "\n;\n;";
        return n.data + "\n" + treeToString(n.yes) +  "\n" + treeToString(n.no);
    }

    public static Node loadTree(Scanner in)
    {
        if (!in.hasNextLine()) return null;
        String input = in.nextLine();
        if (input.equals(";")) return null;
        Node n = new Node(input);
        n.yes = loadTree(in);
        n.no = loadTree(in);
        return n;
    }

}
