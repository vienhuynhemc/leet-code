/* vienhuynhemc */
public class MinimumChangesToMakeAlternatingBinaryString {

  public int minOperations(String s) {
    int changeCountsToMakeStringStartWithBitZero = 0;
    int changeCountsToMakeStringStartWithBitOne = 0;

    for (int i = 0; i < s.length(); i++) {
      final int bitOneCount = s.charAt(i) - '0';

      if (i % 2 == 0) {
        changeCountsToMakeStringStartWithBitZero += bitOneCount == 1 ? 0 : 1;
        changeCountsToMakeStringStartWithBitOne += bitOneCount;
      } else {
        changeCountsToMakeStringStartWithBitZero += bitOneCount;
        changeCountsToMakeStringStartWithBitOne += bitOneCount == 1 ? 0 : 1;
      }
    }

    return Math.min(changeCountsToMakeStringStartWithBitZero, changeCountsToMakeStringStartWithBitOne);
  }
}
