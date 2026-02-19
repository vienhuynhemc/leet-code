/* vienhuynhemc */
import java.util.Arrays;

public class BoatsToSavePeople {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int left = 0;
    int right = people.length - 1;

    int result = 0;

    while (left <= right) {
      if (left < right && people[left] + people[right] <= limit) {
        left++;
      }

      right--;
      result++;
    }

    return result;
  }
}
