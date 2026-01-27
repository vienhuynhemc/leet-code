/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    final boolean[] visited = new boolean[nums.length];
    for (int num : nums) {
      visited[num - 1] = true;
    }

    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) result.add(i + 1);
    }

    return result;
  }
}
