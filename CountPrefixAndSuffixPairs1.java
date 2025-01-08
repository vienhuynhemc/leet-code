public class CountPrefixAndSuffixPairs1 {

    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPrefixAndSuffix(String str, String target) {
        final char[] targetChars = target.toCharArray();
        final char[] strChars = str.toCharArray();
        if (strChars.length > targetChars.length) {
            return false;
        }

        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] != targetChars[i]) {
                return false;
            }
        }

        int j = 0;
        for (int i = targetChars.length - strChars.length; i < targetChars.length; i++) {
            if (strChars[j] != targetChars[i]) {
                return false;
            }
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        final CountPrefixAndSuffixPairs1 test = new CountPrefixAndSuffixPairs1();
        System.out.println(test.countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aa"}));
        System.out.println(test.countPrefixSuffixPairs(new String[]{"pa", "papa", "ma", "mama"}));
        System.out.println(test.countPrefixSuffixPairs(new String[]{"abab", "ab"}));
    }
}
