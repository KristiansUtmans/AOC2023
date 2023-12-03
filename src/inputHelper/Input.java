package inputHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Input {

    public static String[] getInput(String day) throws IOException {
        return loadFileToArray("inputs/" + day + "/input.txt");
    }

    private static String[] loadFileToArray(String fileName) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get(fileName)));

        return Arrays.stream(s.split("\n")).toArray(String[]::new);
    }
}

