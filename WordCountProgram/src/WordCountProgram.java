import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WordCountProgram {

    public static void main(String[] args) throws Exception {
        args = new String[] {"2600.txt", "input.txt", "input2.txt"};
        Counter counter = new Counter();
        for(String s : args) {
            new Thread(new WordCounterThread(s, counter)).start();
        }
        new Thread(
            () -> {
                while(true) {
                    if(counter.getTCount() == 0) {
                        System.out.println("Total Count:" + counter.getCount());
                        return;
                    }
                }
            }
        ).start();
    }
}
