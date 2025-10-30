
import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int[] commons = new int[26];
        for (char c : words[0].toCharArray()) {
            commons[c - 'a']++;
        }

        int[] counter = new int[26];
        for (int i = 1; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                counter[c - 'a']++;
            }

            for (int i1 = 0; i1 < commons.length; i1++) {
                commons[i1] = Math.min(commons[i1], counter[i1]);
                counter[i1] = 0;
            }
        }

        final List<String> commonChars = new ArrayList<>();
        for (int i = 0; i < commons.length; i++) {
            while (commons[i] > 0) {
                commonChars.add(String.valueOf((char) (i + 97)));
                commons[i]--;
            }
        }

        return commonChars;
    }

}
