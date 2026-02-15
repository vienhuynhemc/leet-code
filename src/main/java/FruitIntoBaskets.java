/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

  public int totalFruit(int[] fruits) {
    final Map<Integer, Integer> fruitCount = new HashMap<>();
    int left = 0;
    int right = 0;
    int result = 0;

    while (right < fruits.length) {
      final int newCount = fruitCount.getOrDefault(fruits[right], 0) + 1;
      fruitCount.put(fruits[right], newCount);

      while (fruitCount.size() > 2) {
        fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
        if (fruitCount.get(fruits[left]) == 0) fruitCount.remove(fruits[left]);
        left++;
      }

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}
