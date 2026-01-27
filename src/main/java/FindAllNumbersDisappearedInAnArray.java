/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int num : nums) {
      final int index = Math.abs(num) - 1;
      if (nums[index] > 0) nums[index] = -nums[index];
    }

    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) result.add(i + 1);
    }

    return result;
  }
}
