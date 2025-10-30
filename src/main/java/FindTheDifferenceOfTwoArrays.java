
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> duplicates = new HashSet<>();
        for (int number : set2) {
            if (set1.contains(number)) {
                duplicates.add(number);
            }
        }
        for (int number : duplicates) {
            set1.remove(number);
            set2.remove(number);
        }
        return List.of(new ArrayList<>(set1), new ArrayList<>(set2));
    }

    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays findTheDifferenceOfTwoArrays = new FindTheDifferenceOfTwoArrays();
        System.out.println(findTheDifferenceOfTwoArrays.findDifference(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        System.out.println(findTheDifferenceOfTwoArrays.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

}
