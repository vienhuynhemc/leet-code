/* vienhuynhemc */
public class BinarySubarraysWithSum {

  public int numSubarraysWithSum(int[] nums, int goal) {
    int total = 0;
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      int sum = nums[i];
      if (sum == goal) {
        total++;
      }
      for (int j = i + 1; j < length; j++) {
        sum += nums[j];
        if (sum == goal) {
          total++;
        } else if (sum > goal) {
          break;
        }
      }
    }

    return total;
  }
}
