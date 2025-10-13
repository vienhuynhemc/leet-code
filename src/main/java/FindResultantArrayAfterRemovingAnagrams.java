package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FindResultantArrayAfterRemovingAnagrams {

    public List<String> removeAnagrams(String[] words) {
        final Map<String, char[]> map = new HashMap<>();
        for (String word : words) {
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            map.put(word, chars);
        }

        final Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (stack.isEmpty()) {
                stack.push(word);
                continue;
            }

            final char[] first = map.get(stack.peek());
            final char[] second = map.get(word);

            if (Arrays.equals(first, second)) {
                continue;
            }

            stack.push(word);
        }

        final List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.addFirst(stack.pop());
        }

        return result;
    }
}
