public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int rangeAttribute = 0;
        int result = -1;
        int sumOfLeft = 0;
        int sumOfRight = 0;
        while (rangeAttribute < nums.length) {
            if (rangeAttribute == 0)
                for (int i = rangeAttribute + 1; i < nums.length; i++)
                    sumOfRight += nums[i];
            else {
                sumOfRight -= nums[rangeAttribute];
                sumOfLeft += nums[rangeAttribute - 1];
            }
            if (sumOfLeft == sumOfRight)
                return rangeAttribute;
            rangeAttribute++;
        }
        return result;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{2, 1, -1}));
    }

}
