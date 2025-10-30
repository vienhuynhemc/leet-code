/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute(nums, 0, result);
    return result;
  }

  private void permute(int[] nums, int indexOfLock, List<List<Integer>> result) {
    if (indexOfLock == nums.length - 1) {
      result.add(Arrays.stream(nums).boxed().toList());
      return;
    }
    for (int i = indexOfLock; i < nums.length; i++) {
      int temp = nums[indexOfLock];
      nums[indexOfLock] = nums[i];
      nums[i] = temp;
      permute(nums, indexOfLock + 1, result);
      nums[i] = nums[indexOfLock];
      nums[indexOfLock] = temp;
    }
  }

  static void main() {
    final Permutations permutations = new Permutations();
    System.out.println(permutations.permute(new int[] { 1, 2, 3 }));
    System.out.println(permutations.permute(new int[] { 0, 1 }));
    System.out.println(permutations.permute(new int[] { 1 }));
  }
}
