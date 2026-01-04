/* vienhuynhemc */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSquaresII {

  public List<List<String>> wordSquares(String[] words) {
    final List<List<String>> result = new ArrayList<>();

    final Map<Character, Set<String>> wordWithStartChar = new HashMap<>();
    final Map<Character, Set<String>> wordWithEndChar = new HashMap<>();

    for (String word : words) {
      wordWithStartChar.computeIfAbsent(word.charAt(0), _ -> new HashSet<>()).add(word);
      wordWithEndChar.computeIfAbsent(word.charAt(3), _ -> new HashSet<>()).add(word);
    }

    for (String top : words) {
      final char startChar = top.charAt(0);
      final char endChar = top.charAt(3);

      final Set<String> left = wordWithStartChar.getOrDefault(startChar, new HashSet<>());
      final Set<String> right = wordWithStartChar.getOrDefault(endChar, new HashSet<>());

      for (String leftWord : left) {
        if (leftWord.equals(top)) {
          continue;
        }

        for (String rightWord : right) {
          if (rightWord.equals(top) || rightWord.equals(leftWord)) {
            continue;
          }

          final Set<String> bottomWithLeft = wordWithStartChar.getOrDefault(leftWord.charAt(3), new HashSet<>());
          final Set<String> bottomWithRight = wordWithEndChar.getOrDefault(rightWord.charAt(3), new HashSet<>());

          for (String bottomWord : bottomWithLeft) {
            if (
              !bottomWithRight.contains(bottomWord) ||
              bottomWord.equals(top) ||
              bottomWord.equals(leftWord) ||
              bottomWord.equals(rightWord)
            ) {
              continue;
            }

            result.add(List.of(top, leftWord, rightWord, bottomWord));
          }
        }
      }
    }

    result.sort((first, second) -> {
      for (int i = 0; i < first.size(); i++) {
        int cmp = first.get(i).compareTo(second.get(i));
        if (cmp != 0) {
          return cmp;
        }
      }
      return 0;
    });

    return result;
  }

  static void main() {
    final WordSquaresII ws = new WordSquaresII();
    System.out.println(ws.wordSquares(new String[] { "able", "area", "echo", "also" }));
  }
}
