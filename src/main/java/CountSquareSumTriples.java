/* vienhuynhemc */
public class CountSquareSumTriples {

  public int countTriples(int n) {
    int result = 0;

    for (int i = 1; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int powOfC = i * i + j * j;
        int c = (int) Math.sqrt(powOfC);
        if (c <= n && c * c == powOfC) {
          result += 2;
        }
      }
    }

    return result;
  }
}
