/* vienhuynhemc */
public class HouseRobber {

  public int rob(int[] nums) {
    final int[] dp = new int[nums.length];
    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      final int skipThisHouse = dp[i - 1];
      final int robThisHouse = i > 1 ? dp[i - 2] + nums[i] : nums[i];
      dp[i] = Math.max(skipThisHouse, robThisHouse);
    }

    return dp[nums.length - 1];
  }
}
