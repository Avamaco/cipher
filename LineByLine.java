import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

/* Reads from file, treating each line as separate string */
public class LineByLine<T extends Collection<String>> extends ReadFile<T> {
    @Override
    void read(File file, T output) throws IOException {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            output.add(scanner.nextLine());
        }
    }
}