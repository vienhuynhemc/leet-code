/* vienhuynhemc */
import java.util.HashMap;
import java.util.Map;

public class FourDivisors {

  private final Map<Integer, Integer> fourDivisorsCache = new HashMap<>();

  public int sumFourDivisors(int[] nums) {
    int result = 0;
    for (int num : nums) {
      if (fourDivisorsCache.containsKey(num)) {
        result += fourDivisorsCache.get(num);
        continue;
      }

      int divisorCount = 2;
      int divisorSum = 1 + num;
      int length = num / 2;
      for (int i = 2; i <= length; i++) {
        if (num % i == 0) {
          divisorSum += i;
          divisorCount++;
        }

        if (divisorCount > 4) {
          break;
        }
      }

      if (divisorCount == 4) {
        result += divisorSum;
        fourDivisorsCache.put(num, divisorSum);
      }
    }

    return result;
  }

  static void main() {
    final FourDivisors f = new FourDivisors();
    System.out.println(f.sumFourDivisors(new int[] { 21, 21 }));
  }
}
