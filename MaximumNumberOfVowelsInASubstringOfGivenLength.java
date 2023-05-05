import load.LoadString;
import log.LogTimeExecute;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public int maxVowels(String s, int k) {
        int max = 0;
        int before = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            if (i == 0) {
                char[] array = s.substring(i, i + k).toCharArray();
                for (char character : array) {
                    if (isVowel(character)) {
                        max++;
                        if (max == k) {
                            return k;
                        }
                    }
                }
                before = max;
            } else {
                boolean isBeforeIsVowel = isVowel(s.charAt(i - 1));
                boolean isAfterIsVowel = isVowel(s.charAt(i + k - 1));
                int current = before;
                if (isBeforeIsVowel) {
                    current--;
                }
                if (isAfterIsVowel) {
                    current++;
                }
                if (current == k) {
                    return current;
                }
                if (current > max) {
                    max = current;
                }
                before = current;
            }
        }
        return max;
    }

    private boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength maximumNumberOfVowelsInASubstringOfGivenLength = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("abciiidef", 3));
        System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("aeiou", 2));
        System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("leetcode", 3));
        System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("weallloveyou", 7));
        String largeString = LoadString.getInstance().loadStringFromFile("data/maximum-number-of-vowels-in-a-substring-of-given-length.txt");
        LogTimeExecute.getInstance().log(unused -> maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels(largeString, 50436));
    }

}
