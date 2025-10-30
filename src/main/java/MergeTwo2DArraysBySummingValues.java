/* vienhuynhemc */
public class MergeTwo2DArraysBySummingValues {

  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    int[][] db = new int[nums1.length + nums2.length][2];
    int length = 0;

    int indexArrayOne = 0;
    int indexArrayTwo = 0;
    while (indexArrayOne < nums1.length || indexArrayTwo < nums2.length) {
      if (indexArrayOne == nums1.length) {
        db[length][0] = nums2[indexArrayTwo][0];
        db[length][1] = nums2[indexArrayTwo][1];
        indexArrayTwo++;
      } else if (indexArrayTwo == nums2.length) {
        db[length][0] = nums1[indexArrayOne][0];
        db[length][1] = nums1[indexArrayOne][1];
        indexArrayOne++;
      } else {
        if (nums1[indexArrayOne][0] > nums2[indexArrayTwo][0]) {
          db[length][0] = nums2[indexArrayTwo][0];
          db[length][1] = nums2[indexArrayTwo][1];
          indexArrayTwo++;
        } else if (nums1[indexArrayOne][0] == nums2[indexArrayTwo][0]) {
          db[length][0] = nums1[indexArrayOne][0];
          db[length][1] = nums1[indexArrayOne][1] + nums2[indexArrayTwo][1];
          indexArrayOne++;
          indexArrayTwo++;
        } else {
          db[length][0] = nums1[indexArrayOne][0];
          db[length][1] = nums1[indexArrayOne][1];
          indexArrayOne++;
        }
      }
      length++;
    }

    final int[][] ans = new int[length][2];
    for (int i = 0; i < length; i++) {
      ans[i] = db[i];
    }
    return ans;
  }
}
