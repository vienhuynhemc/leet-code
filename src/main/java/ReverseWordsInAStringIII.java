
import java.util.Stack;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        StringBuilder resultBuilder = new StringBuilder();
        int n = s.length();

        Stack<Character> words = new Stack<>();
        for (int i = 0; i < n; i++) {
            char word = s.charAt(i);

            if (word == ' ') {
                resultBuilder.append(buildReverseWords(words));
                resultBuilder.append(' ');

                words.clear();
                continue;
            }

            words.push(word);
        }

        resultBuilder.append(buildReverseWords(words));

        return resultBuilder.toString();
    }

    private StringBuilder buildReverseWords(Stack<Character> words) {
        StringBuilder wordBuilder = new StringBuilder();
        while (!words.isEmpty()) {
            wordBuilder.append(words.pop());
        }

        return wordBuilder;
    }

}
