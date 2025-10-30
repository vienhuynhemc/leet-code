
import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        final Map<Integer, Integer> map = new TreeMap<>();

        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        while (!map.isEmpty()) {
            final Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next();
            if (firstEntry.getValue() == 1) {
                map.remove(firstEntry.getKey());
            } else {
                map.put(firstEntry.getKey(), firstEntry.getValue() - 1);
            }

            int end = firstEntry.getKey() + groupSize;
            for (int i = firstEntry.getKey() + 1; i < end; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }

                int value = map.get(i);
                if (value == 1) {
                    map.remove(i);
                } else {
                    map.put(i, value - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final HandOfStraights hs = new HandOfStraights();
        System.out.println(hs.isNStraightHand(new int[]{8, 8, 9, 7, 7, 7, 6, 7, 10, 6}, 2));
    }

}
