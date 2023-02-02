import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charWithPosition = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            charWithPosition.put(order.charAt(i), i);
        for (int i = 0; i < words.length - 1; i++)
            for (int j = i + 1; j < words.length; j++)
                if (!isFirstWordSmallerThanSecondWord(words[i], words[j], charWithPosition))
                    return false;
        return true;
    }

    private boolean isFirstWordSmallerThanSecondWord(String s1, String s2, Map<Character, Integer> charWithPosition) {
        char[] charsOfS1 = s1.toCharArray();
        char[] charsOfS2 = s2.toCharArray();
        int length = Math.max(charsOfS1.length, charsOfS2.length);
        for (int i = 0; i < length; i++) {
            int indexOfC1 = -1;
            int indexOfC2 = -1;
            if (i < charsOfS1.length)
                indexOfC1 = charWithPosition.get(charsOfS1[i]);
            if (i < charsOfS2.length)
                indexOfC2 = charWithPosition.get(charsOfS2[i]);
            if (indexOfC1 < indexOfC2)
                return true;
            else if (indexOfC1 > indexOfC2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary verifyingAnAlienDictionary = new VerifyingAnAlienDictionary();
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

}
