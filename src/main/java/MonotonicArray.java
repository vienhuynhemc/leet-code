/* vienhuynhemc */
public class MonotonicArray {

  public boolean isMonotonic(int[] nums) {
    if (nums.length < 3) {
      return true;
    }

    boolean updateState = false;
    boolean isIncrease = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }

      if (!updateState) {
        updateState = true;
        isIncrease = nums[i] > nums[i - 1];
        continue;
      }

      if ((isIncrease && nums[i] < nums[i - 1]) || (!isIncrease && nums[i] > nums[i - 1])) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    MonotonicArray monotonicArray = new MonotonicArray();
    System.out.println(monotonicArray.isMonotonic(new int[] { 1, 2, 2, 3 }));
  }
}
