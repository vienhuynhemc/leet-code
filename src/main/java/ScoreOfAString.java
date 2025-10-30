
public class ScoreOfAString {

    public int scoreOfString(String s) {
        int score = 0;
        final char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            score += Math.abs(chars[i] - chars[i + 1]);
        }

        return score;
    }

}
