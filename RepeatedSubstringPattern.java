public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        for (int i = s.length() - 1; i > 0; i--) {
            if (length % i != 0) {
                continue;
            }

            String subString = s.substring(0, i);

            if (s.equals(subString.repeat(length / i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern pattern = new RepeatedSubstringPattern();
        System.out.println(pattern.repeatedSubstringPattern("abab"));
        System.out.println(pattern.repeatedSubstringPattern("aba"));
        System.out.println(pattern.repeatedSubstringPattern("abcabcabcabc"));
    }

}
