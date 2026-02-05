/* vienhuynhemc */
import java.util.Arrays;

public class TransformedArray {

  public int[] constructTransformedArray(int[] nums) {
    final int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      final int step = (i + nums[i]) % nums.length;
      result[i] = step < 0 ? nums[nums.length + step] : nums[step];
    }

    return result;
  }

  static void main() {
    final var test = new TransformedArray();
    System.out.println(Arrays.toString(test.constructTransformedArray(new int[] { 3, -2, 1, 1 })));
  }
}
