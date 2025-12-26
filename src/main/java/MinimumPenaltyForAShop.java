/* vienhuynhemc */
public class MinimumPenaltyForAShop {

  public int bestClosingTime(String customers) {
    final char[] visitLogs = customers.toCharArray();
    final int[] penalties = getPenalties(visitLogs);

    int minPenalty = Integer.MAX_VALUE;
    int result = Integer.MAX_VALUE;
    int currentPenalty = 0;

    for (int i = 0; i < visitLogs.length; i++) {
      int penalty = penalties[i] + currentPenalty;
      if (penalty < minPenalty) {
        minPenalty = penalty;
        result = i;
      }

      if (visitLogs[i] == 'N') {
        currentPenalty++;
      }
    }

    return currentPenalty < minPenalty ? visitLogs.length : result;
  }

  private int[] getPenalties(char[] visitLogs) {
    final int[] penalties = new int[visitLogs.length];

    int index = visitLogs.length - 1;
    int penalty = 0;
    while (index >= 0) {
      final char visitLog = visitLogs[index];
      if (visitLog == 'Y') {
        penalty++;
      }

      penalties[index--] = penalty;
    }

    return penalties;
  }

  static void main() {
    final MinimumPenaltyForAShop m = new MinimumPenaltyForAShop();
    System.out.println(m.bestClosingTime("YYNY"));
  }
}
