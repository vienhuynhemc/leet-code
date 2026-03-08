/* vienhuynhemc */
public class FindUniqueBinaryString {

  public String findDifferentBinaryString(String[] nums) {
    final StringBuilder resultBuilder = new StringBuilder();

    for (int i = 0; i < nums.length; i++) resultBuilder.append(nums[i].charAt(i) == '1' ? '0' : '1');

    return resultBuilder.toString();
  }
}
