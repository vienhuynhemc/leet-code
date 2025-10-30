/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    return this.combinationSum(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
  }

  private List<List<Integer>> combinationSum(
    int[] candidates,
    int target,
    List<Integer> temp,
    List<List<Integer>> out,
    int index
  ) {
    if (target == 0) {
      out.add(new ArrayList<>(temp));
      return out;
    }
    for (; index < candidates.length; index++) {
      if (target - candidates[index] < 0) {
        return out;
      }
      temp.add(candidates[index]);
      combinationSum(candidates, target - candidates[index], temp, out, index);
      temp.remove(temp.size() - 1);
    }
    return out;
  }

  public static void main(String[] args) {
    CombinationSum combinationSum = new CombinationSum();
    System.out.println(combinationSum.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    System.out.println(combinationSum.combinationSum(new int[] { 2, 3, 5 }, 8));
  }
}
