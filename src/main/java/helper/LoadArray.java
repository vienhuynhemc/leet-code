package helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadArray {

    private static LoadArray loadArray;

    public static LoadArray getInstance() {
        if (loadArray == null)
            loadArray = new LoadArray();
        return loadArray;
    }

    public int[] loadIntArrayFromFile(String src) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
            String currentLine = bufferedReader.readLine();
            String[] strings = currentLine.split(",");
            int[] result = new int[strings.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = Integer.parseInt(strings[i]);
            }
            bufferedReader.close();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
