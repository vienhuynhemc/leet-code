
public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] data = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    data[i][j] = data[i - 1][j - 1] + 1;
                    continue;
                }
                data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);
            }
        }
        return data[nums1.length][nums2.length];
    }

}
