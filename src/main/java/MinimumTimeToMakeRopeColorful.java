/* vienhuynhemc */
public class MinimumTimeToMakeRopeColorful {

  public int minCost(String colors, int[] neededTime) {
    int cost = 0;

    final char[] chars = colors.toCharArray();

    char prevChar = chars[0];
    int prevNeededTime = neededTime[0];

    for (int i = 1; i < chars.length; i++) {
      final char currChar = chars[i];
      if (currChar != prevChar) {
        prevChar = currChar;
        prevNeededTime = neededTime[i];
        continue;
      }

      if (neededTime[i] > prevNeededTime) {
        cost += prevNeededTime;
        prevNeededTime = neededTime[i];
      } else {
        cost += neededTime[i];
      }
    }

    return cost;
  }
}
