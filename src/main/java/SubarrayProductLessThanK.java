/* vienhuynhemc */
public class SubarrayProductLessThanK {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k < 2) {
      return 0;
    }

    int n = nums.length;
    int left = 0;
    int right = 0;
    int totalSubarray = 0;
    int product = 1;

    while (right < n) {
      product *= nums[right];

      while (product >= k) {
        product /= nums[left++];
      }

      totalSubarray += right - left + 1;
      right++;
    }

    return totalSubarray;
  }
}
