import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int value : nums)
            if (!set.contains(value))
                set.add(value);
            else
                return true;
        return false;
    }

}
