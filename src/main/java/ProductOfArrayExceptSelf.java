/* vienhuynhemc */
public class ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;

    int[] leftProducts = new int[length];
    int sum = 1;
    for (int i = 1; i < length; i++) {
      sum *= nums[i - 1];
      leftProducts[i] = sum;
    }

    int[] rightProducts = new int[length];
    sum = 1;
    for (int i = length - 2; i > -1; i--) {
      sum *= nums[i + 1];
      rightProducts[i] = sum;
    }

    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      if (i == 0) {
        result[i] = rightProducts[0];
      } else if (i == length - 1) {
        result[i] = leftProducts[length - 1];
      } else {
        result[i] = leftProducts[i] * rightProducts[i];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ProductOfArrayExceptSelf handler = new ProductOfArrayExceptSelf();
    System.out.println(handler.productExceptSelf(new int[] { 1, 2, 3, 4 }));
  }
}
