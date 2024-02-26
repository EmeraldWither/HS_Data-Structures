import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MammalProgram {

    private static Node root = new Node();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        loadTree();
        Node n = root;
        while (true) {
            if (n == null)
                return;
            System.out.println(n.data + " (y/n/q)");
            String response = in.nextLine();
            if(response.equalsIgnoreCase("q")) break;
            if (response.equalsIgnoreCase("y")) {
                if (n.isLeaf()) {
                    System.out.println("I got it! Lets go again!\n============================\n");
                    n = root;
                    continue;
                }
                n = n.yes;
                continue;
            }
            if (response.equalsIgnoreCase("n")) {
                if (n.isLeaf()) {
                    System.out.println("I couldnt get it. What was your animal?");
                    String animal = in.nextLine();
                    String currentAnimal = n.data.split(" ")[3].replaceAll("\\?", "");
                    System.out.println(
                            "Make a question that is true for a " + animal + " but is false for a " + currentAnimal);
                    String question = in.nextLine();
                    // rebuild the tree
                    n.data = question;
                    n.yes = new Node("Is it an " + animal + "?");
                    n.no = new Node("Is it an " + currentAnimal + "?");
                    System.out.println("Alright! I got that. Lets try again!\n============================\n");
                    n = root;
                    continue;
                }
                n = n.no;
                continue;
            }
        }
        saveTree(root, "mammal.tree");
    }

    private static void buildNewTree() {
        root.data = "Is it a Mammmal?";
        root.no = new Node("Does it fly?",
                new Node("Is it an Eagle?"),
                new Node("Does it swim?",
                        new Node("Is it a penguin?"), new Node("Is it an ostrich?")));
        root.yes = new Node("Does it have stripes?",
                new Node("Is it a canivore?", new Node("Is it a tiger?"), new Node("Is it a zebra?")),
                new Node("Is it a pig?"));
    }

    private static void loadTree() throws FileNotFoundException {
        File file = new File("mammal.tree");
        if (!file.exists()) {
            System.out.println("Unable to find previous mammal save file at " + file.getAbsolutePath() + ". \nBuilding a new tree");
            buildNewTree();
            return;
        }
        // start loading process
        Scanner in = new Scanner(file);
        // get parent
        Node parent = new Node(in.nextLine());
        root = loadTree(parent, in);
        System.out.println("The previous save file has been loaded.");
    }

    public static void saveTree(Node tree, String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("\n" + getTree(root));
        writer.close();

        System.out.println("Tree has been saved at " + file.getAbsolutePath());
    }
    private static String getTree(Node n) {
        if(n.isLeaf()) {
            return n.data + "\n;\n;";
        }
        return n.data + "\n" + getTree(n.yes) +  "\n" + getTree(n.no);
    }

    public static Node loadTree(Node parent, Scanner in) {
        if (!in.hasNextLine())
            return null;
        String input = in.nextLine();
        if (input.equals(";")) {
            return null;
        }
        Node n = new Node(input);
        n.yes = loadTree(n, in);
        n.no = loadTree(n, in);
        return n;
    }

}
