/* vienhuynhemc */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

  public int countPrimeSetBits(int left, int right) {
    int result = 0;

    for (int i = left; i <= right; i++) {
      final int setBits = countSetBits(i);
      if (isPrime(setBits)) result++;
    }

    return result;
  }

  private int countSetBits(int number) {
    int result = 0;

    while (number > 0) {
      result += number % 2;
      number /= 2;
    }

    return result;
  }

  private boolean isPrime(int number) {
    if (number < 2) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;

    for (int i = 3; i * i <= number; i += 2) {
      if (number % i == 0) return false;
    }

    return true;
  }

  static void main() {
    final var tester = new PrimeNumberOfSetBitsInBinaryRepresentation();
    System.out.println(tester.countPrimeSetBits(6, 10));
  }
}
