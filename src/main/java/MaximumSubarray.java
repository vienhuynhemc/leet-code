/* vienhuynhemc */
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];
    int current = nums[0];

    for (int i = 1; i < nums.length; i++) {
      current = Math.max(nums[i], nums[i] + current);
      maxSoFar = Math.max(maxSoFar, current);
    }

    return maxSoFar;
  }

  public static void main(String[] args) {
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    System.out.println(maximumSubarray.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    System.out.println(maximumSubarray.maxSubArray(new int[] { 1 }));
    System.out.println(maximumSubarray.maxSubArray(new int[] { 5, 4, -1, 7, 8 }));
  }
}
