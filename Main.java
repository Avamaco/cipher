import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathIn;
        String pathOut;
        ArrayList<String> text = new ArrayList<>();
        LineByLine<ArrayList<String>> reader = new LineByLine<>();

        boolean caesarOrMorse;
        boolean encodeOrDecode;
        boolean newOrExisting;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Use (C)aesar cipher or (M)orse code?");
        caesarOrMorse = chooseOption("caesar", "morse", scanner);

        System.out.println("(E)ncode or (D)ecode the message?");
        encodeOrDecode = chooseOption("encode", "decode", scanner);

        System.out.println("Write to a (N)ew oe (E)xisting file?");
        newOrExisting = chooseOption("new", "existing", scanner);

        System.out.println("Input file name:");
        pathIn = scanner.nextLine();

        System.out.println("Output file name:");
        pathOut = scanner.nextLine();

        try {
            reader.read(pathIn, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Cipher textChanger = caesarOrMorse ? new Caesar() : new Morse();

        if (encodeOrDecode)
            text.replaceAll(textChanger::encode);
        else
            text.replaceAll(textChanger::decode);

        LineSeparated<ArrayList<String>> writer = new LineSeparated<>();
        try {
            if (newOrExisting)
                writer.writeToNewFile(pathOut, text);
            else
                writer.writeToExistingFile(pathOut, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean chooseOption(String option1, String option2, Scanner scanner) {
        String option1alt = option1.substring(0, 1);
        String option2alt = option2.substring(0, 1);
        String userInput;
        while (true) {
            userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals(option1) || userInput.equals(option1alt))
                return true;
            if (userInput.equals(option2) || userInput.equals(option2alt))
                return false;
            System.out.println("Please enter a valid answer.");
        }
    }
}
