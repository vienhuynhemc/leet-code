/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

  public List<String> buildArray(int[] target, int n) {
    final List<String> result = new ArrayList<>();

    int start = 0;
    for (int i : target) {
      while (true) {
        start++;
        result.add("Push");
        if (start != i) {
          result.add("Pop");
          continue;
        }

        break;
      }
    }

    return result;
  }
}
