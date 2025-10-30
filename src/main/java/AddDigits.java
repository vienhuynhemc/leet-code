/* vienhuynhemc */
import java.util.ArrayList;
import java.util.List;

public class AddDigits {

  public int addDigits(int num) {
    if (num == 0) {
      return 0;
    }
    List<Integer> array = new ArrayList<>();
    while (num > 0) {
      array.add(num % 10);
      num /= 10;
    }
    if (array.size() == 1) {
      return array.get(0);
    }
    return this.addDigits(array.stream().mapToInt(value -> value).sum());
  }

  public static void main(String[] args) {
    AddDigits addDigits = new AddDigits();
    System.out.println(addDigits.addDigits(38));
    System.out.println(addDigits.addDigits(0));
  }
}
