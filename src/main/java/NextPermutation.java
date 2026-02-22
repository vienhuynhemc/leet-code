/* vienhuynhemc */
public class NextPermutation {

  public void nextPermutation(int[] nums) {
    if (nums.length < 2) return;

    int index = nums.length - 2;
    while (index >= 0 && nums[index] >= nums[index + 1]) index--;

    if (index == -1) {
      reverse(nums, 0, nums.length - 1);
      return;
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > nums[index]) {
        swap(nums, index, i);
        reverse(nums, index + 1, nums.length - 1);
        return;
      }
    }
  }

  private void reverse(int[] nums, int start, int end) {
    final int mid = (end - start) / 2;
    for (int i = start; i <= start + mid; i++) swap(nums, i, end + start - i);
  }

  private void swap(int[] nums, int i, int j) {
    final int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  static void main() {
    final var test = new NextPermutation();
    test.nextPermutation(new int[] { 3, 1, 2 });
  }
}
