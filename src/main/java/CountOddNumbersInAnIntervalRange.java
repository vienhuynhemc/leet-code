/* vienhuynhemc */
public class CountOddNumbersInAnIntervalRange {

  public int countOdds(int low, int high) {
    return low % 2 == 1 ? ((high - low) / 2) + 1 : (high - low + 1) / 2;
  }
}
