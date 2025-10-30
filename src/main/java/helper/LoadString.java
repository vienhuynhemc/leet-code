package helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadString {

    private static LoadString loadString;

    public static LoadString getInstance() {
        if (loadString == null) {
            loadString = new LoadString();
        }
        return loadString;
    }

    public String loadStringFromFile(String src) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
            String currentLine = bufferedReader.readLine();
            bufferedReader.close();
            return currentLine;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
