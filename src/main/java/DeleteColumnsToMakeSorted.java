/* vienhuynhemc */
public class DeleteColumnsToMakeSorted {

  public int minDeletionSize(String[] strs) {
    char[] chars = new char[strs[0].length()];
    boolean[] checkedIndex = new boolean[strs[0].length()];
    int columnNeedToRemove = 0;
    for (String s : strs) for (int i = 0; i < chars.length; i++) if (!checkedIndex[i]) if (
      chars[i] == '\u0000'
    ) chars[i] = s.charAt(i);
    else {
      if (s.charAt(i) >= chars[i]) chars[i] = s.charAt(i);
      else {
        checkedIndex[i] = true;
        columnNeedToRemove++;
      }
    }
    return columnNeedToRemove;
  }

  public static void main(String[] args) {
    DeleteColumnsToMakeSorted deleteColumnsToMakeSorted = new DeleteColumnsToMakeSorted();
    System.out.println(deleteColumnsToMakeSorted.minDeletionSize(new String[] { "cba", "daf", "ghi" }));
    System.out.println(deleteColumnsToMakeSorted.minDeletionSize(new String[] { "a", "b" }));
    System.out.println(deleteColumnsToMakeSorted.minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
    System.out.println(deleteColumnsToMakeSorted.minDeletionSize(new String[] { "rrjk", "furt", "guzm" }));
  }
}
