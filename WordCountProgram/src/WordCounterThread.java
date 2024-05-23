import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounterThread implements Runnable {
    private final String filename;
    private final Counter counter;
    public WordCounterThread(String filename, Counter counter) {
        this.filename = filename;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(new File(filename));
            int c = 0;
            while (in.hasNext()) {
                c++;
                in.next();
            }
            System.out.println(filename + ": " + c);
            counter.addCount(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
