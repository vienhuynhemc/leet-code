/* vienhuynhemc */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

  public boolean checkOnesSegment(String s) {
    boolean isStartSegmentOfZero = false;

    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      if (!isStartSegmentOfZero && c == '0') isStartSegmentOfZero = true;
      if (isStartSegmentOfZero && c == '1') return false;
    }

    return true;
  }
}
