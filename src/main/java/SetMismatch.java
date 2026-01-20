/* vienhuynhemc */
public class SetMismatch {

  public int[] findErrorNums(int[] nums) {
    final int[] result = new int[2];

    final boolean[] visited = new boolean[nums.length];
    int sum = 0;
    int correctNessSum = 0;
    int startNumber = 1;
    int duplicateNumber = -1;
    for (int i : nums) {
      sum += i;
      correctNessSum += startNumber++;
      if (visited[i - 1]) {
        duplicateNumber = i;
      } else {
        visited[i - 1] = true;
      }
    }

    result[0] = duplicateNumber;
    result[1] = correctNessSum - (sum - duplicateNumber);

    return result;
  }
}
