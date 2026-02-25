/* vienhuynhemc */
import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits {

  public int[] sortByBits(int[] arr) {
    final Integer[] sorted = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++) sorted[i] = arr[i];

    final Comparator<Integer> bitComparator = (n, m) -> {
      final int bit1CountOfN = count1Bits(n);
      final int bit1CountOfM = count1Bits(m);

      return bit1CountOfN == bit1CountOfM ? n - m : bit1CountOfN - bit1CountOfM;
    };
    Arrays.sort(sorted, bitComparator);

    final int[] result = new int[arr.length];
    for (int i = 0; i < sorted.length; i++) result[i] = sorted[i];

    return result;
  }

  private int count1Bits(int number) {
    int result = 0;

    while (number > 0) {
      result += number % 2 == 1 ? 1 : 0;
      number /= 2;
    }

    return result;
  }

  static void main() {
    final var tester = new SortIntegersByTheNumberOf1Bits();
    System.out.println(Arrays.toString(tester.sortByBits(new int[] { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 })));
  }
}
