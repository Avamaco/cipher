import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

/* Reads strings from file separated by spaces */
public class WordByWord<T extends Collection<String>> extends ReadFile<T> {
    @Override
    void read(File file, T output) throws IOException {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            for(String word : words) {
                output.add(word);
            }
        }
    }
}
