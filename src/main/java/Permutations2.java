
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, 0, result);
        return result.stream().distinct().toList();
    }

    private void permuteUnique(int[] nums, int indexOfLock, List<List<Integer>> result) {
        if (indexOfLock == nums.length - 1) {
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for (int i = indexOfLock; i < nums.length; i++) {
            int temp = nums[indexOfLock];
            nums[indexOfLock] = nums[i];
            nums[i] = temp;
            permuteUnique(nums, indexOfLock + 1, result);
            nums[i] = nums[indexOfLock];
            nums[indexOfLock] = temp;
        }
    }

    public static void main(String[] args) {
        Permutations2 permutations = new Permutations2();
        System.out.println(permutations.permuteUnique(new int[]{1, 2, 3}));
        System.out.println(permutations.permuteUnique(new int[]{1, 1, 2}));
    }

}
