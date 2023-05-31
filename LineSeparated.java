import java.io.*;
import java.util.Collection;

/* Writes strings, each in a separate line */
public class LineSeparated<T extends Collection<String>> extends WriteFile<T> {
    @Override
    void writeToExistingFile(File file, T input) throws IOException {
        if(!file.exists()) {
            throw new FileNotFoundException("File " + file.getName() + " is not found.");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        if(file.length() > 0) {
            writer.newLine();
        }
        for(String s : input) {
            writer.write(s);
            writer.newLine();
        }
        writer.close();
    }
}
