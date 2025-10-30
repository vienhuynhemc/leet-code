/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> pascalsTriangle = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      if (i == 0) {
        row.add(1);
        pascalsTriangle.add(row);
        continue;
      }

      if (i == 1) {
        row.add(1);
        row.add(1);
        pascalsTriangle.add(row);
        continue;
      }

      List<Integer> aboveRow = pascalsTriangle.get(i - 1);
      for (int j = 0; j < i + 1; j++) {
        if (j == 0 || j == i) {
          row.add(1);
          continue;
        }

        row.add(aboveRow.get(j - 1) + aboveRow.get(j));
      }

      pascalsTriangle.add(row);
    }

    return pascalsTriangle;
  }

  public static void main(String[] args) {
    PascalsTriangle service = new PascalsTriangle();
    System.out.println(service.generate(1));
    System.out.println(service.generate(2));
    System.out.println(service.generate(3));
    System.out.println(service.generate(4));
    System.out.println(service.generate(5));
    System.out.println(service.generate(6));
  }
}
