/* vienhuynhemc */
public class ReverseString {

  public void reverseString(char[] s) {
    int range = s.length / 2;
    for (int i = 0; i < range; i++) {
      int swapIndex = s.length - i - 1;
      char temp = s[i];

      s[i] = s[swapIndex];
      s[swapIndex] = temp;
    }
  }
}
