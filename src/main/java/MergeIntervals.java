package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> data = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0])).toList();
        List<int[]> storage = new ArrayList<>();

        int i = 1;
        int start = data.get(0)[0];
        int end = data.get(0)[1];
        while (i < intervals.length) {
            if (data.get(i)[0] <= end) {
                end = Math.max(end, data.get(i)[1]);
                i++;
                continue;
            }

            storage.add(new int[]{start, end});
            start = data.get(i)[0];
            end = data.get(i)[1];
            i++;
        }
        if (start != -1) {
            storage.add(new int[]{start, end});
        }

        int[][] result = new int[storage.size()][];
        for (int j = 0; j < result.length; j++) {
            result[j] = storage.get(j);
        }

        return result;
    }

    public static void main(String[] args) {
        MergeIntervals service = new MergeIntervals();
        System.out.println(Arrays.deepToString(service.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(service.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(service.merge(new int[][]{{1, 4}, {0, 4}})));
        System.out.println(Arrays.deepToString(service.merge(new int[][]{{1, 4}, {2, 3}})));
    }

}
