/* vienhuynhemc */
public class MaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    int result = 0;

    int count = 0;
    for (int num : nums) {
      if (num == 0) {
        count = 0;
        continue;
      }

      count++;
      if (count > result) {
        result = count;
      }
    }

    return result;
  }
}
