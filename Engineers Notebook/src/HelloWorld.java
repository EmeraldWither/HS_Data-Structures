
public class HelloWorld {
    public static void main(String[] args) throws Exception {
        Pair<String> i = new Pair<>("First", "Second");
        System.out.println(i);
        i.swap();
        System.out.println(i);
    }
}
