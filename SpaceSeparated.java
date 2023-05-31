import java.io.*;
import java.util.Collection;

/* Writes words to a file, separated by spaces */
/* If the file already contains something, then output is in a new line */
public class SpaceSeparated<T extends Collection<String>> extends WriteFile<T> {
    @Override
    void writeToExistingFile(File file, T input) throws IOException {
        if(!file.exists()) {
            throw new FileNotFoundException("File " + file.getName() + " is not found.");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        String stringToWrite="";
        for(String s : input) {
            stringToWrite += s;
            stringToWrite += " ";
        }
        if(file.length() > 0) {
            writer.newLine();
        }
        writer.write(stringToWrite);
        writer.close();
    }
}
