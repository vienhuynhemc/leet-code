/* vienhuynhemc */
public class MinimumCommonValue {

  public int getCommon(int[] nums1, int[] nums2) {
    int nums1Length = nums1.length;
    int nums2Length = nums2.length;

    if (nums1[nums1Length - 1] < nums2[0] || nums2[nums2Length - 1] < nums1[0]) {
      return -1;
    }

    int rangeArr1 = 0;
    int rangeArr2 = 0;

    while (rangeArr1 < nums1Length && rangeArr2 < nums2Length) {
      int num1 = nums1[rangeArr1];
      int num2 = nums2[rangeArr2];
      if (num1 == num2) {
        return num1;
      }

      if (num1 > num2) {
        rangeArr2++;
      } else {
        rangeArr1++;
      }
    }

    return -1;
  }
}
