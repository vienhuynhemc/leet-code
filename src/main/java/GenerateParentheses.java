/* vienhuynhemc */
import helper.LogTimeExecute;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    final List<String> result = new ArrayList<>();
    generateParenthesis(result, new StringBuilder(), 1, n * 2, 0, 0);
    return result;
  }

  private void generateParenthesis(
    List<String> result,
    StringBuilder par,
    int current,
    int numOfChars,
    int open,
    int close
  ) {
    if (current == numOfChars) {
      result.add(par.append(')').toString());
      par.deleteCharAt(current - 1);
      return;
    }
    if (open < numOfChars / 2) {
      generateParenthesis(result, par.append('('), current + 1, numOfChars, open + 1, close);
      par.deleteCharAt(current - 1);
    }
    if (close < open) {
      generateParenthesis(result, par.append(')'), current + 1, numOfChars, open, close + 1);
      par.deleteCharAt(current - 1);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    System.out.println(generateParentheses.generateParenthesis(1));
    System.out.println(generateParentheses.generateParenthesis(2));
    System.out.println(generateParentheses.generateParenthesis(3));
    System.out.println(generateParentheses.generateParenthesis(4));
    System.out.println(generateParentheses.generateParenthesis(5));
    LogTimeExecute.getInstance().log(unused -> generateParentheses.generateParenthesis(8));
  }
}
