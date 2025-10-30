/* vienhuynhemc */
public class NthTribonacciNumber {

  public int tribonacci(int n) {
    if (n == 0) return 0;
    else if (n == 1 || n == 2) return 1;
    else return helpTribonacci(3, n, 0, 1, 1);
  }

  public int helpTribonacci(int current, int expect, int firstValue, int secondValue, int thirdValue) {
    if (current == expect) return firstValue + secondValue + thirdValue;
    else return helpTribonacci(current + 1, expect, secondValue, thirdValue, firstValue + secondValue + thirdValue);
  }

  public static void main(String[] args) {
    NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();
    System.out.println(nthTribonacciNumber.tribonacci(4));
    System.out.println(nthTribonacciNumber.tribonacci(25));
    long startTime = System.currentTimeMillis();
    System.out.println(nthTribonacciNumber.tribonacci(35));
    System.out.println("Time after run with test case 35: " + (System.currentTimeMillis() - startTime));
  }
}
