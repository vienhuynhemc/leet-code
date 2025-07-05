package src.main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        final Set<Integer> set = new HashSet<>();
        final int[] ans = new int[A.length];
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                count++;
            } else {
                if (set.contains(A[i])) {
                    count++;
                } else {
                    set.add(A[i]);
                }

                if (set.contains(B[i])) {
                    count++;
                } else {
                    set.add(B[i]);
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    public static void main(String[] args) {
        final FindThePrefixCommonArrayOfTwoArrays test = new FindThePrefixCommonArrayOfTwoArrays();
        System.out.println(Arrays.toString(test.findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(test.findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})));
    }

}
