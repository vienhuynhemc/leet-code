
public class CountingWordsWithAGivenPrefix {

    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        final char[] prefixChars = pref.toCharArray();

        for (int i = 0; i < words.length; i++) {
            final char[] chars = words[i].toCharArray();
            if (chars.length < prefixChars.length) {
                continue;
            }

            boolean isDontMatch = false;
            for (int j = 0; j < prefixChars.length; j++) {
                if (chars[j] != prefixChars[j]) {
                    isDontMatch = true;
                    break;
                }
            }

            if (!isDontMatch) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        final CountingWordsWithAGivenPrefix test = new CountingWordsWithAGivenPrefix();
        System.out.println(test.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        System.out.println(test.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));
    }

}
