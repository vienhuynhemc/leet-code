public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        String src = str1.length() > str2.length() ? str2 : str1;
        String result = "";
        for (int i = 1; i <= src.length(); i++) {
            String value = src.substring(0, i);
            if (this.isDivide(value, str1) && this.isDivide(value, str2))
                result = value;
        }
        return result;
    }

    private boolean isDivide(String s1, String s2) {
        if (s2.length() % s1.length() != 0)
            return false;
        for (int i = 0; i < s2.length(); i += s1.length()) {
            String value = s2.substring(i, i + s1.length());
            if (!value.equals(s1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE"));
    }

}
