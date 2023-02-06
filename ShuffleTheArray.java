public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        int x = 0;
        int y = n;
        for (int i = 0; i < result.length; i++)
            if (i % 2 == 0) {
                result[i] = nums[x];
                x++;
            } else {
                result[i] = nums[y];
                y++;
            }
        return result;
    }

}
