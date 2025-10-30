
public class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int left = 0;
        int right = 1;

        long count = 1;

        int previousVal = nums[0];
        while (right < n) {
            int curNum = nums[right];

            if (curNum != previousVal) {
                count += right - left + 1;
            } else {
                count++;
                while (left < right) {
                    left++;
                }
            }

            previousVal = curNum;
            right++;
        }

        return count;
    }

    static void main() {
        final var handler = new CountAlternatingSubarrays();
        System.out.println(handler.countAlternatingSubarrays(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1}));
    }
}
