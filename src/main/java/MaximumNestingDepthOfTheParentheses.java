
public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int max = 0;
        int remain = 0;
        char[] sChars = s.toCharArray();
        for (char aChar : sChars) {
            if (aChar == '(') {
                remain++;
            } else if (aChar == ')') {
                if (remain > max) {
                    max = remain;
                }
                remain--;
            }
        }

        return max;
    }

}
