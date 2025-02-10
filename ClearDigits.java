import java.util.Stack;

public class ClearDigits {

    public String clearDigits(String s) {
        final char[] chars = s.toCharArray();
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 47 && chars[i] < 58 && !stack.isEmpty()) {
                stack.pop();
                continue;
            }

            stack.push(chars[i]);
        }

        final StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        final ClearDigits tester = new ClearDigits();
        System.out.println(tester.clearDigits("abcd"));
        System.out.println(tester.clearDigits("abcd34"));
    }

}
