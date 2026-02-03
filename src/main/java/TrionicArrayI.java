/* vienhuynhemc */
public class TrionicArrayI {

  public boolean isTrionic(int[] nums) {
    int p = 0;

    while (p < nums.length - 1 && nums[p] < nums[p + 1]) p++;
    if (p == 0) return false;

    int q = p;
    while (q < nums.length - 1 && nums[q] > nums[q + 1]) q++;
    if (q == p) return false;

    int n = q;
    while (n < nums.length - 1 && nums[n] < nums[n + 1]) n++;
    if (n == q) return false;

    return n == nums.length - 1;
  }

  static void main() {
    final var test = new TrionicArrayI();
    System.out.println(test.isTrionic(new int[] { 3, 7, 1 }));
  }
}
