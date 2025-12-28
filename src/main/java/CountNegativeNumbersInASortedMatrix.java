/* vienhuynhemc */
public class CountNegativeNumbersInASortedMatrix {

  public int countNegatives(int[][] grid) {
    int result = 0;

    for (int[] ints : grid) {
      for (int anInt : ints) {
        if (anInt < 0) {
          result++;
        }
      }
    }

    return result;
  }
}
