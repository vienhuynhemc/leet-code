/* vienhuynhemc */
public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int minBuy = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - minBuy);
      minBuy = Math.min(minBuy, prices[i]);
    }

    return maxProfit;
  }
}
