/* vienhuynhemc */
public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0) return false;

    final int forward = x;
    int backward = 0;

    while (x > 0) {
      backward = backward * 10 + (x % 10);
      x /= 10;
    }

    return backward == forward;
  }
}
