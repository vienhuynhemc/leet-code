/* vienhuynhemc */
public class DivideAnArrayIntoSubarraysWithMinimumCostI {

  public int minimumCost(int[] nums) {
    final int firstSubarray = nums[0];
    int secondSubarray = nums[1];
    int minSumOfSecondAndThirdArray = Integer.MAX_VALUE;

    for (int i = 2; i < nums.length; i++) {
      final int thirdSubarray = nums[i];

      minSumOfSecondAndThirdArray = Math.min(minSumOfSecondAndThirdArray, secondSubarray + thirdSubarray);
      secondSubarray = Math.min(secondSubarray, thirdSubarray);
    }

    return firstSubarray + minSumOfSecondAndThirdArray;
  }
}
