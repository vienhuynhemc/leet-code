import loader.LoadArrayHelper;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(piles.length, Comparator.reverseOrder());
        for (int pile : piles) {
            priorityQueue.add(pile);
        }
        while (k > 0 && !priorityQueue.isEmpty()) {
            int value = priorityQueue.poll();
            value -= Math.floor((double) value / 2);
            if (value != 0) {
                priorityQueue.add(value);
            }
            k--;
        }
        int result = 0;
        while (!priorityQueue.isEmpty()) {
            result += priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal removeStonesToMinimizeTheTotal = new RemoveStonesToMinimizeTheTotal();
        System.out.println(removeStonesToMinimizeTheTotal.minStoneSum(new int[]{5, 4, 9}, 2));
        System.out.println(removeStonesToMinimizeTheTotal.minStoneSum(new int[]{4, 3, 6, 7}, 3));
        int[] largeArray = LoadArrayHelper.getInstance().loadIntArrayFromFile("data/large-int-array.txt");
        long start = System.currentTimeMillis();
        System.out.println(removeStonesToMinimizeTheTotal.minStoneSum(largeArray, 98001));
        System.out.println("Time for run: " + (System.currentTimeMillis() - start));
        System.out.println(removeStonesToMinimizeTheTotal.minStoneSum(new int[]{1391, 5916}, 3));
        System.out.println(removeStonesToMinimizeTheTotal.minStoneSum(new int[]{2695, 9184, 2908, 3869, 3779, 391, 2896, 5328}, 10));
    }

}
