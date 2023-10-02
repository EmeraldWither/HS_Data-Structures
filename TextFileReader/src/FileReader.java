import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private Scanner in;

    private int totalLines,totalCharacters,totalWords = 0;

    public FileReader(File file){
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist at " + file.getAbsolutePath());
            System.exit(1);
            return;
        }
        parse();
    }

    private void parse(){
        while(in.hasNextLine()){
            String input = in.nextLine();
            //find words and characters
            totalWords++;
            for(char c : input.toCharArray()){
                totalCharacters++;
                if(c == ' ') totalWords++;
            }
            totalLines++;
        }
    }

    public int getTotalLines(){
        return totalLines;
    }
    
    public int getTotalCharacters(){
        return totalCharacters;

    }
    public int getTotalWords(){
        return totalWords;
    }

}
