package src.main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> weights = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            weights.put(arr2[i], i);
        }

        for (int i = 0; i < arr1.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr1.length - i - 1; j++) {
                final int first = arr1[j];
                final int second = arr1[j + 1];

                final int firstWeight = weights.getOrDefault(first, 1001);
                final int secondWeight = weights.getOrDefault(second, 1001);

                if (firstWeight == secondWeight) {
                    if (first > second) {
                        swap(arr1, j, j + 1);
                        swapped = true;
                    }
                } else if (firstWeight > secondWeight) {
                    swap(arr1, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return arr1;
    }

    private void swap(int[] arr, int i, int j) {
        final int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        final RelativeSortArray relativeSortArray = new RelativeSortArray();
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
    }

}
