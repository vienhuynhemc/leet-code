
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumNumberOfWordsYouCanType {

    public int canBeTypedWords(String text, String brokenLetters) {
        final String[] words = text.split(" ");

        final char[] chars = brokenLetters.toCharArray();
        final Set<Character> brokenLettersSet = new HashSet<>();
        for (char aChar : chars) {
            brokenLettersSet.add(aChar);
        }

        int result = 0;

        final List<String> dbNegative = new ArrayList<>();
        final List<String> dbPositive = new ArrayList<>();

        for (String word : words) {
            if (dbNegative.contains(word)) {
                continue;
            }

            if (dbPositive.contains(word)) {
                result++;
                continue;
            }

            final char[] charArray = word.toCharArray();
            boolean found = false;
            for (char c : charArray) {
                if (brokenLettersSet.contains(c)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                dbNegative.add(word);
                continue;
            }

            result++;
            dbPositive.add(word);
        }

        return result;
    }
}
