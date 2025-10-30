/* vienhuynhemc */
import helper.LoadArray;
import helper.LogTimeExecute;
import java.util.Arrays;

public class FindTheLongestValidObstacleCourseAtEachPosition {

  public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    int[] dp = new int[obstacles.length];
    int[] result = new int[obstacles.length];
    int currentIndexOfDp = 0;
    for (int i = 0; i < obstacles.length; i++) {
      int index = bisectRight(dp, obstacles[i], 0, currentIndexOfDp);
      if (index < currentIndexOfDp) {
        dp[index] = obstacles[i];
      } else {
        dp[currentIndexOfDp] = obstacles[i];
        currentIndexOfDp++;
      }
      result[i] = index + 1;
    }
    return result;
  }

  public int bisectRight(int[] array, int x, int fromIndex, int toIndex) {
    if (toIndex == 0) {
      return 0;
    }
    if (x < array[fromIndex]) {
      return fromIndex;
    }
    if (x > array[toIndex - 1]) {
      return toIndex;
    }
    while (true) {
      if (fromIndex + 1 == toIndex) {
        return toIndex;
      }
      int mi = (toIndex + fromIndex) / 2;
      if (x < array[mi]) {
        toIndex = mi;
      } else {
        fromIndex = mi;
      }
    }
  }

  static void main() {
    FindTheLongestValidObstacleCourseAtEachPosition findTheLongestValidObstacleCourseAtEachPosition =
      new FindTheLongestValidObstacleCourseAtEachPosition();
    System.out.println(
      Arrays.toString(
        findTheLongestValidObstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(new int[] { 1, 2, 3, 2 })
      )
    );
    System.out.println(
      Arrays.toString(
        findTheLongestValidObstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(new int[] { 2, 2, 1 })
      )
    );
    System.out.println(
      Arrays.toString(
        findTheLongestValidObstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(
          new int[] { 3, 1, 5, 6, 4, 2 }
        )
      )
    );
    int[] array = LoadArray.getInstance()
      .loadIntArrayFromFile("src/main/resources/test-data/find-the-longest-valid-obstacle-course-at-each-position.txt");
    LogTimeExecute.getInstance()
      .log(unused -> findTheLongestValidObstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(array));
    int[] array2 = LoadArray.getInstance()
      .loadIntArrayFromFile(
        "src/main/resources/test-data/find-the-longest-valid-obstacle-course-at-each-position-2.txt"
      );
    LogTimeExecute.getInstance()
      .log(unused -> findTheLongestValidObstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(array2));
  }
}
