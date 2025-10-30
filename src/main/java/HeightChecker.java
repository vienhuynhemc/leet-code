
import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        final int[] sorted = heights.clone();
        Arrays.sort(sorted);

        int count = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }

}
