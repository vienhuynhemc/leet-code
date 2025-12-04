/* vienhuynhemc */
public class CountCollisionsOnARoad {

  public int countCollisions(String directions) {
    final char[] chars = directions.toCharArray();

    int result = chars.length;

    int left = 0;
    while (left < chars.length) {
      if (chars[left] == 'L') {
        result--;
        left++;
        continue;
      }

      break;
    }

    if (result == 0) {
      return 0;
    }

    int right = chars.length - 1;
    while (right > -1) {
      if (chars[right] == 'R') {
        result--;
        right--;
        continue;
      }

      break;
    }

    if (result == 0) {
      return 0;
    }

    for (int i = left; i <= right; i++) {
      if (chars[i] == 'S') {
        result--;
      }
    }

    return result;
  }
}
