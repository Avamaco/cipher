import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Collection;

/* All the methods here append lines to the file rather than overwriting it */
public abstract class WriteFile<T extends Collection<String>> {
    abstract void writeToExistingFile(File file, T input) throws IOException;
    void writeToExistingFile(String name, T input) throws IOException {
        writeToExistingFile(new File(name), input);
    }
    void writeToNewFile(File file, T input) throws IOException {
        if(!file.createNewFile()) {
            throw new FileNotFoundException("File " + file.getName() + " already exists.");
        }
        writeToExistingFile(file, input);
    }
    void writeToNewFile(String name, T input) throws IOException {
        writeToNewFile(new File(name), input);
    }
}
