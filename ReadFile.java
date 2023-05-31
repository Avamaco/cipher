import java.io.IOException;
import java.util.Collection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class ReadFile<T extends Collection<String>> {
    abstract void read(File file, T output) throws IOException;
    void read(String name, T output) throws IOException {
        read(new File(name), output);
    }
}
