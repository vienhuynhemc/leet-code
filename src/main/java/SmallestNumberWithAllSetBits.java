/* vienhuynhemc */
public class SmallestNumberWithAllSetBits {

  public int smallestNumber(int n) {
    int result = 1;
    int temp = 1;

    while (result < n) {
      temp *= 2;
      result += temp;
    }

    return result;
  }
}
