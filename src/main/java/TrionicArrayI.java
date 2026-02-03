/* vienhuynhemc */
public class TrionicArrayI {

  public boolean isTrionic(int[] nums) {
    int reverseCount = 0;
    boolean isIncrease = true;

    for (int i = 1; i < nums.length; i++) {
      if (isIncrease) {
        if (nums[i] < nums[i - 1]) {
          reverseCount++;
          isIncrease = false;
        }
      } else {
        if (nums[i] > nums[i - 1]) {
          reverseCount++;
          isIncrease = true;
        }
      }

      if (reverseCount > 2) {
        return false;
      }
    }

    return reverseCount == 2;
  }

    static void main() {
        final var test = new TrionicArrayI();
        System.out.println(test.isTrionic(new int[]{2,1,3}));
    }
}
