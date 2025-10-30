
public class FindTheMiddleIndexInArray {

    public int findMiddleIndex(int[] nums) {
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
        FindTheMiddleIndexInArray findTheMiddleIndexInArray = new FindTheMiddleIndexInArray();
        System.out.println(findTheMiddleIndexInArray.findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
        System.out.println(findTheMiddleIndexInArray.findMiddleIndex(new int[]{1, -1, 4}));
        System.out.println(findTheMiddleIndexInArray.findMiddleIndex(new int[]{2, 5}));
    }

}
