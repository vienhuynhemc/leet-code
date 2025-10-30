/* vienhuynhemc */
public class MaximumCountOfPositiveIntegerAndNegativeInteger {

  public int maximumCount(int[] nums) {
    int neg = 0;
    int end = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        neg++;
      } else if (nums[i] > 0) {
        end = i;
        break;
      }
    }

    return end == -1 ? neg : Math.max(neg, nums.length - end);
  }
}
