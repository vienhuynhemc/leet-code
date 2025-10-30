
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int absoluteVal = Math.abs(nums[i]);
            int idx = absoluteVal - 1;

            if (nums[idx] < 0) {
                duplicates.add(absoluteVal);
            } else {
                nums[idx] = -nums[idx];
            }
        }

        return duplicates;
    }

}
