/* vienhuynhemc */
public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    int idx = 0;
    while (idx < n) {
      int expectIdx = nums[idx] - 1;

      // Out range n
      if (expectIdx < 0 || expectIdx >= n) {
        idx++;
        continue;
      }

      // If different then swap
      if (nums[idx] != nums[expectIdx]) {
        int temp = nums[idx];
        nums[idx] = nums[expectIdx];
        nums[expectIdx] = temp;
      } else {
        idx++;
      }
    }

    // If one position has value is not like expected => return expected value
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    // All index is correct => out range => n + 1
    return n + 1;
  }
}
