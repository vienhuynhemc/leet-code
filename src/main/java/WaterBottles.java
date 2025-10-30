/* vienhuynhemc */
public class WaterBottles {

  public int numWaterBottles(int numBottles, int numExchange) {
    int result = numBottles;

    int emptyBottles = numBottles;
    while (emptyBottles >= numExchange) {
      int newBottles = emptyBottles / numExchange;
      result += newBottles;

      emptyBottles = emptyBottles % numExchange;
      emptyBottles += newBottles;
    }

    return result;
  }
}
