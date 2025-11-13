/* vienhuynhemc */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {

  public int maxOperations(String s) {
    final char[] chars = s.toCharArray();
    final int[] walls = new int[chars.length + 1];

    int recentWall = -1;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '0') {
        continue;
      }

      if (i - recentWall > 1) {
        walls[i] = 1;
      }

      recentWall = i;
    }

    if (chars.length - recentWall > 1) {
      walls[chars.length] = 1;
    }

    int result = 0;
    int numberOfWalls = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '1') {
        numberOfWalls++;
      }

      if (walls[i] == 1) {
        result += numberOfWalls - 1;
      }
    }

    if (walls[chars.length] == 1) {
      result += numberOfWalls;
    }

    return result;
  }
}
