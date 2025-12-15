/* vienhuynhemc */
public class NumberOfSmoothDescentPeriodsOfAStock {

  public long getDescentPeriods(int[] prices) {
    long result = 0;

    int lengthOfCurrentPeriod = 1;
    int currentPrice = prices[0];

    for (int i = 1; i < prices.length; i++) {
      if (currentPrice - prices[i] == 1) {
        lengthOfCurrentPeriod++;
        currentPrice = prices[i];
        continue;
      }

      result += calSubArray(lengthOfCurrentPeriod);

      lengthOfCurrentPeriod = 1;
      currentPrice = prices[i];
    }

    result += calSubArray(lengthOfCurrentPeriod);

    return result;
  }

  private long calSubArray(int length) {
    return ((long) length * (length + 1)) / 2;
  }
}
