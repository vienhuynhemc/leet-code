
import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int index = this.binarySearch(nums, 0, nums.length - 1, target);
        int startPosition = index;
        int endPosition = index;
        if (startPosition != -1) {
            while (startPosition > 0) {
                if (nums[startPosition - 1] != target) {
                    break;
                }
                startPosition--;
            }
            while (endPosition < nums.length - 1) {
                if (nums[endPosition + 1] != target) {
                    break;
                }
                endPosition++;
            }
        }
        return new int[]{startPosition, endPosition};
    }

    private int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{}, 0)));
    }

}
