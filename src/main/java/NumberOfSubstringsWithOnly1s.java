/* vienhuynhemc */
public class NumberOfSubstringsWithOnly1s {

  public int numSub(String s) {
    final int MOD = 1000000007;
    final char[] chars = s.toCharArray();

    long result = 0;
    long countAdjacent1s = 0;

    for (char aChar : chars) {
      if (aChar == '1') {
        countAdjacent1s++;
        continue;
      }

      result = (result + (countAdjacent1s * (countAdjacent1s + 1)) / 2) % MOD;
      countAdjacent1s = 0;
    }

    result = (result + (countAdjacent1s * (countAdjacent1s + 1)) / 2) % MOD;

    return (int) result;
  }
}
