public class HelloWorld {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int [] values = new int[20];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        int pos = 5;
        int iterations = 0;
        for(int i = pos + 1; i < values.length; i++) {
            values[i - 1] = values[i];
            iterations+=2;
        }
        System.out.println(iterations);

        
    }
}
