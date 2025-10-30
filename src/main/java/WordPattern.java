/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class WordPattern {

  public boolean wordPattern(String pattern, String s) {
    String[] words = s.trim().split(" ");
    if (pattern.length() != words.length) return false;
    Map<Character, String> charWithIndex = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char charAtI = pattern.charAt(i);
      if (charWithIndex.containsKey(charAtI)) {
        if (!charWithIndex.get(charAtI).equals(words[i])) return false;
      } else {
        if (charWithIndex.containsValue(words[i])) return false;
        charWithIndex.put(charAtI, words[i]);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    WordPattern wordPattern = new WordPattern();
    System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
    System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
    System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog"));
  }
}
