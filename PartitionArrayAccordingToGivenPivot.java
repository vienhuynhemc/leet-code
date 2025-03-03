public class PartitionArrayAccordingToGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        final int[] lessNums = new int[nums.length];
        int lessNumsIndex = 0;

        final int[] greaterNums = new int[nums.length];
        int greaterNumsIndex = 0;

        final int[] equalNums = new int[nums.length];
        int equalNumsIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                greaterNums[greaterNumsIndex++] = nums[i];
            } else if (nums[i] == pivot) {
                equalNums[equalNumsIndex++] = nums[i];
            } else {
                lessNums[lessNumsIndex++] = nums[i];
            }
        }

        final int[] ans = new int[nums.length];

        int endLoop = lessNumsIndex;
        int start = 0;
        for (int i = start; i < endLoop; i++) {
            ans[i] = lessNums[i];
        }

        endLoop += equalNumsIndex;
        start = lessNumsIndex;
        for (int i = start; i < endLoop; i++) {
            ans[i] = equalNums[i - start];
        }

        endLoop += greaterNumsIndex;
        start += equalNumsIndex;
        for (int i = start; i < endLoop; i++) {
            ans[i] = greaterNums[i - start];
        }

        return ans;
    }

}
