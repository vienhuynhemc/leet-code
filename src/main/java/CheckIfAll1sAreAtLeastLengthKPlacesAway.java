/* vienhuynhemc */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

  public boolean kLengthApart(int[] nums, int k) {
    int tempIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }

      if (tempIndex == -1) {
        tempIndex = i;
        continue;
      }

      if (i - tempIndex - 1 < k) {
        return false;
      }

      tempIndex = i;
    }

    return true;
  }
}
