/* vienhuynhemc */
public class IntersectionOfTwoArrays {

  public int[] intersection(int[] nums1, int[] nums2) {
    boolean[] dp = new boolean[1001];
    for (int i : nums1) {
      dp[i] = true;
    }

    boolean[] intersections = new boolean[1001];
    int intersectCount = 0;
    for (int i : nums2) {
      if (dp[i] && !intersections[i]) {
        intersections[i] = true;
        intersectCount++;
      }
    }

    int[] result = new int[intersectCount];
    int k = 0;
    for (int i = 0; i < intersections.length; i++) {
      if (intersections[i]) {
        result[k] = i;
        k++;
      }
    }

    return result;
  }
}
