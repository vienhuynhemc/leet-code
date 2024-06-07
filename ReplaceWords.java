import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        final StringBuilder result = new StringBuilder();

        final Set<String> set = new HashSet<>(dictionary);

        final String[] sentences = sentence.split(" ");

        for (String s : sentences) {
            final StringBuilder current = new StringBuilder();

            final char[] chars = s.toCharArray();
            for (char aChar : chars) {
                current.append(aChar);

                if (set.contains(current.toString())) {
                    break;
                }
            }

            result.append(current);
            result.append(" ");
        }

        // Remove last space
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

}
