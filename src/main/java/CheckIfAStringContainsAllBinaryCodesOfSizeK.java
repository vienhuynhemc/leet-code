/* vienhuynhemc */
import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

  public boolean hasAllCodes(String s, int k) {
    final Set<String> binaryCodesOfSizeK = new HashSet<>();

    for (int i = 0; i <= s.length() - k; i++) binaryCodesOfSizeK.add(s.substring(i, i + k));

    return binaryCodesOfSizeK.size() == Math.pow(2, k);
  }

  static void main() {
    final var tester = new CheckIfAStringContainsAllBinaryCodesOfSizeK();
    System.out.println(tester.hasAllCodes("00110", 2));
  }
}
