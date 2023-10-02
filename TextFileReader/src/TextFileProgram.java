import java.io.File;
import java.io.PrintWriter;

public class TextFileProgram {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader(new File("TextFileReader/input.txt"));
        PrintWriter writer = new PrintWriter(new File("TextFileReader/output.txt"));
        writer.println(reader.getTotalLines() + " lines");
        writer.println(reader.getTotalCharacters() + " characters");
        writer.println(reader.getTotalWords() + " words");
        writer.close();

    }
}
