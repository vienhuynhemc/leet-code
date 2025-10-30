
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public long countSubarrays(int[] nums, int k) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int n = nums.length;

        int left = -1;
        int right = 0;

        int count = 0;

        long totalSubarray = 0;

        while (right < n) {
            int num = nums[right];
            if (num == max) {
                count++;

                if (count >= k) {
                    while (nums[++left] != max) ;
                }
            }

            if (count >= k) {
                totalSubarray += left + 1;
            }

            right++;
        }

        return totalSubarray;
    }

    static void main() {
        final var handler = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
        System.out.println(handler.countSubarrays(new int[]{21, 11, 13, 15, 16, 21, 8, 9, 6, 21}, 2));
    }

}
