package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> storage = new ArrayList<>();

        int i = 0;
        int length = intervals.length;
        while (i < length) {
            if (intervals[i][1] >= newInterval[0]) {
                break;
            }
            storage.add(intervals[i]);
            i++;
        }

        int[] merging = new int[]{newInterval[0], newInterval[1]};
        while (i < length) {
            if (intervals[i][0] > newInterval[1]) {
                break;
            }
            merging[0] = Math.min(merging[0], intervals[i][0]);
            merging[1] = Math.max(merging[1], intervals[i][1]);
            i++;
        }
        storage.add(merging);

        while (i < length) {
            storage.add(intervals[i]);
            i++;
        }

        int[][] result = new int[storage.size()][];
        for (int j = 0; j < result.length; j++) {
            result[j] = storage.get(j);
        }

        return result;
    }

    public static void main(String[] args) {
        InsertInterval service = new InsertInterval();
        System.out.println(Arrays.deepToString(service.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(service.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }

}
