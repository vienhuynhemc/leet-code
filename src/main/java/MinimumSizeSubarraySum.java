/* vienhuynhemc */
public class MinimumSizeSubarraySum {

  public int minSubArrayLen(int target, int[] nums) {
    int result = nums.length;
    boolean isFound = false;

    int left = 0;
    int right = 0;

    int sum = nums[0];

    while (true) {
      if (sum < target) {
        if (right == nums.length - 1) {
          break;
        }

        right++;
        sum += nums[right];
        continue;
      }

      result = Math.min(result, right - left + 1);
      isFound = true;

      sum -= nums[left];
      left++;
    }

    return isFound ? result : 0;
  }
}
