import java.util.Scanner;

public class MammalProgram {

    private static Node root = new Node();
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        buildTree();
        Node n = root;
        while(true) {
            if(n == null) return;
            System.out.println(n.data);
            String response = in.nextLine();
            if(response.equalsIgnoreCase("y")){
                if(n.isLeaf()) {
                    System.out.println("I got it! Lets go again!\n");
                    n = root;
                    continue;
                }
                n = n.yes;
                continue;
            }
            if(response.equalsIgnoreCase("n")){
                if(n.isLeaf()) {
                    System.out.println("I couldnt get it. What was your animal?");
                    String animal = in.nextLine();
                    String currentAnimal = n.data.split(" ")[3].replaceAll("\\?", "");
                    System.out.println("Make a question that is true for a " + animal + " but is false for a " + currentAnimal);
                    String question = in.nextLine();
                    //rebuild the tree
                    n.data = question;
                    n.yes = new Node("Is it an " + animal + "?");
                    n.no = new Node("Is it an " + currentAnimal + "?");
                    System.out.println("Alright! I got that. Lets try again!\n\n");
                    n = root;
                    continue;
                }
                n = n.no;
                continue;
            }
        }
    }
    private static void buildTree() {
        root.data = "Is it a Mammmal?";
        root.no = new Node("Does it fly?",
            new Node("Is it an Eagle?"), 
            new Node("Does it swim?", 
                new Node("Is it a penguin?"), new Node("Is it an ostrich?")) );
        root.yes = new Node("Does it have stripes?",
            new Node("Is it a canivore?", new Node("Is it a tiger?"), new Node("Is it a zebra?")),
            new Node("Is it a pig?"));
    }
}
