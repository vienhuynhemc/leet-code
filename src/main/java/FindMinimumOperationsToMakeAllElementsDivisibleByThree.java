/* vienhuynhemc */
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

  public int minimumOperations(int[] nums) {
    int result = 0;

    for (int num : nums) {
      final int remainder = num % 3;
      result += Math.min(3 - remainder, remainder);
    }

    return result;
  }
}
