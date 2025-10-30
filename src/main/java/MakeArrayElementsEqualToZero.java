/* vienhuynhemc */
public class MakeArrayElementsEqualToZero {

  public int countValidSelections(int[] nums) {
    int result = 0;

    int rightSum = 0;
    for (int i = 1; i < nums.length; i++) {
      rightSum += nums[i];
    }

    int leftSum = 0;

    int index = 0;
    while (index < nums.length) {
      if (nums[index] == 0) {
        if (leftSum == rightSum) {
          result += 2;
        } else if (Math.abs(leftSum - rightSum) == 1) {
          result += 1;
        }
      }

      leftSum += nums[index];
      if (index + 1 < nums.length) {
        rightSum -= nums[index + 1];
      }
      index++;
    }

    return result;
  }
}
